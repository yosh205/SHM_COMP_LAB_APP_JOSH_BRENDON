/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author bdmmc
 */
public class SpringController {
    SpringModel modelspring;
    SpringView viewspring;
    Timeline timeline;
    
    public SpringController(SpringModel model, SpringView view) {
        this.modelspring = model;
        this.viewspring = view;

        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> {
            modelspring.update();
            double newY = modelspring.getEquilibriumY() + modelspring.getPosition();
            
            viewspring.updateView(newY);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        timeline.play();
    }
    
}
