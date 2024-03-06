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
public class Gira extends Recital  {
    private String nombre; 
    private Fecha[] fechas; 
    private int proximaFecha; 
    private int cantFechas; 
    private int dimL; 

    public Gira(String banda, int cantTemas,String nombre, int cantFechas) {
        super(banda, cantTemas);
        this.nombre = nombre;
        this.fechas = new Fecha[cantFechas];
        this.cantFechas= cantFechas; 
        this.dimL=0; 
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha[] getFechas() {
        return fechas;
    }

    public int getProximaFecha() {
        return proximaFecha;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechas(Fecha[] fechas) {
        this.fechas = fechas;
    }

    public void setProximaFecha(int f) {
        this.proximaFecha =f;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }
    public boolean hayEspacioFechas(){
        return this.dimL< this.cantFechas; 
    }
    public boolean agregarFecha(Fecha f){
        if (this.hayEspacioFechas()){
          this.fechas[this.dimL]= f;
          this.dimL++; 
          return true; 
        }
        else{
            return false; 
        }
    }
    

    @Override
    public String actuar(){
        String aux = "Buenas noches "+this.fechas[this.proximaFecha].getCiudad(); 
        aux= aux+super.actuar(); 
        this.proximaFecha++; 
        return aux; 
    }
    @Override
    public double calcularCosto(){
        return this.cantFechas*this.cantFechas;
    }
}
