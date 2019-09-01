/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gallery.Album;
import Gallery.Fotografia;
import Gallery.Galeria;
import Gallery.KeyWord;
import Gallery.Lugar;
import Gallery.Persona;
import Gallery.Principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    public ArrayList<ImageView> listImageView = new ArrayList<>();
    private VBox mainContainer;
    private Stage stgAlbum;
    Album album;
    String rutaGaleria = "C:\\Users\\kexbl\\OneDrive\\Imágenes";
    byte[] bArray;
    File file;
    ImageView imgView;

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

    public void ventana(Album album) {
        stgAlbum = new Stage();

        //---------------------------------------------       
        //File Chooser
//        final FileChooser fileChooser = new FileChooser();
        //----------------------------------------------
        mainContainer = new VBox(10);
        //mainContainer.setAlignment(Pos.CENTER);

        nameAlbum = new Label(album.getNombre());//Nombre del almub dado por el usuario
        nameAlbum.setTextFill(Color.web("#FFFFFF"));
        nameAlbum.setFont(Font.font("Segoe UI Semibold", 40));
        nameAlbum.setStyle("-fx-font-weight: bold");

        mainContainer.getChildren().add(nameAlbum);

        totalLabel = createTotalLabel();
        mainContainer.getChildren().add(totalLabel);

        buttons = createButtons();

        buttons.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #406E8E; ");
        mainContainer.getChildren().add(buttons);

        gallery = createTilePane();

        scrollPane = createScrollPane();

        scrollPane.setContent(gallery);
        scrollPane.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #c9d0d6");
        gallery.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #c9d0d6");
        mainContainer.getChildren().add(scrollPane);

        displayPictures(listImageView, gallery);

        stgAlbum.setWidth(1050);
        stgAlbum.setHeight(600);
        Scene scene = new Scene(mainContainer);
        stgAlbum.setScene(scene);
        stgAlbum.setTitle("Albúm de photos");
        stgAlbum.show();

        Button eliminar = new Button("Eliminar");
      
        addPhoto.setOnAction((event) -> {
            ventanaDescripion(album);
        });
        mainContainer.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #23395B");

       
        try {
            Files.walk(Paths.get(rutaGaleria + "\\" + Principal.usuarioSesion.getUserName() + "\\" + album.getNombre())).forEach(ruta -> {
                if (Files.isRegularFile(ruta)) {
                    int lastIndexOf = ruta.toString().lastIndexOf("\\");
                    
                    
                        
                        Image image = new Image("file:" + ruta);
                        ImageView imagev = new ImageView(image);
                        imagev.setFitHeight(100);
                        imagev.setFitWidth(100);
                        listImageView.add(imagev);
                        totalLabel.setText(listImageView.size() + " fotos");
                        gallery.getChildren().add(imagev);
                    
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(VentanaGaleria.class.getName()).log(Level.SEVERE, null, ex);
        }

        slideShow.setOnAction((event) -> {
            Stage stage2 = new Stage();
            VBox paneims = new VBox();
            HBox panetop = new HBox();
            Label lblSlide = new Label("SlideShow");
            lblSlide.setStyle("-fx-border-color: #000000; -fx-border-width: 1px;  -fx-font-size: 40pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");
            Button btnplay = new Button("Play");
            Button btnstop = new Button("Stop");
            panetop.getChildren().addAll(lblSlide, btnplay, btnstop);
            paneims.setAlignment(Pos.CENTER);
            paneims.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #23395B");
            paneims.getChildren().add(panetop);
            ImageView im = new ImageView();
            Slide s = new Slide(listImageView, paneims);
            Scene scene1 = new Scene(paneims, 500, 500);
            stage2.setScene(scene1);
            stage2.setFullScreen(true);
            stage2.show();
            stgAlbum.close();
            s.start();
            btnplay.setOnAction((o) -> {
                s.resume();
            });
            btnstop.setOnAction((p) -> {
                s.suspend();
            });
        });
    }

    public boolean filtro(String persona, String nombre) {
        boolean v = false;
        if (persona != null || !persona.isEmpty()) {
            for (Fotografia f : album.getFotos()) {
                if (f.getNombreArchivo().equalsIgnoreCase(nombre)) {
                    for (Persona p : f.getPersonas()) {
                        if (p.getNombre().equalsIgnoreCase(persona)) {
                            v = true;
                        }
                    }

                }
            }
        } else {
            v = true;
        }
        return v;
    }

    public void ventanaDescripion(Album album) {
        Stage stgDescripcion = new Stage();
        //Imagen
        VBox paned = new VBox();
        //Titulo
        Label lblTitulo = new Label("Ingrese información de la Foto");
        //Descripción
        HBox HbDescripcion = new HBox();
        Label lblDescripcion = new Label("Descripcion: ");
        TextField txtDescripcion = new TextField();
        HbDescripcion.getChildren().addAll(lblDescripcion, txtDescripcion);
        //Lugar
        Label lblLugar = new Label("Lugar: ");
        //TextField txtLugar = new TextField();
        HBox HbLugar = new HBox();
        ComboBox comboLugar = new ComboBox();
        for (Lugar l : Principal.lugares) {
            comboLugar.getItems().add(l.getNombre());

        }

        HbLugar.getChildren().addAll(lblLugar, comboLugar);
        //KeyWord
        Label lblKeyword = new Label("KeyWord: ");
        TextField txtKeyword = new TextField();
        HBox HbKeyword = new HBox();
        HbKeyword.getChildren().addAll(lblKeyword, txtKeyword);

        //Fecha
        DatePicker fecha1 = new DatePicker();

        Label lblFecha = new Label("Fecha: ");
        TextField txtFecha = new TextField();
        HBox HbFecha = new HBox();
        HbFecha.getChildren().addAll(lblFecha, fecha1);
        //Persona
        Label lblPersona = new Label("Persona(s) ");
        TextField txtPersona = new TextField();

        ComboBox comboPersona = new ComboBox();
        for (Persona p : Principal.personas) {
            comboPersona.getItems().add(p);

        }
        Button btnPersona = new Button("Etiquetar Personas");
        btnPersona.setOnAction((event) -> {
            if (txtPersona.getText().isEmpty()) {
                txtPersona.setText(String.valueOf(comboPersona.getValue()));
            } else {
                txtPersona.setText(txtPersona.getText() + "," + String.valueOf(comboPersona.getValue()));
            }
        });
//        comboPersona.setOnMouseClicked((event) -> {
//           txtPersona.setText(String.valueOf(comboPersona.getValue()));
//        });
        HBox HPersona = new HBox();
        HPersona.getChildren().addAll(lblPersona, txtPersona, comboPersona, btnPersona);

        //Album
        Label lblAlbum = new Label(album.getNombre());
        //Boton
        Button btnAceptar = new Button("Guardar");
        Button btnfoto = new Button("Elegir Foto");
        //Pane
        paned.getChildren().addAll(lblAlbum, HbDescripcion, HbLugar, HbFecha, HPersona, HbKeyword, btnAceptar, btnfoto);
        paned.setSpacing(10);

        Scene scenefoto = new Scene(paned, 700, 500);
        stgDescripcion.setScene(scenefoto);
        stgDescripcion.show();

        final FileChooser fileChooser = new FileChooser();

        //Eventos
        btnfoto.setOnAction((ActionEvent e) -> {

            try {
                //Get Image URL
                file = fileChooser.showOpenDialog(stgAlbum);
                if (file.isFile()
                        && (file.getName().contains(".jgp") || file.getName().contains(".png")
                        || file.getName().contains(".bmp") || file.getName().contains(".gif"))
                        || file.getName().contains(".jpeg") || file.getName().contains(".jpg")) {

                    //Loading the image in Memory
                    String photoURL = file.toURI().toURL().toString();
                    Image imgLoad = new Image(photoURL);

                    //Pass image to ImageView
                    imgView = new ImageView(imgLoad);

                    imgView.setFitHeight(100);
                    imgView.setFitWidth(100);
                    listImageView.add(imgView);
                    imgView.setOnMouseClicked((event) -> {
                        Stage st = new Stage();
                        VBox paneMover = new VBox();
                        HBox panem = new HBox();
                        Label lblmover = new Label("Seleccione album a mover");
                        ComboBox comboAlbum = new ComboBox();
                        Button btnMover = new Button("Mover");
                        panem.getChildren().addAll(lblmover, comboAlbum, btnMover);
                        paneMover.getChildren().add(panem);
                        Scene sc = new Scene(paneMover, 500, 500);
                        st.setScene(sc);
                        st.show();
                        for (Album a : Principal.usuarioSesion.getGaleria().getAlbumes()) {
                            comboAlbum.getItems().add(a.getNombre());
                        }

                        btnMover.setOnAction((a) -> {
                            gallery.getChildren().remove(imgView);

                        });

                    });
                    bArray = readFileToByteArray(file);
                    paned.getChildren().add(imgView);

                }
            } catch (MalformedURLException ex) {
                System.out.println(ex);
            }
            // changeScene(listImageView);
        });

        btnAceptar.setOnAction((event) -> {
            String pe = txtPersona.getText();
            String[] split = pe.split(",");
            ArrayList<Persona> p = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {

                p.add(new Persona(split[i]));

            }
            String ke = txtKeyword.getText();
            String[] split1 = ke.split(",");
            ArrayList<KeyWord> k = new ArrayList<>();

            for (int i = 0; i < split1.length; i++) {

                k.add(new KeyWord(split1[i]));

            }

            Lugar l = new Lugar(String.valueOf(comboLugar.getValue()));
            Fotografia foto = new Fotografia(file.getName(), txtDescripcion.getText(), String.valueOf(fecha1.getValue()), l, album);
            foto.setPersonas(p);
            foto.setKeywords(k);

            album.getFotos().add(foto);
            Galeria.serializar(Principal.galeriaUsuarios);
            gallery.getChildren().add(imgView);

            try {
                FileOutputStream fout = new FileOutputStream(rutaGaleria + "\\" + Principal.usuarioSesion.getUserName() + "\\" + album.getNombre() + "\\" + file.getName());
                try {
                    fout.write(bArray);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaAlbum.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaAlbum.class.getName()).log(Level.SEVERE, null, ex);
            }
            stgDescripcion.close();

        });

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

    private static byte[] readFileToByteArray(File file) {
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        } catch (IOException ioExp) {
            ioExp.printStackTrace();
        }
        return bArray;
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
    public Label getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(Label nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public Button getAddPhoto() {
        return addPhoto;
    }

    public void setAddPhoto(Button addPhoto) {
        this.addPhoto = addPhoto;
    }

    public Button getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(Button slideShow) {
        this.slideShow = slideShow;
    }

    public Button getBackGallery() {
        return backGallery;
    }

    public void setBackGallery(Button backGallery) {
        this.backGallery = backGallery;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }

    public void setTotalLabel(Label totalLabel) {
        this.totalLabel = totalLabel;
    }

    public HBox getButtons() {
        return buttons;
    }

    public void setButtons(HBox buttons) {
        this.buttons = buttons;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public TilePane getGallery() {
        return gallery;
    }

    public void setGallery(TilePane gallery) {
        this.gallery = gallery;
    }

    public ArrayList<ImageView> getListImageView() {
        return listImageView;
    }

    public void setListImageView(ArrayList<ImageView> listImageView) {
        this.listImageView = listImageView;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getRutaGaleria() {
        return rutaGaleria;
    }

    public void setRutaGaleria(String rutaGaleria) {
        this.rutaGaleria = rutaGaleria;
    }

}

class Slide extends Thread {

    ArrayList<ImageView> listI = new ArrayList();
    Pane pane;

    Slide(ArrayList<ImageView> listI, Pane pane) {
        this.listI = listI;
        this.pane = pane;

    }

    public void run() {

        for (ImageView i : listI) {
            i.setFitHeight(600);
            i.setFitWidth(1900);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Slide.class.getName()).log(Level.SEVERE, null, ex);
            }

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pane.getChildren().add(i);
                }

            });
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Slide.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pane.getChildren().remove(i);
                }
            });
        }
    }

}
