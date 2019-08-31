/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author BRYAN
 */
public class VentanaPersona {
    
    public static void nuevaPersona(){
        Stage stage = new Stage();
        VBox root = new VBox();
        root.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #23395B");
        root.setAlignment(Pos.CENTER);
        
        Label nameLabel = new Label("Nombre de nueva Perona:");
        nameLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        TextField nameTxt = new TextField("Nombre");
        nameTxt.setPrefWidth(150);
        root.getChildren().addAll(nameLabel, nameTxt);
        
        Scene sc = new Scene(root, 350, 300);
        stage.setScene(sc);
    }
    
}
