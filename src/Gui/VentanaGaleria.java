/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gallery.Album;
import Gallery.Galeria;
import Gallery.Principal;
import Gallery.Usuario;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    TilePane paneAlbum;
    String rutaGaleria = "C:\\Users\\kexbl\\OneDrive\\Imágenes";
    Album albums;
    TextField txtbuscar;

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

        paneAlbum = new TilePane();
        //Center
        paneAlbum.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #161925");
        paneAlbum.setPadding(new Insets(15, 15, 15, 15));

        paneAlbum.setVgap(30);
        paneAlbum.setHgap(30);

        Galeria galeria = null;

        for (Galeria g : Principal.galeriaUsuarios) {
            if (Principal.usuarioSesion.getUserName().equals(g.getUsuario().getUserName())) {
                galeria = g;
                Principal.usuarioSesion.setGaleria(galeria);
                break;
            }

        }

        for (Album g2 : galeria.getAlbumes()) {
            VBox panealbum1 = new VBox();
            panealbum1.setSpacing(10);
            panealbum1.setAlignment(Pos.CENTER);
            ImageView imgLogo = new ImageView(new Image("/Imagen/blum_logo.png"));
            Label lblnombreAlbum = new Label(g2.getNombre());
            lblnombreAlbum.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");

            imgLogo.setFitHeight(50);
            imgLogo.setFitWidth(50);

            Button album = new Button("", imgLogo);
            panealbum1.getChildren().addAll(album, lblnombreAlbum);
            album.setGraphic(imgLogo);

            album.setOnAction((event) -> {
                new VentanaAlbum().ventana(g2);

            });

            album.setStyle("-fx-background-size: 800 900; -fx-background-radius: 0 0 18 18; -fx-border-radius: 0 0 18 18;-fx-border-color: #CBF7ED; -fx-border-width: 2px; -fx-background-color: #8EA8C3;");
            //album.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #BDB76B;");
            //album.setLayoutY(10);

            paneAlbum.getChildren().add(panealbum1);

        }
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

//paneAlbum.setAlignment(Pos.CENTER);
        root.setCenter(paneAlbum);
        //root.setStyle("-fx-border-color: #000000; -fx-border-width: 4px; -fx-background-color: #5F9EA0");
        //Left
        VBox paneBusqueda = new VBox();
        HBox paneBusq = new HBox();
        Label lblbusq = new Label("Busqueda");
        txtbuscar = new TextField();
        Button btnbuscar = new Button("Buscar");
        
        paneBusq.getChildren().add(btnbuscar);
        paneBusqueda.getChildren().addAll(lblbusq, txtbuscar, paneBusq);
        root.setLeft(paneBusqueda);

        //Right
        VBox paneBtn = new VBox();
        paneBtn.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #406E8E");
        Button btnCrearAlbum = new Button("Crear Album");
        Button btnCrearFoto = new Button("Subir Foto");
        Button btnLugar = new Button("Añadir Lugar");
        Button btnPersona = new Button("Añadir Persona");
       Button btnEPersona = new Button("Eliminar Persona");
       Button btnEAlbum = new Button("Eliminar Album");
       
       
        btnPersona.setOnAction((event) -> {
            VentanaPersona.nuevaPersona();
        });

        btnCrearAlbum.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        btnCrearFoto.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        btnPersona.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        btnLugar.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        btnEPersona.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        btnEAlbum.setStyle("-fx-border-color: #CBF7ED; -fx-border-width: 1px; -fx-background-color: #CBF7ED; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: black;");
        
        paneBtn.getChildren().addAll(btnCrearAlbum, btnCrearFoto, btnPersona, btnLugar,btnEPersona,btnEAlbum);
        paneBtn.setSpacing(10);
        root.setRight(paneBtn);

//        btnPersona.setOnAction((event) -> {
//            VentanaPersona.nuevaPersona();
//        });
//        
        btnLugar.setOnAction((event) -> {
            VentanaLugar.nuevoLugar();
        });

        btnCrearAlbum.setOnAction((event) -> {
            miniVentanaAlbum();
//            ImageView imgLogo = new ImageView(new Image("/Imagen/blum_logo.png"));
//            imgLogo.setFitHeight(50);
//            imgLogo.setFitWidth(50);
//            VBox panealbum = new VBox();
//            Button album = new Button("", imgLogo);
//
//            album.setGraphic(imgLogo);
//
//            album.setStyle("-fx-background-size: 800 900; -fx-background-radius: 0 0 18 18; -fx-border-radius: 0 0 18 18;-fx-border-color: #CBF7ED; -fx-border-width: 2px; -fx-background-color: #8EA8C3;");
//            //album.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #BDB76B;");
//            //album.setLayoutY(10);
//            paneAlbum.getChildren().add(album);

//            album.setOnAction((e) -> {
//                new VentanaAlbum().ventana(albums);
//
//            });
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

    public void miniVentanaAlbum() {
        Stage stg = new Stage();
        VBox root = new VBox();
        //Nombre
        HBox paneNombre = new HBox();
        Label lblnombreAlbum = new Label("Ingrese Nombre Album: ");
        TextField txtNombreAlbum = new TextField();
        paneNombre.getChildren().addAll(lblnombreAlbum, txtNombreAlbum);
        //Descripcion
        HBox paneDescrpicion = new HBox();
        Label lblDescripcionAlbum = new Label("Ingrese Descripción Album: ");
        TextField txtDescripcionAlbum = new TextField();
        paneDescrpicion.getChildren().addAll(lblDescripcionAlbum, txtDescripcionAlbum);
        //Boton
        Button btnAceptar = new Button("Guardar");
        root.getChildren().addAll(paneNombre, paneDescrpicion, btnAceptar);

        Scene scene = new Scene(root);
        stg.setScene(scene);
        stg.show();

        btnAceptar.setOnAction((event) -> {
            Album album = new Album(txtNombreAlbum.getText(), txtDescripcionAlbum.getText());
            String nombre = txtNombreAlbum.getText();

            Galeria galeria = null;
            File folder = new File(rutaGaleria + "\\" + Principal.usuarioSesion.getUserName() + "\\" + album.getNombre());
            folder.mkdir();

            for (Galeria g1 : Principal.galeriaUsuarios) {
                if (Principal.usuarioSesion.getUserName().equals(g1.getUsuario().getUserName())) {
                    galeria = g1;
                    break;

                }

            }
            galeria.getAlbumes().add(album);
            Galeria.serializar(Principal.galeriaUsuarios);

            VBox panealbum1 = new VBox();
            panealbum1.setSpacing(10);
            panealbum1.setAlignment(Pos.CENTER);
            ImageView imgLogo = new ImageView(new Image("/Imagen/blum_logo.png"));
            Label lblnombreAlbum1 = new Label(album.getNombre());
            lblnombreAlbum1.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");

            imgLogo.setFitHeight(50);
            imgLogo.setFitWidth(50);

            Button album1 = new Button("", imgLogo);
            album1.setStyle("-fx-background-size: 800 900; -fx-background-radius: 0 0 18 18; -fx-border-radius: 0 0 18 18;-fx-border-color: #CBF7ED; -fx-border-width: 2px; -fx-background-color: #8EA8C3;");

            panealbum1.getChildren().addAll(album1, lblnombreAlbum1);

            album1.setOnAction((e) -> {
                new VentanaAlbum().ventana(album);

            });

            galeria.getAlbumes().add(album);
            paneAlbum.getChildren().add(panealbum1);
            stg.close();
        });

    }

}
