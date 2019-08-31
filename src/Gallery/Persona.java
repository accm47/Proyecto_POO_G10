/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import Gui.VentanaPersona;
import java.util.ArrayList;

/**
 *
 * @author BRYAN
 */
public class Persona {
    public static ArrayList<Persona> personas = new ArrayList<Persona>();
    
    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static void newPersona(){
        VentanaPersona.nuevaPersona();
    }
    
    
}
