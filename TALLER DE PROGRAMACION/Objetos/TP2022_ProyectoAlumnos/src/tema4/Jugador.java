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

public class Jugador extends Empleado {
    private int partidosJugados; 
    private int golesAnotados; 
    
    public Jugador (){
        super(); 
        
    }
    public Jugador(String nombre, double sueldoBasico, int antiguedad, int partidosJugados, int golesAnotados){
        super(nombre, sueldoBasico, antiguedad); 
        this.partidosJugados= partidosJugados; 
        this.golesAnotados=golesAnotados; 
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
   
    
    @Override
    public double calcularEfectividad (){
        return this.getGolesAnotados()/this.getPartidosJugados(); 
    }
     @Override 
    public double calcularSueldoACobrar(){
        double base = this.calcularSueldoInicial(); 
        if (this.calcularEfectividad()>0.5 ){
            return base + ((super.getSueldoBasico()*0.1)* super.getAntiguedad());
        }
        else{
            return base; 
        }
    }
}