/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gallery;

import Gui.VentanaLugar;
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
public class Lugar implements Serializable{
    public static ArrayList<Lugar> lugares = new ArrayList<Lugar>();
    
    protected String nombre;
    protected String descrip;

    public Lugar(String nombre) {
        this.nombre = nombre;
       
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
    public static void serializar(ArrayList<Lugar> l) {
        try {
            FileOutputStream fout = new FileOutputStream("lugar.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(l);

            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static ArrayList<Lugar> deserializar() {
        ArrayList<Lugar> lugares = new ArrayList();
        try {
            FileInputStream fin = new FileInputStream("lugar.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            lugares = (ArrayList<Lugar>) in.readObject();
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lugares;
    }
    
}
