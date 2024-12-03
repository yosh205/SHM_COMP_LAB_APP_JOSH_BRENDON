/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

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
    Line equilibriumposition;
    
    public SpringView(double equilibriumY, double springStartY){
        rectangle = new Rectangle(30, 30, Color.DEEPSKYBLUE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setX(135);
        rectangle.setY(equilibriumY);
        
        spring = new Line(150, springStartY, 150, equilibriumY);
        spring.setStrokeWidth(2);
        spring.setStroke(Color.BLACK);
        
        equilibriumposition = new Line(100,equilibriumY+150,200,equilibriumY+150);
        equilibriumposition.setStrokeWidth(2);
        equilibriumposition.setStroke(Color.LIGHTGRAY);
        springPane = new Pane(spring, rectangle,equilibriumposition);
        springPane.setPrefSize(300, 200);
    }
    
    public void updateView(double newY) {
        rectangle.setY(newY);

        spring.setEndY(rectangle.getY());
    }
    
    public Pane getSpringPane(){
        return springPane;
    }
    
}
