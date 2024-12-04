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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {

        //model
        WaveModel model = new WaveModel(50,0,2*Math.PI/100);
        
        // Create the view
        StartPage begin = new StartPage();
        AboutPage help = new AboutPage();
        WaveView view = new WaveView();
        InfoView iview = new InfoView();
        GraphView gview = new GraphView();
        AnimationButtonView abview = new AnimationButtonView();
        
        //setting
        WaveSettingsView setting = new WaveSettingsView();

        // Create the controller
        SHMController controller = new SHMController(model,iview,view,setting,abview,gview,scene);

        // Set up the scene
        GridPane root = new GridPane(); //This is all waves animation
        GridPane springarea = new GridPane();
        springarea.setPadding(new Insets(15,0,0,0));
        root.getStyleClass().add("grid-pane");
        springarea.getStyleClass().add("grid-pane");
        BorderPane bp = new BorderPane();
        
        //Adding gridpane to borderpane
        bp.setCenter(root);
        bp.setRight(springarea);
        
        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getStyleClass().add(".menu-bar");    
        
        //MenuItems
        Menu fileMenu = new Menu("File"); 
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem helpMenuItem = new MenuItem("Help");
        MenuItem exitMenuItem = new MenuItem("Exit");
        
        fileMenu.getItems().addAll(newMenuItem,
                //new SeparatorMenuItem(),
                helpMenuItem,
                //new SeparatorMenuItem(),
                exitMenuItem
        );   
        
        //Menu for changing panes
        Menu wavesMenu = new Menu("Graphs");
        MenuItem waveItem = new MenuItem("Switch Graph");
        
        wavesMenu.getItems().addAll(waveItem);
        
        //Menu for additional options
        Menu optionsMenu = new Menu("Options");
        Menu colourSchemeItem = new Menu("Appearance");
        MenuItem lightscheme = new MenuItem("Light Mode");
        MenuItem darkscheme = new MenuItem("Dark Mode");
        
        colourSchemeItem.getItems().addAll(lightscheme,darkscheme);
        optionsMenu.getItems().add(colourSchemeItem);
        
        
        
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(wavesMenu);
        menuBar.getMenus().add(optionsMenu);
        
        //set top of borderpane as menubar
        bp.setTop(menuBar);
        
        //New menuitem interaction
        newMenuItem.setOnAction(actionEvent -> {
            try {
                this.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(SHM_COMP_LAB_APP_JOSH_BRENDON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Help window
        Scene aboutscene = new Scene(help,900,600);
        //Help window interaction
        helpMenuItem.setOnAction(e->{stage.setScene(aboutscene);});
        //Exit window interaction
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        //Changing between graph and waves
        waveItem.setOnAction(actionEvent -> {
            try {
                flag1=!flag1;
                if(flag1){root.add(view.getWavePane(),0,2);
                root.getChildren().remove(gview.getGraph());}
                else {root.add(gview.getGraph(),0,2);
                root.getChildren().remove(view.getWavePane());
                }
        
            } catch(Exception ex) {
                Logger.getLogger(SHM_COMP_LAB_APP_JOSH_BRENDON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
             
        //Spring animation pane and controls
        BorderPane root1 = new BorderPane();
        
        //Textfields spring
        TextField springConstantField = new TextField();
        TextField massField = new TextField();
        TextField equilibriumYField = new TextField();

        //Labels spring
        Label springConstantLabel = new Label("Spring Constant (k):");
        Label massLabel = new Label("Mass (grams):");
        Label equilibriumYLabel = new Label("Equilibrium Position (y):");

        //Button spring
        Button startButton = new Button("Start Simulation");

        //Spring control input pane
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
        //simulationPane.setStyle("-fx-background-color: #f4f4f4;");
        simulationPane.getStyleClass().add("grid-pane");

        root1.setCenter(simulationPane);
        root1.setTop(inputPane);
        
        //Start spring control
        startButton.setOnAction(e -> {
            try {
                double springConstant = Double.parseDouble(springConstantField.getText());
                double mass = Double.parseDouble(massField.getText());
                double equilibriumY = Double.parseDouble(equilibriumYField.getText());
                
                if (springConstant <= 0 || springConstant >= 50 || mass <= 0 || equilibriumY < 0 || equilibriumY > 150) {
                throw new IllegalArgumentException("Values must be positive OR spring constant must be between 0 and 50 and equilibrium position needs to be between 0 and 100.");
                }
                

                SpringModel modelspring = new SpringModel(springConstant, mass, equilibriumY,model);
                SpringView viewspring = new SpringView(equilibriumY, 50);
                SpringController controllerspring = new SpringController(modelspring, viewspring);

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
        
        //Input gridpane
        GridPane contrl = new GridPane();
        contrl.add(setting.getControlPane(), 0, 0);
        contrl.add(iview.getInfoview(),1,0);
        
        //Titles
        Label wavegraph = new Label("Waves Animation");
        Pane wavetitle = new Pane(wavegraph);
        Label spring = new Label("Spring Animation");
        Pane springtitle = new Pane(spring);
        
        //Gridpane content for waves animation
        root.add(wavetitle,0,1);
        //root.add(springtitle,1,1);
        root.add(view.getWavePane(),0,2);
        //root.add(root1,1,2);
        root.add(abview,0,3);
        root.add(contrl,0,4);
        root.setVgap(10);
        root.setHgap(10);
        
        //Content for spring animation
        springarea.add(springtitle,0,1);
        springarea.add(root1,0,2);
        
        //Scene set up
        scene = new Scene(bp, 930, 640);
        Scene firstscene = new Scene(begin,250,250);
        begin.startbutton.setOnAction(e->{stage.setScene(scene);});
        help.backbutton.setOnAction(e->{stage.setScene(scene);});

        //CSS
        scene.getStylesheets().add(getClass().getResource("Light.css").toExternalForm());
        
        //Appearance
        view.getWavePane().getStyleClass().add("pane");
        
        //Light mode
        lightscheme.setOnAction(e->{
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("Light.css").toExternalForm());
        });
        
        //Dark mode
        darkscheme.setOnAction(e->{
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("Dark.css").toExternalForm());
        });
        
        stage.setResizable(false);
        stage.setTitle("Simple Harmonic Motion");
        stage.setScene(firstscene);
        stage.show();
    }
    
}
