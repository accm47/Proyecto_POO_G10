/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import Gui.VentanaUsuario;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BRYAN y Kevin Blum
 */
public class Principal extends Application {

    public static ArrayList<Galeria> galeriaUsuarios = new ArrayList();
    public static Usuario usuarioSesion;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario us = new Usuario("kblum", "12345");
        Usuario.usuarios.add(new Usuario("kblum", "12345"));
        Usuario.usuarios.add(new Usuario("bchunga", "12345"));
        Usuario.usuarios.add(new Usuario("bvargas", "12345"));
        for (Usuario u : Usuario.usuarios) {
            Galeria g = new Galeria("1", us);
            g.getAlbumes().add(new Album("Dense","Dense me cae mal"));
            galeriaUsuarios.add(g);
         
        }
        launch(args);
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) {
        Scene sceneUser = new Scene(new VentanaUsuario().getRoot(), 300, 250);
        primaryStage.setTitle("Galeria Blum!");
        primaryStage.setScene(sceneUser);
        primaryStage.show();

    }

}
