/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.util.ArrayList;

/**
 *
 * @author Kevin Blum
 */
public class Galeria {
    private String idGaleria;
    private ArrayList<Album> albumes;

    public Galeria(String idGaleria, ArrayList<Album> albumes) {
        this.idGaleria = idGaleria;
        this.albumes = albumes;
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

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }
    
    
    
    public void CrearAlbum(){
    }
    
    public void mostrarAlbum(){
    }
    
    
    public void modificarPersona(){
    }
    
    public void eliminarPersona(){
    }
    
}
