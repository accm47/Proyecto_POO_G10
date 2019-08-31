/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author BRYAN y Kevin Blum
 */
public class Fotografia {
    private String descrip;
    private String fecha;
    private String lugar;
    private Album album;
    private ArrayList<Persona> personas;
    private Image imagen;
    private Reacciones reacciones;
    private ArrayList<KeyWord> keywords;
     private KeyWord keyword;
    private Persona persona;
    

    public Fotografia(String descrip, String fecha, String lugar, Album album, Persona persona,KeyWord key) {
        this.descrip = descrip;
        this.fecha = fecha;
        this.lugar = lugar;
        this.album = album;
        this.persona = persona;
        keyword= key;
        
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

    public KeyWord getKeyword() {
        return keyword;
    }

    public void setKeyword(KeyWord keyword) {
        this.keyword = keyword;
    }
    
    
    
    public void newFoto(){
        //subira una nueva foto
    }

    public void ventanaFoto(){
    
    
    
    
    }
    
}
