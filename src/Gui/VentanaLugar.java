/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gallery.Lugar;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author BRYAN
 */
public class VentanaLugar {
    
    public static void nuevoLugar(){
        Stage stage = new Stage();
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);
        
        Label placeLabel = new Label("Lugar: ");
        placeLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        TextField placeTxt = new TextField("Lugar");
        HBox placeLine = new HBox();
        placeLine.setAlignment(Pos.CENTER);
        placeLine.setSpacing(20);
        placeLine.getChildren().addAll(placeLabel, placeTxt);
        vb.getChildren().add(placeLine);
        
        Label descripLabel = new Label("Descripcion: ");
        descripLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        TextField descripTxt = new TextField("Descripcion");
        descripTxt.setPrefWidth(300);
        HBox descripLine = new HBox();
        descripLine.setAlignment(Pos.CENTER);
        descripLine.setSpacing(20);
        descripLine.getChildren().addAll(descripLabel, descripTxt);
        vb.getChildren().add(descripLine);
        
        Button addLugar = new Button();
        addLugar.setOnAction((ActionEvent event) -> {
            Lugar.lugares.add(new Lugar(placeTxt.getText(), descripTxt.getText()));
        });
        vb.getChildren().add(addLugar);
        
        vb.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #23395B");
        
        Scene scene = new Scene(vb,500, 300);
        stage.setScene(scene);
        stage.show();
    }
    
}
