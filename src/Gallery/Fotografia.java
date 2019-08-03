/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.util.ArrayList;

/**
 *
 * @author BRYAN y Kevin Blum
 */
public class Fotografia {
    protected String descrip;
    protected String fecha;
    protected Lugar lugar;
    protected Album album;
    protected ArrayList<Persona> personas;
    private Reacciones reacciones;
    private KeyWord keyword;

    public Fotografia(String descrip, String fecha, Lugar lugar, Album album, ArrayList<Persona> personas) {
        this.descrip = descrip;
        this.fecha = fecha;
        this.lugar = lugar;
        this.album = album;
        this.personas = personas;
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

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
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
    
    public void newFoto(){
        //subira una nueva foto
    }

    public void ventanaFoto(){
    
    
    
    
    }
    
}
