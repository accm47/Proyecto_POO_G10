/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Kevin Blum
 */
public class VentanaGaleria {

    private BorderPane root;

    public VentanaGaleria() {
        ventana();
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public void ventana() {
        //Logo Carpeta Album
        root = new BorderPane();
        //Top
        HBox paneLogo = new HBox();
        ImageView paneImg = new ImageView(new Image("/Imagen/blum_g.png"));
        paneImg.setFitWidth(500);
        paneImg.setFitHeight(100);
        paneLogo.getChildren().add(paneImg);

        paneLogo.setStyle("-fx-border-color: #DCDCDC; -fx-border-width: 3px;-fx-background-color: #DCDCDC");
        paneLogo.setAlignment(Pos.CENTER);
        root.setTop(paneLogo);
        //Center
        TilePane paneAlbum = new TilePane();
        paneAlbum.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #FFFFFF");
        paneAlbum.setPadding(new Insets(15, 15, 15, 15));

        paneAlbum.setVgap(30);
        paneAlbum.setHgap(30);

//paneAlbum.setAlignment(Pos.CENTER);
        root.setCenter(paneAlbum);
        root.setStyle("-fx-border-color: #000000; -fx-border-width: 4px; -fx-background-color: #5F9EA0");
        //Right
        VBox paneBtn = new VBox();
        Button btnCrearAlbum = new Button("Crear Album");
        Button btnCrearFoto = new Button("Subir Foto");
        paneBtn.getChildren().addAll(btnCrearAlbum, btnCrearFoto);
        paneBtn.setSpacing(10);
        root.setRight(paneBtn);

        btnCrearAlbum.setOnAction((event) -> {
            ImageView imgLogo = new ImageView(new Image("/Imagen/blum_logo.png"));
            imgLogo.setFitHeight(50);
            imgLogo.setFitWidth(50);

            Button album = new Button("", imgLogo);

            album.setGraphic(imgLogo);

            album.setStyle("-fx-background-size: 800 900; -fx-background-radius: 0 0 18 18; -fx-border-radius: 0 0 18 18;-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #BDB76B;");
            //album.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #BDB76B;");
            //album.setLayoutY(10);
            paneAlbum.getChildren().add(album);

        });

    }
}
