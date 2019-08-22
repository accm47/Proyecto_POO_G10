/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kevin Blum
 */
public class Usuario {
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    private String userName;
    private String password;
    private Galeria galeria;
    //Atributos interfaz gráfica
    VBox root;

    public Usuario(String userName, String password, Galeria galeria) {
        this.userName = userName;
        this.password = password;
        this.galeria = galeria;
    }

    public Usuario() {
        ventanaUsuario();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    public void ventanaUsuario() {
        root = new VBox();
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
        TextField txtPassword = new TextField();
        HboxPassword.getChildren().addAll(lblPassword, txtPassword);
        HboxPassword.setAlignment(Pos.CENTER);
        HboxPassword.setSpacing(10);
        //Botón
        Button btnIniciar = new Button("Iniciar Sesión");
        btnIniciar.setAlignment(Pos.CENTER);
        btnIniciar.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #000000; -fx-font-size: 11pt; -fx-font-family: Segoe UI Semibold; -fx-text-fill: white;");
        //root
        root.getChildren().addAll(HboxUser, HboxPassword, btnIniciar);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #5F9EA0");

    }

    @Override
    public String toString() {
        return "Usuario{" + "userName=" + userName + ", password=" + password + ", galeria=" + galeria + '}';
    }

    public void serializarDatos(){
        try {
            FileOutputStream fs = new FileOutputStream("usuarios.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            for (Usuario user: usuarios){
                os.writeObject(user);
            }
            os.close();
            fs.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deserializarDatos(){
        try{
            FileInputStream fs = new FileInputStream("usuraios.ser");
            ObjectInputStream os = new ObjectInputStream(fs);
            Usuario u1 = (Usuario) os.readObject();
            Usuario u2 = (Usuario) os.readObject();
            Usuario u3 = (Usuario) os.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
