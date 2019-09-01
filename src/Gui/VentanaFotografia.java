/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gallery.Album;
import Gallery.Fotografia;
import Gallery.KeyWord;
import Gallery.Lugar;
import Gallery.Persona;
import Gallery.Reacciones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author BRYAN
 */
public class VentanaFotografia {

    public VentanaFotografia() {

    }

    public void start(Stage stage) throws Exception {

    }

    public void mostrarFoto(Fotografia foto) {
        Stage stg= new Stage();
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
        stg.setScene(sc);
        stg.show();
    }

    public void nuevaFoto(Image image) {
        ImageView img = new ImageView(image);
        Stage stage = new Stage();
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        img.setFitHeight(50);
        img.setFitWidth(50);

        vb.getChildren().add(img);

        TextField descrip = new TextField("Descripcion");
        descrip.setPrefSize(350, 100);
        HBox descripLine = new HBox();
        descripLine.setAlignment(Pos.CENTER);
        descripLine.setSpacing(20);
        Label descripLabel = new Label("Descripcion:");
        descripLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        descripLine.getChildren().addAll(descripLabel, descrip);
        vb.getChildren().add(descripLine);

        TextField year = new TextField("Año");
        year.setPrefSize(100, 25);
        HBox yearLine = new HBox();
        yearLine.setAlignment(Pos.CENTER);
        yearLine.setSpacing(20);
        Label yearLabel = new Label("Año:");
        yearLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        yearLine.getChildren().addAll(yearLabel, year);
        vb.getChildren().add(yearLine);

        ObservableList<Lugar> lugares = FXCollections.observableArrayList(Lugar.lugares);
        ComboBox<Lugar> placeList = new ComboBox<>(lugares);
        placeList.setConverter(new StringConverter<Lugar>() {

            @Override
            public String toString(Lugar lugar) {
                return lugar.getNombre();
            }

            @Override
            public Lugar fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        HBox placeLine = new HBox();
        placeLine.setAlignment(Pos.CENTER);
        placeLine.setSpacing(20);
        Button newPlace = new Button("Nuevo Lugar");
        newPlace.setOnAction(event -> {
//            Lugar.newLugar();
        });
        Label placeLabel = new Label("Lugar:");
        placeLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        placeLine.getChildren().addAll(placeLabel, placeList, newPlace);
        vb.getChildren().add(placeLine);

        ObservableList<Album> albumes = FXCollections.observableArrayList(Album.albumes);
        ComboBox<Album> albumList = new ComboBox<>(albumes);
        albumList.setConverter(new StringConverter<Album>() {

            @Override
            public String toString(Album album) {
                return album.getNombre();
            }

            @Override
            public Album fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        HBox albumLine = new HBox();
        albumLine.setAlignment(Pos.CENTER);
        albumLine.setSpacing(20);
        Button newAlbum = new Button("Nuevo Album");
        //eventH newAlbum
        Label albumLabel = new Label("Album:");
        albumLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        albumLine.getChildren().addAll(albumLabel, albumList, newAlbum);
        vb.getChildren().add(albumLine);

        ComboBox<Persona> personList = new ComboBox<>();
        personList.setConverter(new StringConverter<Persona>() {

            @Override
            public String toString(Persona persona) {
                return persona.getNombre();
            }

            @Override
            public Persona fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        personList.getItems().addAll(Persona.personas);
        Label personasLabel = new Label();
        personasLabel.setPrefSize(300, 75);
        personasLabel.setStyle("-fx-background-color:white; -fx-padding:3px;");
        personList.setOnAction(event -> {
            personasLabel.getText().replaceAll(personasLabel.getText(), (personasLabel.getText()) + " " + personList.getValue());
        });
        HBox personLine = new HBox();
        personLine.setAlignment(Pos.CENTER);
        personLine.setSpacing(20);
        Button newPerson = new Button("Nueva Persona");
        newPerson.setOnAction(event -> {
           // Persona.newPersona();
        });
        Label personLabel = new Label("Personas: ");
        personLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        personLine.getChildren().addAll(personLabel, personList, newPerson);
        vb.getChildren().add(personLine);
        vb.getChildren().add(personasLabel);

        TextField keyword = new TextField("Hashtag");
        HBox keywordLine = new HBox();
        keywordLine.setAlignment(Pos.CENTER);
        keywordLine.setSpacing(20);
        Label keywordLabel = new Label("Hashtag");
        keywordLabel.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        keywordLine.getChildren().addAll(keywordLabel, keyword);
        vb.getChildren().add(keywordLine);

        Button addPhoto = new Button("Agregar Foto");
        vb.getChildren().add(addPhoto);
        addPhoto.setOnAction(event -> {
            Album album = albumList.getValue();
            album.getFotos().add(new Fotografia(descrip.getText(), year.getText(), placeList.getValue(), album, null, image, new KeyWord(keyword.getText())));
        });
        vb.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #23395B");

        Scene scene = new Scene(vb, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}
