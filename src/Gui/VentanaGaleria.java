/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Kevin Blum
 */
public class VentanaGaleria {

    private BorderPane root;
    private ArrayList<ImageView> listImageView = new ArrayList<>();
    private TilePane gallery;

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

        paneLogo.setStyle("-fx-border-color: #c9d0d6; -fx-border-width: 3px;-fx-background-color: #c9d0d6");
        paneLogo.setAlignment(Pos.CENTER);
        root.setTop(paneLogo);
        //Center
        TilePane paneAlbum = new TilePane();
        paneAlbum.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #161925");
        paneAlbum.setPadding(new Insets(15, 15, 15, 15));

        paneAlbum.setVgap(30);
        paneAlbum.setHgap(30);

//paneAlbum.setAlignment(Pos.CENTER);
        root.setCenter(paneAlbum);
        //root.setStyle("-fx-border-color: #000000; -fx-border-width: 4px; -fx-background-color: #5F9EA0");
        //Right
        VBox paneBtn = new VBox();
        paneBtn.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #406E8E");
        Button btnCrearAlbum = new Button("Crear Album");
        Button btnCrearFoto = new Button("Subir Foto");
        btnCrearAlbum.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        btnCrearFoto.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        paneBtn.getChildren().addAll(btnCrearAlbum, btnCrearFoto);
        paneBtn.setSpacing(10);
        root.setRight(paneBtn);

        btnCrearAlbum.setOnAction((event) -> {
            ImageView imgLogo = new ImageView(new Image("/Imagen/blum_logo.png"));
            imgLogo.setFitHeight(50);
            imgLogo.setFitWidth(50);

            Button album = new Button("", imgLogo);

            album.setGraphic(imgLogo);

            album.setStyle("-fx-background-size: 800 900; -fx-background-radius: 0 0 18 18; -fx-border-radius: 0 0 18 18;-fx-border-color: #CBF7ED; -fx-border-width: 2px; -fx-background-color: #8EA8C3;");
            //album.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #BDB76B;");
            //album.setLayoutY(10);
            paneAlbum.getChildren().add(album);

            album.setOnAction((e) -> {
                new VentanaAlbum().ventana();

            });
        });

        //Bottom
        gallery = new TilePane();
        gallery.setPadding(new Insets(15, 15, 15, 15));
        gallery.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #23395B");
        gallery.setVgap(30);
        gallery.setHgap(30);

        btnCrearFoto.setOnAction((event) -> {
            final FileChooser fileChooser = new FileChooser();
            try {
                //Get Image URL
                File file = fileChooser.showOpenDialog(new VentanaUsuario().getStgGaleria());
                HBox hbFoto = new HBox();
                if (file.isFile()
                        && (file.getName().contains(".jgp") || file.getName().contains(".png")
                        || file.getName().contains(".bmp") || file.getName().contains(".gif"))
                        || file.getName().contains(".jpeg") || file.getName().contains(".jpg")) {

                    //Loading the image in Memory
                    String photoURL = file.toURI().toURL().toString();
                    Image imgLoad = new Image(photoURL);

                    //Pass image to ImageView
                    ImageView imgView = new ImageView(imgLoad);
                    imgView.setFitHeight(200);
                    imgView.setFitWidth(200);

                    listImageView.add(imgView);
                    gallery.getChildren().addAll(imgView);

//hbFoto.getChildren().add(imgView);
                }
                
                
                
            } catch (MalformedURLException ex) {
                System.out.println(ex);
            }
            //gallery.getChildren().addAll(listImageView);

        });

        root.setBottom(gallery);

    }
}
