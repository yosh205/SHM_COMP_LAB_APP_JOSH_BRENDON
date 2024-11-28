/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author joshu
 */
public class AnimationButtonView extends HBox{
    Button startbutton = new Button("Start");
    Button pausebutton = new Button("Pause");
    Button nextframe = new Button("+1");
    Button lastframe = new Button("-1");
    
    AnimationButtonView(){
        this.setSpacing(10);
        this.getChildren().addAll(startbutton,pausebutton);
    }
    public Button getPause(){
        return pausebutton;
    }
    
}
