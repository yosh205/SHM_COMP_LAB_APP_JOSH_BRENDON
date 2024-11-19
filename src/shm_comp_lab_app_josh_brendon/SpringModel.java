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
    
    public SpringModel(double springConstant, double mass, double equilibriumY) {
        this.springConstant = springConstant;
        this.mass = mass;
        this.equilibriumY = equilibriumY;
        this.position = 0; 
        this.velocity = 0;
    }
    
    public double getSpringForce() {
        return -springConstant * position;
    }
    
    public void update() {
        double acceleration = getSpringForce() / mass;

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
