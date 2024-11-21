/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

/**
 *
 * @author bdmmc
 */
public class SpringModel {
    double springConstant;
    double mass; 
    double position; 
    double velocity;             
    double equilibriumY;
    double acceleration;
    WaveModel model;
    
    public SpringModel(double springConstant, double mass, double equilibriumY, WaveModel model) {
        this.model=model;
        this.springConstant = mass*model.getAngular()*model.getAngular();
        this.mass = mass;
        this.equilibriumY = equilibriumY;
        this.position = 50; 
        this.velocity = 5;
    }
    
    public double getSpringForce() {
        return -springConstant * position;
    }
    
    public void update() {
        acceleration = getSpringForce() / mass;

        velocity += acceleration;
        position += velocity;
    }
    
    public double getPosition() {
        return position;
    }

    public double getEquilibriumY() {
        return equilibriumY;
    }
    
}
