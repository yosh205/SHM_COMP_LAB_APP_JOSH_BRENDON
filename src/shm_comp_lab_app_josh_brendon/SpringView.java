/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author joshu
 */
public class SpringView {
    Pane SpringPane;
    
    public SpringView(){
        SpringPane = new Pane();
        SpringPane.setPrefSize(200, 400);
    }
    public Pane getSpring(){
        return SpringPane;
    }
}
