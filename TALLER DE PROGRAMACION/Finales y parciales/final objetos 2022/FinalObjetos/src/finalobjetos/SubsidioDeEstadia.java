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
public class SubsidioDeEstadia extends Subsidio {
    private String destino; 
    private double costoPasajes; 
    private int diasDeEstadia; 
    private double montoHotelPorDia; 

    public SubsidioDeEstadia(String destino, double costoPasajes, int diasDeEstadia, double montoHotelPorDia, String nombreInvestigador, String planDeTrabajo, String fecha) {
        super(nombreInvestigador, planDeTrabajo, fecha);
        this.destino = destino;
        this.costoPasajes = costoPasajes;
        this.diasDeEstadia = diasDeEstadia;
        this.montoHotelPorDia = montoHotelPorDia;
    }

    public String getDestino() {
        return destino;
    }

    public double getCostoPasajes() {
        return costoPasajes;
    }

    public int getDiasDeEstadia() {
        return diasDeEstadia;
    }

    public double getMontoHotelPorDia() {
        return montoHotelPorDia;
    }
    
    
    @Override
    public double obtenerMontoTotal(){
        return this.costoPasajes+ (this.diasDeEstadia*this.montoHotelPorDia); 
    }
    @Override 
    public String toString(){
        String aux= super.toString(); 
        aux= aux+ " Monto total: "+ this.obtenerMontoTotal()+ " \n"
                + " Lugar de destino: "+this.getDestino()+ "\n"
                + " Dias de estadia: "+ this.getDiasDeEstadia(); 
        
        return aux; 
        
    }
    
}
