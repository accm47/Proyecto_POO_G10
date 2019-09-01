/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author BRYAN y Kevin Blum
 */
public class Fotografia implements Serializable{
    private String nombreArchivo;
    private String descrip;
    private String fecha;
    private String lugar;
    private Lugar lugars;

    private Album album;
    private ArrayList<Persona> personas;
    private Image imagen;
    private Reacciones reacciones;
    private ArrayList<KeyWord> keywords;
   

    public Fotografia(String descrip, String fecha, String lugar, Album album, ArrayList<Persona> personas, Image imagen, Reacciones reacciones, ArrayList<KeyWord> keywords, KeyWord keyword, Persona persona) {
        this.descrip = descrip;
        this.fecha = fecha;
        this.lugar = lugar;
        this.album = album;
        this.imagen = imagen;
        this.reacciones = reacciones;
        this.personas = personas;
        this.imagen = imagen;
        this.reacciones = null;
    
    }

    public ArrayList<KeyWord> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<KeyWord> keywords) {
        this.keywords = keywords;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    

    public Fotografia(String nombre,String descrip, String fecha, Lugar lugar, Album album) {
        this.nombreArchivo= nombre;
        this.descrip= descrip;
        this.fecha=fecha;
        this.lugars = lugar;
        this.album=album;
        this.personas= new ArrayList<Persona>();
        this.keywords= new ArrayList<KeyWord>();
    }

    public Fotografia(String descrip, String fecha, Lugar lugar, Album album, ArrayList<Persona> personas, Image imagen, KeyWord keyword) {
        this.descrip = descrip;
        this.fecha = fecha;
        this.lugars = lugar;
        this.album = album;
        this.personas = personas;
        this.imagen = imagen;
        this.reacciones = null;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Reacciones getReacciones() {
        return reacciones;
    }

    public void setReacciones(Reacciones reacciones) {
        this.reacciones = reacciones;
    }


    public void newFoto() {
        //subira una nueva foto
    }

    public void ventanaFoto() {

    }

}
