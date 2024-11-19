/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author joshu
 */
public class SHM_COMP_LAB_APP_JOSH_BRENDON extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    boolean flag1 = true;
    boolean flag2 = true;
    
    @Override
    public void start(Stage stage) throws Exception {

        //model
        WaveModel model = new WaveModel(50,0,2*Math.PI/100);
        
        // Create the view
        WaveView view = new WaveView();
        InfoView iview = new InfoView();
        GraphView gview = new GraphView();
        AnimationButtonView abview = new AnimationButtonView();
        
        //setting
        WaveSettingsView setting = new WaveSettingsView();

        // Create the controller
        SHMController controller = new SHMController(model,iview,view,setting,abview,gview);

        // Set up the scene
        GridPane root = new GridPane();
        root.getStyleClass().add("grid-pane");
        BorderPane bp = new BorderPane();
        
        //Adding gridpane to borderpane
        bp.setCenter(root);
        
        //Menu Bar
        MenuBar menuBar = new MenuBar();
            
        menuBar.getStyleClass().add("menu-bar");
        Menu fileMenu = new Menu("File");        
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem exitMenuItem = new MenuItem("Exit");
        
        fileMenu.getItems().addAll(newMenuItem,
                new SeparatorMenuItem(),
                exitMenuItem
        );   
        
        //Menu for changing panes
        Menu wavesMenu = new Menu("Windows");
        CheckMenuItem sinWaveMenuItem = new CheckMenuItem("Show Sine Wave");
        sinWaveMenuItem.setSelected(true);  
        CheckMenuItem cosWaveMenuItem = new CheckMenuItem("Show Cosine Wave");
        cosWaveMenuItem.setSelected(true);
        
        wavesMenu.getItems().addAll(sinWaveMenuItem,
                new SeparatorMenuItem(),
                cosWaveMenuItem
        );
        
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(wavesMenu);
        
        //set top of borderpane as menubar
        bp.setTop(menuBar);
        
        newMenuItem.setOnAction(actionEvent -> {
            try {
                this.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(SHM_COMP_LAB_APP_JOSH_BRENDON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        sinWaveMenuItem.setOnAction(actionEvent -> {
            try {
                flag1=!flag1;
                setting.sineCheckBox.setSelected(flag1);
            } catch(Exception ex) {
                Logger.getLogger(SHM_COMP_LAB_APP_JOSH_BRENDON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        cosWaveMenuItem.setOnAction(actionEvent -> {
            try {
                flag2=!flag2;
                setting.cosineCheckBox.setSelected(flag2);
            } catch(Exception ex) {
                Logger.getLogger(SHM_COMP_LAB_APP_JOSH_BRENDON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        BorderPane root1 = new BorderPane();

        TextField springConstantField = new TextField();
        TextField massField = new TextField();
        TextField equilibriumYField = new TextField();

        Label springConstantLabel = new Label("Spring Constant (k):");
        Label massLabel = new Label("Mass (grams):");
        Label equilibriumYLabel = new Label("Equilibrium Position (y):");

        Button startButton = new Button("Start Simulation");

        GridPane inputPane = new GridPane();
        inputPane.setPadding(new Insets(10));
        inputPane.setHgap(10);
        inputPane.setVgap(10);

        inputPane.add(springConstantLabel, 0, 0);
        inputPane.add(springConstantField, 1, 0);
        inputPane.add(massLabel, 0, 1);
        inputPane.add(massField, 1, 1);
        inputPane.add(equilibriumYLabel, 0, 2);
        inputPane.add(equilibriumYField, 1, 2);
        inputPane.add(startButton, 1, 3);

        StackPane simulationPane = new StackPane();
        simulationPane.setStyle("-fx-background-color: #f4f4f4;");

        root1.setTop(inputPane);
        root1.setCenter(simulationPane);

        startButton.setOnAction(e -> {
            try {
                double springConstant = Double.parseDouble(springConstantField.getText());
                double mass = Double.parseDouble(massField.getText());
                double equilibriumY = Double.parseDouble(equilibriumYField.getText());
                
                if (springConstant <= 0 || mass <= 0 || equilibriumY < 0) {
                throw new IllegalArgumentException("Values must be positive.");
                }
                
                System.out.println("Creating SpringModel...");
SpringModel modelspring = new SpringModel(springConstant, mass, equilibriumY,model);
System.out.println("SpringModel created: " + model);



                //SpringModel modelspring = new SpringModel(springConstant, mass, equilibriumY);
                SpringView viewspring = new SpringView(equilibriumY, 50);
                
                System.out.println("Passing SpringModel and SpringView to SpringController...");
SpringController controllerspring = new SpringController(modelspring, viewspring);
System.out.println("SpringController created: " + controller);
                //SpringController controllerspring = new SpringController(modelspring, viewspring);
                
                simulationPane.getChildren().clear();
                simulationPane.getChildren().add(viewspring.getSpringPane());

                controllerspring.start();

            } catch (NumberFormatException ex) {
                System.err.println("Error: Please enter valid numeric values.");
                springConstantField.setStyle("-fx-border-color: red;");
                massField.setStyle("-fx-border-color: red;");
                equilibriumYField.setStyle("-fx-border-color: red;");
            } catch (IllegalArgumentException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });
        
        root.add(view.getWavePane(),0,1);
        root.add(root1,1,1);
        root.add(gview.getGraph(),2,1);
        root.add(abview,0,2);
        root.add(setting.getControlPane(),0,3);
        root.add(iview.getInfoview(),1,3);

        Scene scene = new Scene(bp, 600, 500);
        scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        stage.setTitle("SHM");
        stage.setScene(scene);
        stage.show();
    }
    
}
