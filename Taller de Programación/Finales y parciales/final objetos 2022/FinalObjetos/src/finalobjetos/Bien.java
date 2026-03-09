/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalobjetos;

/**
 *
 * @author bianc
 */
public class Bien {
    private String descripcion; 
    private int cantidad; 
    private double costoPorUnidad; 

    public Bien(String descripcion, int cantidad, double costoPorUnidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoPorUnidad = costoPorUnidad;
    }
    
    
    public double obtenerCostoFinalBien(){
        return this.cantidad*this.costoPorUnidad; 
    }
    
    @Override
    public String toString(){
        return this.descripcion; 
    }
}
