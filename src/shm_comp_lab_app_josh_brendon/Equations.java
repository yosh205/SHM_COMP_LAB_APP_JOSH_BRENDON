/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;
import java.lang.Math;
/**
 *
 * @author joshu
 */
public class Equations {
    double displacement;
    double amplitude;
    double angularfrequency;
    double phase;
    double time;
    
    //timeframes
    int frames;
    int[] a = new int[frames];
    
    double positionintime(double amplitude, double angularfrequency, double time, double phase){
     
        double position = 0;
        position = amplitude*Math.cos(phase*time+phase);
     
     return position;
    }
    
    double[] timeframes(double time, int frames){
        double[] timeframe = new double[frames];
        double firsttime = time/frames;
        for(int i = 0; i<frames; i++){
            timeframe[i]=time/(firsttime+i*firsttime);
        }
        return timeframe;
    }
    
    
}
