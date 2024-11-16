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
    GraphView gview;
    InfoView iview;
    WaveSettingsView setting;
    AnimationButtonView buttons;
    private double phaseShift = 0;

    public SHMController(WaveModel model, InfoView iview, WaveView view, WaveSettingsView setting, AnimationButtonView buttons, GraphView gview) {
        this.model = model;
        this.view = view;
        this.iview = iview;
        this.setting = setting;
        this.buttons = buttons;
        this.gview = gview;

        // Sliders
        
        //Amplitude
        setting.getAmplitudeSlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setAmplitude(newVal.doubleValue());
            iview.information(model.getAmplitude(), model.getAngular(), model.getPhase());
            updateWaves();
        });
        //Phase
        setting.getPhaseSlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setPhase(newVal.doubleValue());
            iview.information(model.getAmplitude(), model.getAngular(), model.getPhase());
            updateWaves();
        });
        //Angular Frequency
        setting.getFrequencySlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            model.setAngular(newVal.doubleValue());
            iview.information(model.getAmplitude(), model.getAngular(), model.getPhase());
            updateWaves();
        });
        
        //Animation Buttons
        
        //Pause
        buttons.pausebutton.setOnAction(e->{
            pausing = true;
        });
        //Start
        buttons.startbutton.setOnAction(e->{
            pausing=false;
        });
        //Next Frame
        buttons.nextframe.setOnAction(e->{
            pausing=true;
            if(sinecheckbox==true)updateSineWave();
            if(cosinecheckbox==true)updateCosineWave();
        });
        //Last Frame
        buttons.lastframe.setOnAction(e->{
            pausing=true;
            if(sinecheckbox==false)lastSineWave();
            if(cosinecheckbox==false)lastCosineWave();
        });
        
        //Checkbox
        
        //SineWave
        setting.getSineCheckBox().selectedProperty().addListener((obs, oldVal, newVal) -> {updateWaves();
        sinecheckbox=true;});
        //CosineWave
        setting.getCosineCheckBox().selectedProperty().addListener((obs, oldVal, newVal) -> {updateWaves();
        cosinecheckbox=true;});

        //Timeline
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            iview.information(model.getAmplitude(), model.getAngular(), model.getPhase());
            updateWaves();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        if(pausing==false)timeline.play();
    }

    // Update both sine and cosine waves
    void updateWaves() {
        if(!pausing){
        showWaves();
        }
    }
    
    //Show or not show paths
    void showWaves(){
        //SineWave
        if (setting.getSineCheckBox().isSelected()) {
            updateSineWave();
        } else {
            view.getSineWavePath().getElements().clear();
        }
        //Cosine Wave
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
    
    //To show last frame of sine wave
    void lastSineWave(){
        view.getSineWavePath().getElements().clear();
        view.getSineWavePath().getElements().add(new MoveTo(0,100));
        
        for (double x = 0; x <= 300; x += 1) {
            double y = 100 + model.getAmplitude() * Math.sin(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getSineWavePath().getElements().add(new LineTo(x, y));
        }

        phaseShift -= 0.1;
    }
    
    //To show last frame of cosine wave
    void lastCosineWave(){
        view.getCosineWavePath().getElements().clear();
        view.getCosineWavePath().getElements().add(new MoveTo(0,300));
        
        for (double x = 0; x <= 300; x += 1) {
            double y = 300 + model.getAmplitude() * Math.cos(model.getAngular() * x + model.getPhase() + phaseShift);
            view.getCosineWavePath().getElements().add(new LineTo(x, y));
        }

        
    }
    
    void updategraph(){
        
    }
    
    
}
