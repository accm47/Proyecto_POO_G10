/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import java.util.ArrayList;

/**
 *
 * @author BRYAN
 */
public class Lugar {
    public ArrayList<Lugar> lugares = new ArrayList<Lugar>();
    
    protected String nombre;
    protected String descrip;

    public Lugar(String nombre, String descrip) {
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(ArrayList<Lugar> lugares) {
        this.lugares = lugares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    public void newLugar(String nombre, String descrip){
        //getNombre y getDescrip de la ventana de añadir nuevo lugar
        lugares.add(new Lugar(nombre, descrip));
        
    }
    
}
