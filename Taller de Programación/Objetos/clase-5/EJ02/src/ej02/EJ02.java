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
public class EJ02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estacionamiento estacionamiento = new Estacionamiento (" ESTACIONAMIENTO 24HS", "8 y 47", "07:00", "22:00", 3, 3);
        
        estacionamiento.registrarAuto(new Auto("pepe", "123 abc"), 2, 0); 
        estacionamiento.registrarAuto(new Auto("moni", "def 456"), 0, 0); 
        estacionamiento.registrarAuto(new Auto("alguien", "aaa 111"), 1, 2); 
        estacionamiento.registrarAuto(new Auto("coqui", "bbb 222"), 0, 2); 
        estacionamiento.registrarAuto(new Auto("messi", "ccc 226"), 0, 1); 
        estacionamiento.registrarAuto(new Auto("jorge", "jor 123"), 2, 1); 
        
        
        
    }
    
}
