/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gallery.Album;
import Gallery.Fotografia;
import Gallery.Persona;
import Gallery.Reacciones;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author BRYAN
 */
public class VentanaFotografia {

    public VentanaFotografia() {

    }

    public void start(Stage stage) throws Exception {

    }

    public Scene mostrarFoto(Fotografia foto) {
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20.0);
        vb.getChildren().addAll(new ImageView(foto.getImagen()));
        vb.getChildren().add(new Label(foto.getDescrip()));

        Button like = new Button("LIKE");
        like.setOnAction((event) -> {
            foto.setReacciones(Reacciones.LIKE);
        });

        Button love = new Button("LOVE");
        love.setOnAction((event) -> {
            foto.setReacciones(Reacciones.LOVE);
        });

        Button laugth = new Button("HAHA");
        laugth.setOnAction((event) -> {
            foto.setReacciones(Reacciones.HAHA);
        });

        Button wow = new Button("WOW");
        wow.setOnAction((event) -> {
            foto.setReacciones(Reacciones.WOW);
        });

        Button sad = new Button("SAD");
        sad.setOnAction((event) -> {
            foto.setReacciones(Reacciones.SAD);
        });

        Button angry = new Button("ANGRY");
        angry.setOnAction((event) -> {
            foto.setReacciones(Reacciones.ANGRY);
        });

        HBox botones = new HBox();
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(15.0);
        botones.getChildren().addAll(like, love, laugth, wow, sad, angry);
        vb.getChildren().add(botones);
        vb.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #5F9EA0");
        Scene sc = new Scene(vb);
        return sc;
    }

   

}
