/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gallery.Principal;
import Gallery.Usuario;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Kevin Blum
 */
public class VentanaUsuario {

    private VBox root;
    private Stage stgGaleria;

    public VentanaUsuario() {
        ventana();
    }

    public Stage getStgGaleria() {
        return stgGaleria;
    }

    public VBox getRoot() {
        return root;
    }

    public void ventana() {
        root = new VBox();
        //Logo Galería
        ImageView paneImg = new ImageView(new Image("/Imagen/blum_g.png"));
        paneImg.setFitWidth(250);
        paneImg.setFitHeight(50);
        //Usuario
        HBox HboxUser = new HBox();
        Label lblUser = new Label("Usuario       ");
        lblUser.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        TextField txtUser = new TextField();
        HboxUser.getChildren().addAll(lblUser, txtUser);
        HboxUser.setAlignment(Pos.CENTER);
        HboxUser.setSpacing(10);
        //Password
        HBox HboxPassword = new HBox();
        Label lblPassword = new Label("Contraseña ");
        lblPassword.setStyle("-fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white; -fx-opacity: 0.7;");
        PasswordField fieldPassword = new PasswordField();
        HboxPassword.getChildren().addAll(lblPassword, fieldPassword);
        HboxPassword.setAlignment(Pos.CENTER);
        HboxPassword.setSpacing(10);
        //Botón
        Button btnIniciar = new Button("Iniciar Sesión");
        btnIniciar.setAlignment(Pos.CENTER);
        btnIniciar.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #000000; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");
        btnIniciar.setOnAction((event) -> {
            for (Usuario u : Usuario.usuarios) {
                if (u.getUserName().equals(txtUser.getText()) && u.getPassword().equals(fieldPassword.getText())) {
                    Principal.usuarioSesion = u;
                    stgGaleria = new Stage();
                    Scene sceneGaleria = new Scene(new VentanaGaleria().getRoot(), 1900, 700);
                    stgGaleria.setTitle("Galeria Blum!");
                    //stgGaleria.setFullScreen(true);
                    stgGaleria.setScene(sceneGaleria);
                    stgGaleria.show();
                    break;
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("¡Usuario o Contraseña Incorrecto!");
                    a.show();
                }

            }

        });
        //root
        root.getChildren().addAll(paneImg, HboxUser, HboxPassword, btnIniciar);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #1f7690");

    }

}
