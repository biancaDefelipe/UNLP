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
public abstract class Recital {
    private String banda; 
    private String[] listaTemas; 
    private int cantTemas; 
    private int dimL;

    public Recital(String banda, int cantTemas) {
        this.banda = banda;
        this.cantTemas = cantTemas;
        this.listaTemas= new String [cantTemas];
        this.dimL=0;
    }

    public String getBanda() {
        return banda;
    }

    public String[] getListaTemas() {
        return listaTemas;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }
    public boolean hayEspacioTemas(){
        if (this.dimL< this.cantTemas){
            return true; 
        }
        return false; 
    }
    public boolean agregarTema (String tema){
        if (hayEspacioTemas()){
            this.listaTemas[this.dimL]=tema; 
            this.dimL++; 
            return true;
            
        }
        else {
            return false;
        }
            
    }
    public String actuar (){
        String aux= "";
        for ( int i=0;i<this.cantTemas;i++ ){
            aux= aux + " Y ahora tocaremos "+this.listaTemas[i];
        }
    }
    public abstract double calcularCosto();
}

    
   
    
    
