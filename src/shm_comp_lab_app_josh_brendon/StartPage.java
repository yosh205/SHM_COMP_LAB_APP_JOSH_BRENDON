/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author joshu
 */
public class StartPage extends Pane{
    Label title = new Label("Simple Harmonic Motion");
    Button startbutton = new Button("Start");
    Text authors = new Text("By Joshua Indig and Brendon McConnell");
        
    StartPage(){
        title.setFont(new Font(20));
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(title,authors,startbutton);
        vbox.setAlignment(Pos.CENTER);
        this.getChildren().addAll(vbox);
    }
}
