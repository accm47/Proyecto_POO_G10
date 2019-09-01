/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kevin Blum
 */
public class Galeria implements Serializable {

    private String idGaleria;
    private ArrayList<Album> albumes;
    private Usuario usuario;
    private ArrayList<Persona> personas = new ArrayList();

    public Galeria(String idGaleria, Usuario usuario) {
        this.idGaleria = idGaleria;
        this.usuario = usuario;
        this.albumes = new ArrayList<>();
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public String getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(String idGaleria) {
        this.idGaleria = idGaleria;
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    public void CrearAlbum() {
    }

    public void mostrarAlbum() {
    }

    public void modificarPersona() {
    }

    public void eliminarPersona() {
    }

    public static void serializar(ArrayList<Galeria> g) {
        try {
            FileOutputStream fout = new FileOutputStream("galeria.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(g);

            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static ArrayList<Galeria> deserializar() {
        ArrayList<Galeria> galerias = new ArrayList();
        try {
            FileInputStream fin = new FileInputStream("galeria.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            galerias = (ArrayList<Galeria>) in.readObject();
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return galerias;
    }

}
