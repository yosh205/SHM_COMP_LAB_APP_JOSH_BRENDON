/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author joshu
 */
public class InfoView extends Pane{
    WaveModel model;
    //Label shminfo = new Label("Properties");
    Label amp = new Label("Amplitude");
    Label phase = new Label ("Phase Shift");
    Label angf = new Label("Angular Frequency");
    TextField ampinfo = new TextField();
    TextField phaseinfo = new TextField();
    TextField angfinfo = new TextField();
    GridPane gpane = new GridPane();
    InfoView(){
        gpane.setPadding(new Insets(5,5,5,5));
        ampinfo.setEditable(false);
        phaseinfo.setEditable(false);
        angfinfo.setEditable(false);
        
        //gpane.add(shminfo, 0, 0);
        gpane.add(amp,0,0);
        gpane.add(ampinfo,1,0);
        gpane.add(phase,0,1);
        gpane.add(phaseinfo,1,1);
        gpane.add(angf,0,2);
        gpane.add(angfinfo,1,2);
        
        
        this.getChildren().add(gpane);
    }
    
    public Pane getInfoview(){
        return this;
    }
    
    public void information(double amplitude, double angf, double phase){
        ampinfo.setText(Double.toString(amplitude));
        phaseinfo.setText(Double.toString(phase));
        angfinfo.setText(Double.toString(angf));
    }
    
    
}
