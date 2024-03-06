/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02;

/**
 *
 * @author bianc
 */
public class Auto {
    private String dueño; 
    private String patente; 
    
    public Auto(){
        
    }
    public Auto(String nom, String pat){
        this.dueño=nom; 
        this.patente= pat; 
    }

    public String getDueño() {
        return dueño;
    }

    public String getPatente() {
        return patente;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    
    @Override
    public String toString(){
        return  " PATENTE: "+this.getPatente()+"\n"
                +" DUEÑO:   "+ this.getDueño();
    }
}
