/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author bianc
 */


public class Hotel {
    private Habitacion [] habitaciones ; 
    private int dimF;
    private int dimL;
    
    
    
    public Hotel ( int dimF) {
        this.dimF= dimF;
        habitaciones= new Habitacion [dimF]; 
        for (int i=0; i< dimF; i ++){
            habitaciones[i]= new Habitacion(); 
        }
    } 
    public Hotel(){
        
    }
    //Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está 
//   en el rango 1..N) y que la habitación está libre.

    public boolean reservarHabitacion(Persona cliente, int numHabitacion){
        if (habitaciones[numHabitacion].reservarHabitacion(cliente)){
            this.setDimL(this.getDimL()+1);
            return true; 
            
        }
        return false;
    }
    //Aumentar el precio de todas las habitaciones en un monto recibido
    public void aumentarPrecioHabitaciones(double aumento){
        for (int i=0; i< dimF; i++){
            habitaciones[i].aumentarPrecio(aumento);
        }
    }
    public boolean estaDisponible (int habitacion){
        if (this.habitaciones[habitacion].isDisponible()){
            return true;
        }
        return false; 
    }
   

   

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

   
    public int getDimF() {
        return dimF;
    }

    public int getDimL() {
        return dimL;
    }
    //Obtener la representación String del hotel, siguiendo el formato: 
//  {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
    @Override
    
    public String toString(){
        String aux= " "; 
        for (int i =0; i < this.getDimF(); i ++){
            
            aux= aux + " Habitacion "+ i+ habitaciones[i].toString()+" \n";
        }
        return aux; 
    }
        
    }
