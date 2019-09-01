/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import Gui.VentanaPersona;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author BRYAN
 */
public class Persona implements Serializable {
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
    
   
    @Override
    public String toString() {
        return   nombre ;
    }
    public static void serializar(ArrayList<Persona> g) {
        try {
            FileOutputStream fout = new FileOutputStream("persona.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(g);

            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static ArrayList<Persona> deserializar() {
        ArrayList<Persona> personas = new ArrayList();
        try {
            FileInputStream fin = new FileInputStream("persona.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            personas = (ArrayList<Persona>) in.readObject();
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return personas;
    }
    
}
