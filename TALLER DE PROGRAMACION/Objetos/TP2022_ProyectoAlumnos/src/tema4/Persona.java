/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;


public  class Persona {
    private String nombre;        //variables de instancia 
    private int DNI;              // caracterizan al objeto persona
    private int edad; 
    
    public Persona (String unNombre, int unDNI, int unaEdad){
        setNombre(unNombre);
        setDNI(unDNI);
        setEdad(unaEdad); 
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    
    
    @Override
    public String toString(){                                         //comportamiento
        String aux; 
        aux = " mi nombre es " + nombre + ", mi DNI es " + DNI + ", tengo  " + edad + " años";
        return aux;
    }
    
    
    
    
}
