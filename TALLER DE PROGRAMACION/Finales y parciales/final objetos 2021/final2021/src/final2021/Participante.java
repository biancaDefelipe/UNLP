/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final2021;

/**
 *
 * @author bianc
 */
public class Participante {
    private String nombre; 
    private int dni; 
    private int edad; 

    public Participante(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
    
    
    
}
