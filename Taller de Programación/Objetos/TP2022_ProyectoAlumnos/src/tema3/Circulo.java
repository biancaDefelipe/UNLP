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
public class Circulo {
    private double radio; 
    private String colorRelleno; 
    private String colorLinea; 
    
    public Circulo(){
        
    }

    public Circulo(double radio, String colorRelleno, String colorLinea) {
        this.radio = radio;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
        
    public double calcularPerimetro (){
        return 2* Math.PI * this.radio; 
    }
    public double calcularArea(){
        return Math.PI* Math.pow(radio, 2); 
    }
    
    @Override 
    public String toString(){
        return " color de relleno: "+ this.colorRelleno +" \n"
                +" color de linea: "+ this.colorLinea+ " \n"
                +" radio: "+ this.radio; 
    }
    
}
