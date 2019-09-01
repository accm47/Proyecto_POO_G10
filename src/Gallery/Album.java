/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BRYAN y Kevin Blum
 */
public class Album implements Serializable {

    public static ArrayList<Album> albumes = new ArrayList<Album>();

    private String nombre;
    private String fecha;
    private String descrip;
    private ArrayList<Fotografia> fotos;
    private ArrayList<Persona> personas;
    private ArrayList<Lugar> lugares;

    public Album(String nombre, String fecha, String descrip, ArrayList<Fotografia> fotos, ArrayList<Persona> personas, ArrayList<Lugar> lugares) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descrip = descrip;
        this.fotos = fotos;
        this.personas = personas;
        this.lugares = lugares;
    }

    public Album(String nombre, String descrip) {
        this.nombre = nombre;
        this.descrip = descrip;
        this.fotos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public ArrayList<Fotografia> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Fotografia> fotos) {
        this.fotos = fotos;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(ArrayList<Lugar> lugares) {
        this.lugares = lugares;
    }

    public void slideshow() {
        //presenta fotos en slideshow
    }

    public void moverFoto() {
        //cambia una foto de un album a otro
    }

    public void newAlbum(String nombre, String fecha, String descrip, ArrayList<Fotografia> fotos, ArrayList<Persona> personas, ArrayList<Lugar> lugares) {
        //obtine los datos de las ventanas con el get
        albumes.add(new Album(nombre, fecha, descrip, fotos, personas, lugares));
    }

    public void addFoto() {
        //añade una foto al album abierto
    }

    public void mostrarFotos() {
        //muestra las fotos del album seleccionado
    }

    public void mostrarAlbumes() {
        //muestra todos los albumes
    }

    public void serializar(Album album) {
        try {
            FileOutputStream fout = new FileOutputStream("album.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(album);

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public ArrayList<Album> deserializar(Album album) {
        ArrayList<Album> albums = new ArrayList();
        try {
            FileInputStream fin = new FileInputStream("album.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            Album a = (Album)in.readObject();
            albums.add(a);
                    

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return albums;
    }

}
