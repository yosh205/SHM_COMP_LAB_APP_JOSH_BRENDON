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
    Text firstpart = new Text("This is the help page where all application features are explained");
    Button backbutton = new Button("Back");
    
    AboutPage(){
        VBox content = new VBox(20);
        content.getChildren().addAll(firstpart,backbutton);
        this.getChildren().addAll(content);
    }
}
