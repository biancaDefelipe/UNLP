/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

/**
 *
 * @author bianc
 */

import PaqueteLectura.Lector; 	

public class EJ4 {
   
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        
        int dias ;                  // cantidad de dias
        int turnos ;                  //filas 
        
        Persona [][] casting = new Persona [8][5]; 
        
        int dimL=0; 
        dias=0; 
        turnos=0; 
        
        System.out.println("nombre: "); 
        String nombre= Lector.leerString(); 
        while( (dimL < 40) && !(nombre.equals("zzz") )){
            Persona persona= new Persona(); 
            persona.setNombre(nombre);
            
            System.out.println("edad: "); 
            persona.setEdad(Lector.leerInt());
            
            System.out.println(" DNI: ");
            persona.setDNI(Lector.leerInt());
            
            casting[turnos][dias]= persona; 
            System.out.println("turnos= "+ turnos+ " dia "+dias); 
            dimL=dimL+1;
            if ((turnos== 7)){
                dias= dias +1; 
                turnos=0; 
            }
            else {
                turnos = turnos +1;
            }
            System.out.println("nombre: "); 
            nombre= Lector.leerString(); 
        }
        
        //imprimo
        int filas=0;
        int columnas=0; 
        int cant = dimL; 
        while (cant != 0){
           while ((cant !=0) &&(columnas <5)){
                while ((cant !=0)&& (columnas < 5) &&(filas <8)){
                    System.out.print(" dia "+ columnas+ " turno "+ filas+" :"); 
                    System.out.println(casting[filas][columnas].getNombre());
                    System.out.println("___________________________________________________________");
                    
                    filas= filas +1; 
                    cant= cant -1; 
                }
                if (filas == 8){
                    columnas = columnas +1; 
                    filas =0; 
                }
                
           }
                
        }
            
            
            
            

       
    }
    }
    
