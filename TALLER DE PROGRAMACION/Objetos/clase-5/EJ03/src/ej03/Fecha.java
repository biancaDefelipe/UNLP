/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author bianc
 */
public class Fecha {
    private int dia; 
    private String ciudad; 

    public Fecha(int dia) {
        this.dia = dia;
    }

    public Fecha(int dia, String ciudad) {
        this.dia = dia;
        this.ciudad = ciudad;
    }

    public int getDia() {
        return dia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
