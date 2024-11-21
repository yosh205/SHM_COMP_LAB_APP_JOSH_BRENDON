/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author joshu
 */
public class StartPage extends Pane{
    Label title = new Label("Simple Harmonic Motion");
    Button startbutton = new Button("Start");
        
    StartPage(){
        
        this.getChildren().addAll(title,startbutton);
    }
}
