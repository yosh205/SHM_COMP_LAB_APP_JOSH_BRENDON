/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.layout.Pane;

/**
 *
 * @author bdmmc
 */
public class GraphView {
    Pane graphPane;
    
    public GraphView() {
        graphPane = new Pane();
        graphPane.setPrefSize(200, 400);
        
    }
    
    public Pane getGraph() {
        return graphPane;
    }
    
}
