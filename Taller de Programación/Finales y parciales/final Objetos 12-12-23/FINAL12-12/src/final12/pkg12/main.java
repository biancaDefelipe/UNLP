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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Agencia agencia= new Agencia(); 
         //Partido(String local, String visitante, double facEmpate, double facVisitante, double facLocal ) 
        int gimnasiaBarracas= agencia.agregarPartido(new Partido("Gimnasia", "Barracas", 20, 50, 70 )); 
        int bocaRiver= agencia.agregarPartido(new Partido ("Boca", "River", 100, 650, 550)); 
        int sacachispasColegiales= agencia.agregarPartido(new Partido("Sacachispas", "Colegiales", 15, 20, 50)); 
    
        
        // public Apuesta(String nombre, int dni, int id_partido, String apuesta, double montoApostado)
         agencia.agregarApuesta(new Apuesta("pepe", 12345, gimnasiaBarracas, "empate", 100)); 
         agencia.agregarApuesta(new Apuesta("coqui", 54321, gimnasiaBarracas, "victoria local", 500)); 
         
         agencia.agregarApuesta(new Apuesta ("moni", 142335, bocaRiver, "victoria visitante", 1000));  
         
         agencia.agregarApuesta(new Apuesta ("jorgito", 235233, sacachispasColegiales, "victoria local", 80)); 
         agencia.agregarApuesta(new Apuesta("pepe", 12345, sacachispasColegiales, "empate", 5)); 
         agencia.agregarApuesta(new Apuesta ("coqui", 54321, sacachispasColegiales, "victoria visitante", 44)); 
         
         agencia.cargarResultadoPartido(gimnasiaBarracas, "victoria local" ); 
         agencia.cargarResultadoPartido(bocaRiver, "empate"); 
         agencia.cargarResultadoPartido(sacachispasColegiales, "victoria local"); 
         
         
         System.out.println(agencia.cerrarApuestas()); 
    }
    
}
