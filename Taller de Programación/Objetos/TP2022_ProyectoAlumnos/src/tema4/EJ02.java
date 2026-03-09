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
import PaqueteLectura.Lector;
public class EJ02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jugador jugador = new Jugador(); 
        Entrenador entrenador= new Entrenador(); 
        
        System.out.print(" nombre del jugador: "); 
        jugador.setNombre(Lector.leerString());
        System.out.println();
        
        System.out.print(" sueldo base del jugador: "); 
        jugador.setSueldoBasico(Lector.leerDouble());
        System.out.println();
        
        System.out.print(" antiguedad del jugador: "); 
        jugador.setAntiguedad(Lector.leerInt());
        System.out.println();
        
        System.out.print("Cantidad de partidos jugados: "); 
        jugador.setPartidosJugados(Lector.leerInt());
        System.out.println();
        
        System.out.print(" Cantidad de goles anotados: "); 
        jugador.setGolesAnotados(Lector.leerInt());
        System.out.println();
        
        System.out.println("____________________________________________________");
        
           
        System.out.print(" nombre del entrenador: "); 
        entrenador.setNombre(Lector.leerString());
        System.out.println();
        
        System.out.print(" sueldo base del entrenador: "); 
        entrenador.setSueldoBasico(Lector.leerDouble());
        System.out.println();
        
        System.out.print(" antiguedad del entrenador: "); 
        entrenador.setAntiguedad(Lector.leerInt());
        System.out.println();
        
        System.out.print(" Cantidad de campeonatos ganados: ");
        entrenador.setCantCampeonatosGanados(Lector.leerInt());
        System.out.println(); 
        
         System.out.println(jugador.toString()); 
         System.out.println(entrenador.toString());
    }
    
}
