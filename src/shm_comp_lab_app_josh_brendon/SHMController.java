/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.util.Duration;

/**
 *
 * @author joshu
 */
public class SHMController {
    boolean pausing = false;
    boolean sinecheckbox = false;
    boolean cosinecheckbox = false;
    WaveModel model;
    WaveView view;
    WaveSettingsView setting;
    AnimationButtonView buttons;
    private double phaseShift = 0;

    public SHMController(WaveModel model, WaveView view, WaveSettingsView setting, AnimationButtonView buttons) {
        this.model = model;
        this.view = view;
        this.setting = setting;
        this.buttons = buttons;

        // Set up listeners for the sliders
        setting.getAmplitudeSlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setAmplitude(newVal.doubleValue());
            updateWaves();
        });

        setting.getPhaseSlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setPhase(newVal.doubleValue());
            updateWaves();
        });

        setting.getFrequencySlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setAngular(newVal.doubleValue());
            updateWaves();
        });
        
        //Animation buttons
        buttons.pausebutton.setOnAction(e->{
            pausing = true;
        });
        buttons.startbutton.setOnAction(e->{
            pausing=false;
        });
        buttons.nextframe.setOnAction(e->{
            pausing=true;
            
            
            if(sinecheckbox==true)updateSineWave();
            if(cosinecheckbox==true)updateCosineWave();
            
        });
        buttons.lastframe.setOnAction(e->{
            pausing=true;
            
            if(sinecheckbox==true)lastSineWave();
            if(cosinecheckbox==true)lastCosineWave();
            
        });
        
        //checkbox
        setting.getSineCheckBox().selectedProperty().addListener((obs, oldVal, newVal) -> {updateWaves();
        sinecheckbox=true;});
        setting.getCosineCheckBox().selectedProperty().addListener((obs, oldVal, newVal) -> {updateWaves();
        cosinecheckbox=true;});

        // Set up a Timeline to animate the waves
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            updateWaves();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Method to update both sine and cosine waves
    void updateWaves() {
        if(pausing==false) showWaves();
    }
    
    //Show or not show paths
    void showWaves(){
        if (setting.getSineCheckBox().isSelected()) {
            updateSineWave();
        } else {
            view.getSineWavePath().getElements().clear();
        }

        if (setting.getCosineCheckBox().isSelected()) {
            updateCosineWave();
        } else {
            view.getCosineWavePath().getElements().clear();
        }
    }
    //Both methods that animates both waves
    //x value determines width of wave. we should make a method to fix the width
    // Method to update the sine wave path
    void updateSineWave() {
        view.getSineWavePath().getElements().clear();
        view.getSineWavePath().getElements().add(new MoveTo(0, 100));

        for (double x = 0; x <= 300; x += 1) {
            double y = 100 + model.getAmplitude() * Math.sin(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getSineWavePath().getElements().add(new LineTo(x, y));
        }

        phaseShift += 0.1;
    }

    // Method to update the cosine wave path
    void updateCosineWave() {
        view.getCosineWavePath().getElements().clear();
        view.getCosineWavePath().getElements().add(new MoveTo(0, 300));

        for (double x = 0; x <= 300; x += 1) {
            double y = 300 + model.getAmplitude() * Math.cos(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getCosineWavePath().getElements().add(new LineTo(x, y));
        }

        phaseShift += 0.1;
    }
    void lastSineWave(){
        view.getSineWavePath().getElements().clear();
        view.getSineWavePath().getElements().add(new MoveTo(0,100));
        
        for (double x = 0; x <= 300; x += 1) {
            double y = 100 + model.getAmplitude() * Math.sin(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getSineWavePath().getElements().add(new LineTo(x, y));
        }

        phaseShift -= 0.1;
    }
    void lastCosineWave(){
        view.getCosineWavePath().getElements().clear();
        view.getCosineWavePath().getElements().add(new MoveTo(0,300));
        
        for (double x = 0; x <= 300; x += 1) {
            double y = 300 + model.getAmplitude() * Math.cos(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getCosineWavePath().getElements().add(new LineTo(x, y));
        }

        
    }
    
}
    

