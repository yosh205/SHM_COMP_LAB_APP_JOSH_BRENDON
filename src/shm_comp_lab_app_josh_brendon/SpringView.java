/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author joshu
 */
public class SpringView {
    Pane springPane;
    Rectangle rectangle;
    Line spring;      
    
    public SpringView(double equilibriumY, double springStartY){
        rectangle = new Rectangle(30, 30, Color.DEEPSKYBLUE);
        rectangle.setX(185);
        rectangle.setY(equilibriumY);
        
        spring = new Line(200, springStartY, 200, equilibriumY);
        spring.setStrokeWidth(3);
        spring.setStroke(Color.GREY);
        
        springPane = new Pane(spring, rectangle);
    }
    
    public void updateView(double newY) {
        rectangle.setY(newY);

        spring.setEndY(rectangle.getY());
    }
    
    public Pane getSpringPane(){
        return springPane;
    }
    
}
