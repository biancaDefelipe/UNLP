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
public class EJ05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int dimF = 20;
        int dimL = 0; 
        Partido [] vector = new Partido[20]; 
        
        
         String visitante ; 
         System.out.print("  equipo visitante: "); 
         visitante = Lector.leerString(); 
         System.out.println(); 
         while (!(visitante.equals("ZZZ")) && dimL < dimF) {
             Partido partido = new Partido ();
             partido.setVisitante(visitante);
             
              System.out.print(" goles del partido visitante "); 
             partido.setGolesVisitante(Lector.leerInt());
             System.out.println();
             
             
             System.out.print(" equipo local: "); 
             partido.setLocal(Lector.leerString());
             System.out.println(); 
             
             System.out.print(" goles del equipo local: "); 
             partido.setGolesLocal(Lector.leerInt());
             System.out.println(); 
             
            
             vector[dimL]= partido; 
             dimL= dimL +1; 
             
             System.out.println("____________________________________"); 
             System.out.print("  equipo visitante: "); 
             visitante = Lector.leerString(); 
             System.out.println(); 
         }
         
         for (int i =0; i< dimL; i ++){
             System.out.println(vector[i].toString()); 
         }
         
         
         //informar partidos que gano river y cant goles de boca
         int golesBoca= 0; 
         int ganoRiver= 0; 
         
         for (int i=0; i< dimL; i++){
             if ((vector[i].getGanador().equals("river"))|| (vector[i].getGanador().equals("River")) || 
                     vector[i].getGanador().equals("RIVER")){
                 ganoRiver= ganoRiver +1; 
             }
             if ((vector[i].getVisitante().equals("boca"))|| (vector[i].getVisitante().equals("Boca")) || 
                     (vector[i].getVisitante().equals("BOCA"))){
                 golesBoca= golesBoca+ vector[i].getGolesVisitante(); 
             }
             else{
                 if  ((vector[i].getLocal().equals("boca")) || (vector[i].getLocal().equals("Boca")) || 
                      (vector[i].getLocal().equals("BOCA"))) {
                     golesBoca = golesBoca +vector[i].getGolesLocal(); 
                 }
             
         }
             
             
                
                 
                 
             }
         System.out.println(" PARTIDOS GANADOS POR RIVER : " + ganoRiver); 
         System.out.println(" GOLES DE BOCA: "+ golesBoca); 
         
    }
    }

   
    

