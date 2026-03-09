/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author bianc
 */

public abstract class Empleado {
    private String nombre;
    private double sueldoBasico; 
    private int antiguedad; 

    public Empleado(){
        
    }
    public Empleado(String nombre, double sueldoBasico, int antiguedad) {
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public double calcularSueldoInicial(){
        return this.getSueldoBasico()+ (this.getSueldoBasico()*0.1)* this.getAntiguedad(); 
    }
   public abstract double  calcularEfectividad(); 
    
    public abstract double calcularSueldoACobrar(); 
    
    
   
    @Override
    public String toString(){
        return " NOMBRE: "+this.getNombre() +"\n"
               +" SUELDO A COBRAR: "+this.calcularSueldoACobrar()+"\n"
               +" EFECTIVIDAD: "+this.calcularEfectividad() +"\n"; 
    }
    
    
}