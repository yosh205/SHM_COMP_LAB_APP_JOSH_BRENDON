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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

    @Override
    public void start(Stage stage) throws Exception {

        //model
        WaveModel model = new WaveModel(50,0,2*Math.PI/100);
        
        // Create the view
        WaveView view = new WaveView();
        
        //setting
        WaveSettingsView setting = new WaveSettingsView();

        // Create the controller
        SHMController controller = new SHMController(model,view,setting);

        // Set up the scene
        //We should use gridpane to easily separate the different panes and menubar
        GridPane root = new GridPane();
        
        BorderPane bp = new BorderPane();
        
        root.add(bp, 0, 0);
        
        MenuBar menuBar = new MenuBar();
        
        Menu fileMenu = new Menu("File");        
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem exitMenuItem = new MenuItem("Exit");
        
        fileMenu.getItems().addAll(newMenuItem,
                new SeparatorMenuItem(),
                exitMenuItem
        );   
        
        Menu wavesMenu = new Menu("Waves");
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
        
        bp.setTop(menuBar);
        
        newMenuItem.setOnAction(actionEvent -> {
            try {
                this.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(SHM_COMP_LAB_APP_JOSH_BRENDON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        root.add(view.getWavePane(),0,1);
        root.add(setting.getControlPane(),0,2);

        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("SHM");
        stage.setScene(scene);
        stage.show();
    }
    
}
