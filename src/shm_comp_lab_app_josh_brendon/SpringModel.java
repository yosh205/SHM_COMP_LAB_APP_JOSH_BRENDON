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
        this.springConstant = mass*(springConstant/100)*(springConstant/100);
        this.mass = mass;
        //Ensures that the animation starts in the middle of the pane if the user does not wish to change it
        this.equilibriumY = equilibriumY+150; 
        this.position = 50; 
        this.velocity = 1;
    }
    
    public double getSpringForce() {
        return -springConstant * position;
    }
    
    public void update() {
        //Calculates the acceleration
        acceleration = getSpringForce() / mass;

        //Updates the velocity and position
        velocity += acceleration;
        position += velocity;
    }
    
    //Getters to return information
    public double getPosition() {
        return position;
    }

    public double getEquilibriumY() {
        return equilibriumY;
    }
    
}
