/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01;

/**
 *
 * @author bianc
 */
public class Subsidio {
    private double montoPedido; 
    private String motivo; 
    private boolean otorgado; 
    
    public Subsidio (double monto, String motivo){
        this.montoPedido= monto; 
        this.motivo= motivo; 
        this.otorgado= false; 
        
    }
    
    public void otorgarMonto(){
        this.otorgado= true; 

    }

    public double getMontoPedido() {
        return montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    
    
}
