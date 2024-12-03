/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

/**
 *
 * @author joshu
 */
public class WaveView {
    Pane wavePane;
    Path sineWavePath;
    Path cosineWavePath;

    public WaveView() { 
        // Initialize the wave pane where the sine and cosine waves are displayed
        wavePane = new Pane();
        wavePane.setPrefSize(600, 405);

        // Initialize sine and cosine wave paths
        sineWavePath = new Path();
        sineWavePath.setStroke(Color.BLUE);
        cosineWavePath = new Path();
        cosineWavePath.setStroke(Color.RED);

        //border
        wavePane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        //background TESTING
        //wavePane.setStyle("-fx-background-color: grey");
        
        // Add wave paths to the wave pane
        wavePane.getChildren().addAll(sineWavePath, cosineWavePath);

       
    }
    // Getter for the wave pane
    public Pane getWavePane() {
        return wavePane;
    }


    // Getter for sine wave path
    public Path getSineWavePath() {
        return sineWavePath;
    }

    // Getter for cosine wave path
    public Path getCosineWavePath() {
        return cosineWavePath;
    }

}

