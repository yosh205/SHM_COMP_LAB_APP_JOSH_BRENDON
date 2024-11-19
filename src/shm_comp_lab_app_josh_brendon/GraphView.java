/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shm_comp_lab_app_josh_brendon;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

/**
 *
 * @author bdmmc
 */
public class GraphView {
    Pane graphPane;
    LineChart<Number, Number> lineChart;
    XYChart.Series<Number, Number> sineSeries;
    XYChart.Series<Number, Number> cosineSeries;
    //NumberAxis xAxis,yAxis;
    
    public GraphView() {
        graphPane = new Pane();
        graphPane.setPrefSize(200, 400);
        
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");
        xAxis.setAutoRanging(true);
        xAxis.setForceZeroInRange(false);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Amplitude");
        yAxis.setAutoRanging(true);
        yAxis.setForceZeroInRange(false);

        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setCreateSymbols(false);
        lineChart.setTitle("Sine and Cosine Waves");
        
        sineSeries = new XYChart.Series<>();
        sineSeries.setName("Sine Wave");
        cosineSeries = new XYChart.Series<>();
        cosineSeries.setName("Cosine Wave");

        lineChart.getData().addAll(sineSeries, cosineSeries);
        graphPane.getChildren().add(lineChart);
        lineChart.autosize();
    }
    
    public Pane getGraph() {
        return graphPane;
    }
    
    public XYChart.Series<Number, Number> getSineSeries() {
        return sineSeries;
    }

    public XYChart.Series<Number, Number> getCosineSeries() {
        return cosineSeries;
    }
    
}
