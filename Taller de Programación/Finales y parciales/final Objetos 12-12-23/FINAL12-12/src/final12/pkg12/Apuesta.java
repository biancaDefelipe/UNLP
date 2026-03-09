/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final12.pkg12;

/**
 *
 * @author bianc
 */
public class Apuesta {
    private String nombre; 
    private int dni; 
    private int id_partido; 
    private String apuesta; 
    
    private double montoApostado; 

    public Apuesta(String nombre, int dni, int id_partido, String apuesta, double montoApostado) {
        this.nombre = nombre;
        this.dni = dni;
        this.id_partido = id_partido;
        this.apuesta = apuesta.toLowerCase();
        this.montoApostado = montoApostado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoApostado() {
        return montoApostado;
    }

    public String getApuesta() {
        return apuesta;
    }

    public int getDni() {
        return dni;
    }

    public int getId_partido() {
        return id_partido;
    }
    
    public boolean acertada( String res){
        return this.apuesta.equals(res); 
    }
    public double calcularDinero(double monto){
        return this.montoApostado*monto; 
    }

    @Override
    public String toString() {
        return "Apuesta{" + "nombre=" + nombre + ", dni=" + dni + ", id_partido=" + id_partido + ", apuesta=" + apuesta + ", montoApostado=" + montoApostado + '}';
    }
    
    
}
