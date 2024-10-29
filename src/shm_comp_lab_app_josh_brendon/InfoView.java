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
    Label shminfo = new Label("Properties");
    Label amp = new Label("Amplitude");
    Label phase = new Label ("Phase Shift");
    Label angf = new Label("Angular Frequency");
    TextField ampinfo = new TextField();
    TextField phaseinfo = new TextField();
    TextField angfinfo = new TextField();
    GridPane infotable = new GridPane();
    InfoView(){
        infotable.setPadding(new Insets(5,5,5,5));
        ampinfo.setEditable(false);
        phaseinfo.setEditable(false);
        angfinfo.setEditable(false);
        
    }
}
