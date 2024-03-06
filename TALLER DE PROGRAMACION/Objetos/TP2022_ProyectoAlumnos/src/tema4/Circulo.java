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



public class Circulo extends Figura {
    private double radio; 
    
    
    public Circulo(double radio, String relleno, String linea ){
        super(relleno, linea);
        this.radio=radio; 
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularPerimetro(){
        return 2* Math.PI * this.radio;
    }
    
    @Override 
    public double calcularArea(){
        return Math.PI* Math.pow(radio, 2); 
    }
    
    @Override
    public String toString (){
        String aux =super.toString(); 
        return aux+ " \n radio: "+ this.getRadio(); 
    }
}