/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

/**
 *
 * @author joshu
 */
public class WaveSettingsView{
    Slider amplitudeSlider;
    Slider phaseSlider;
    Slider frequencySlider;
    GridPane controlPane;
    CheckBox sineCheckBox;
    CheckBox cosineCheckBox;
    
    public WaveSettingsView(){
    // Initialize the control pane with sliders
        controlPane = new GridPane();
        controlPane.setHgap(10);
        controlPane.setVgap(10);

        amplitudeSlider = new Slider(10, 100, 50);
        phaseSlider = new Slider(0, 2 * Math.PI, 0);
        frequencySlider = new Slider(99, 101, 100);

        Label amplitudeLabel = new Label("Amplitude:");
        Label phaseLabel = new Label("Phase Constant:");
        Label frequencyLabel = new Label("Angular Frequency:");

        controlPane.add(amplitudeLabel, 0, 0);
        controlPane.add(amplitudeSlider, 1, 0);
        controlPane.add(phaseLabel, 0, 1);
        controlPane.add(phaseSlider, 1, 1);
        controlPane.add(frequencyLabel, 0, 2);
        controlPane.add(frequencySlider, 1, 2);
        
        //Checkboxes
        sineCheckBox = new CheckBox("Show Sine Wave");
        sineCheckBox.setSelected(true);
        cosineCheckBox = new CheckBox("Show Cosine Wave");
        cosineCheckBox.setSelected(true);
        
        
    }

//Getters for control pane
    public GridPane getControlPane(){
        return controlPane;
    }

// Getters for sliders
    public Slider getAmplitudeSlider() {
        return amplitudeSlider;
    }

    public Slider getPhaseSlider() {
        return phaseSlider;
    }

    public Slider getFrequencySlider() {
        return frequencySlider;
    }
    
    //Getters for checkboxes
    public CheckBox getSineCheckBox(){
        return sineCheckBox;
    }
    public CheckBox getCosineCheckBox(){
        return cosineCheckBox;
    }
}