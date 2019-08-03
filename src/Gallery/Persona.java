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
public class Persona {
    public ArrayList<Persona> personas = new ArrayList<Persona>();
    
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
    
    public void newPersona(String nombre){
        //getNombre de la ventana para ingregar una nueva persona
        personas.add(new Persona(nombre));
    }
    
    
}
