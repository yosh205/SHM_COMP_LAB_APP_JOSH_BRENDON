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
    WaveModel model;
    WaveView view;
    WaveSettingsView setting;
    private double phaseShift = 0;

    public SHMController(WaveModel model, WaveView view, WaveSettingsView setting) {
        this.model = model;
        this.view = view;
        this.setting = setting;

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
        
        //checkbox
        setting.getSineCheckBox().selectedProperty().addListener((obs, oldVal, newVal) -> updateWaves());
        setting.getCosineCheckBox().selectedProperty().addListener((obs, oldVal, newVal) -> updateWaves());

        // Set up a Timeline to animate the waves
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            updateWaves();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Method to update both sine and cosine waves
    private void updateWaves() {
        showWaves();
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

    // Method to update the sine wave path
    private void updateSineWave() {
        view.getSineWavePath().getElements().clear();
        view.getSineWavePath().getElements().add(new MoveTo(0, 100));

        for (double x = 0; x <= 600; x += 1) {
            double y = 100 + model.getAmplitude() * Math.sin(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getSineWavePath().getElements().add(new LineTo(x, y));
        }

        phaseShift += 0.1;
    }

    // Method to update the cosine wave path
    private void updateCosineWave() {
        view.getCosineWavePath().getElements().clear();
        view.getCosineWavePath().getElements().add(new MoveTo(0, 300));

        for (double x = 0; x <= 600; x += 1) {
            double y = 300 + model.getAmplitude() * Math.cos(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getCosineWavePath().getElements().add(new LineTo(x, y));
        }

        phaseShift += 0.1;
    }
}
    

