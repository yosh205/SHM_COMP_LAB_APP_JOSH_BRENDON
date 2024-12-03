/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author joshu
 */
public class AboutPage extends Pane{
    Text firstpart = new Text("This is the help page where all application features are explained. More information provided in the user guide");
    Text mainpart = new Text("Simple Harmonic Motion of a Spring is a physics concept of a periodic movement of an object. In this program, springs are used to represent this periodic movement.\nIn addition, an animation of the waves and its representing graph is also used."
            + "\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \nWave Animation:\nAmplitude affects the height.\nPhase Shift lets the user move the wave left or right.\nAngular Frequency affects the period. "
            + "\n -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n Spring animation:\n"
            + "Spring Constant affects stiffness of spring \nMass affects how spring moves regarding to gravity\nEquilibrium Position places the line where periodic movement will happen"
            + "\n --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    Button backbutton = new Button("Back");
    
    AboutPage(){
        VBox content = new VBox(20);
        content.getChildren().addAll(firstpart,mainpart,backbutton);
        this.getChildren().addAll(content);
    }
}
