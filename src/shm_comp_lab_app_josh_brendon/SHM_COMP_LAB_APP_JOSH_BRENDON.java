/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        root.add(view.getWavePane(),0,0);
        root.add(setting.getControlPane(),0,1);

        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("SHM");
        stage.setScene(scene);
        stage.show();
    }
    
}
