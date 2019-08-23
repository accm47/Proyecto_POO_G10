/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Kevin Blum, Bryan Vargas
 */
public class VentanaAlbum {

    private Label nameAlbum;
    private Button addPhoto;
    private Button slideShow;
    private Button backGallery;
    private Label totalLabel;
    private HBox buttons;
    private ScrollPane scrollPane;
    private TilePane gallery;
    private ArrayList<ImageView> listImageView = new ArrayList<>();
    private VBox mainContainer;
    private Stage stgAlbum;

    public VentanaAlbum() {
        
    }

    public VBox getMainContainer() {
        return mainContainer;
    }

    public Stage getStgAlbum() {
        return stgAlbum;
    }

    public void setStgAlbum(Stage stgAlbum) {
        this.stgAlbum = stgAlbum;
    }

    public void ventana() {
        stgAlbum = new Stage();
        //---------------------------------------------       
        //File Chooser
        final FileChooser fileChooser = new FileChooser();

        //----------------------------------------------
        mainContainer = new VBox(10);
        mainContainer.setAlignment(Pos.CENTER);

        nameAlbum = createNameAlbum();

        mainContainer.getChildren().add(nameAlbum);

        totalLabel = createTotalLabel();
        mainContainer.getChildren().add(totalLabel);

        buttons = createButtons();
        buttons.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #406E8E; ");
        mainContainer.getChildren().add(buttons);

        gallery = createTilePane();

        scrollPane = createScrollPane();
        scrollPane.setContent(gallery);
        gallery.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #c9d0d6");
        mainContainer.getChildren().add(scrollPane);

        displayPictures(listImageView, gallery);

        stgAlbum.setWidth(1050);
        stgAlbum.setHeight(600);
        Scene scene = new Scene(mainContainer);
        stgAlbum.setScene(scene);
        stgAlbum.setTitle("Albúm de photos");
        stgAlbum.show();

        slideShow.setOnAction((ActionEvent e) -> {
        });

        addPhoto.setOnAction((ActionEvent e) -> {

            try {
                //Get Image URL
                File file = fileChooser.showOpenDialog(stgAlbum);

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
                }
            } catch (MalformedURLException ex) {
                System.out.println(ex);
            }
            changeScene(listImageView);
        });

        mainContainer.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #23395B");

    }

    public void changeScene(ArrayList<ImageView> listIV) {
        TilePane newGallery = createTilePane();
        scrollPane.setContent(newGallery);
        totalLabel.setText(listIV.size() + " fotos");
        displayPictures(listIV, newGallery);
    }

    public HBox createButtons() {
        HBox tb = new HBox(20);
        tb.setPadding(new Insets(10, 10, 10, 10));
        tb.setAlignment(Pos.CENTER);
        backGallery = createBackGallery();
        backGallery.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #000000; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");
        addPhoto = createAddPhoto();
        addPhoto.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #000000; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");

        slideShow = createSlideShow();
        slideShow.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #000000; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");

        tb.getChildren().add(backGallery);
        tb.getChildren().add(addPhoto);
        tb.getChildren().add(slideShow);
        return tb;
    }

    public Button createAddPhoto() {
        Button button = new Button("Agregar foto");
        return button;
    }

    public Button createSlideShow() {
        Button button = new Button("Ver en SlideShow");
        return button;
    }

    public Button createBackGallery() {
        Button button = new Button("Volver a la Galería");
        return button;
    }

    public Label createNameAlbum() {
        Label name = new Label("Fotos de portada"); //Nombre del almub dado por el usuario
        name.setTextFill(Color.web("#FFFFFF"));
        name.setFont(Font.font("Segoe UI Semibold", 40));
        name.setStyle("-fx-font-weight: bold");
        return name;
    }

    public Label createTotalLabel() {
        Label label = new Label(listImageView.size() + " fotos");
        label.setTextFill(Color.web("#FFFFFF"));
        label.setFont(Font.font("Segoe UI Semibold", 20));
        label.setStyle("-fx-font-weight: bold");
        return label;
    }

    public ScrollPane createScrollPane() {
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
        sp.setFitToWidth(true);
        return sp;
    }

    public TilePane createTilePane() {
        TilePane tilePane = new TilePane();
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setPadding(new Insets(15, 15, 15, 15));
        tilePane.setVgap(30);
        tilePane.setHgap(20);
        return tilePane;
    }

    public void displayPictures(ArrayList<ImageView> listIV, Pane container) {
        for (ImageView ph : listIV) {
            //Pane imVi = createImageView(ph);
            ph.setOnMouseClicked((MouseEvent e) -> {

                //Abrir la foto 
                //Settear la escena
                //Agreagr botones
            });
            container.getChildren().addAll(ph);
        }
    }

    /*private Pane createImageView(ImageView iv) {   #Agregar marco o detalles a la foto en miniatura

        VBox vbox = new VBox();
        vbox.getChildren().add(iv);
        return vbox;
    }*/
}
