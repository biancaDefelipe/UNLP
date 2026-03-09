/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.Lector;

/**
 *
 * @author bianc
 */

// Declaración del estado o atributos
public class Triangulo {
    private double ladoUno; 
    private double ladoDos; 
    private double ladoTres; 
    private String colorRelleno; 
    private String colorLinea;    
    
    //CONSTRUCTOR 
    public Triangulo ( String relleno, String linea, double lado1, double lado2, double  lado3) {
      ladoUno = lado1; 
      ladoDos = lado2; 
      ladoTres = lado3; 
      colorRelleno = relleno; 
      colorLinea = linea; 
    }
    
 public Triangulo() {
    
    }
    
    //METODOS 
    
               //get y set 
    public double getLado1 (){
        return ladoUno;
    }
     public double getLado2 (){
        return ladoDos;
    }
    public double getLado3 (){
        return ladoTres;
    }
    public String getRelleno (){
        return colorRelleno; 
    }
    public String getLinea (){
        return colorLinea; 
    }
    public void setLado1 (double lado1){ 
        ladoUno = lado1; 
    }
    public void setLado2 (double lado2){ 
        ladoDos = lado2; 
    }
    public void setLado3 (double lado3){ 
        ladoTres = lado3; 
    }
    public void setRelleno (String relleno){ 
        colorRelleno = relleno; 
    }
    public void setLinea (String linea){
        colorLinea= linea; 
    }
    public String toString(){
      String aux = "lado 1: " + ladoUno + " | lado 2 "+ ladoDos + " | lado 3 " + ladoTres + " | color de relleno " + colorRelleno + "color de linea " + colorLinea; 
      return aux;
    }

    
    public double cacularPerimetro(){
        return this.getLado1()+ this.getLado2()+this.getLado3(); 
    }
    
    public double calcularArea(){
        double s= (this.cacularPerimetro())/2; 
       return  Math.sqrt(s*(s-this.getLado1())*(s-this.getLado2())* (s-this.getLado3())); 
        
    }
    
    
}
   