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
import PaqueteLectura.GeneradorAleatorio;


public class Habitacion{
    private double costoPorNoche; 
    private boolean disponible;
    private Persona cliente; 

    public Habitacion() {
        this.costoPorNoche = (GeneradorAleatorio.generarDouble(8001)+2000);
        this.disponible= true; 
    }

    public double getCostoPorNoche() {
        return costoPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCostoPorNoche(double costoPorNoche) {
        this.costoPorNoche = costoPorNoche;
    }
    public void aumentarPrecio (double aumento){
        this.costoPorNoche= this.costoPorNoche+aumento; 
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    public boolean reservarHabitacion(Persona cliente){
        if (this.isDisponible()){
            this.cliente= cliente; 
            this.setDisponible(false);
            return true; 
        }
        else {
            return false; 
    }
    }
   @Override
   public String toString(){
      String aux= " PRECIO POR NOCHE: "+this.getCostoPorNoche()+"\n"; 
      if (!(this.disponible)){
          return aux + (" ESTADO: OCUPADA || nombre del cliente: "
                  +this.cliente.getNombre()
                  +" , dni:  "
                  +this.cliente.getDNI()
                  +" , edad: "
                  +this.cliente.getEdad() 
                  +"  "); 
   }
      else{
          return aux + " ESTADO: DISPONIBLE "; 
      }
}
}

