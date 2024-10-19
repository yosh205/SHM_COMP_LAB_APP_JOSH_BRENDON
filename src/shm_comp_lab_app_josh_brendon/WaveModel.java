/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

/**
 *
 * @author joshu
 */

//This model class has all the information regarding the waves. It has setters and getters to easily manage and store certain data values
public class WaveModel {
    double amplitude;
    double phase;
    double angular;
    
    public WaveModel(double amplitude, double phase, double angular){
        this.amplitude =amplitude;
        this.phase=phase;
        this.angular=angular;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public void setPhase(double phase) {
        this.phase = phase;
    }

    public void setAngular(double angular) {
        this.angular = angular;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public double getPhase() {
        return phase;
    }

    public double getAngular() {
        return angular;
    }
}
