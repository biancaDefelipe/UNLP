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
  import PaqueteLectura.Lector;
public class EJ04 {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
        // TODO code application logic here
         Hotel hotel;
         
         System.out.print(" ingrese cantidad de habitaciones del hotel"); 
         int cant = Lector.leerInt(); 
         hotel= new Hotel(cant); 
         
         boolean seguir= true; 
         while (seguir){
             System.out.print(" numero de habitacion a reservar: "); 
             int numHabitacion = Lector.leerInt();
             
             if (hotel.estaDisponible(numHabitacion)){
                 System.out.print(" nombre del cliente: "); 
                String nom= Lector.leerString(); 
                 System.out.println(); 
             
                System.out.print(" dni del cliente: "); 
                int dni= Lector.leerInt(); 
                System.out.println();
                
                System.out.print(" edad del cliente: ");
                int edad = Lector.leerInt(); 
                System.out.println(); 
                Persona cli= new Persona (nom, dni, edad); 
                boolean ok=hotel.reservarHabitacion(cli, numHabitacion); 
                if (ok){
                   System.out.println("habitacion reservada");
                }
             }
                  
             else{
                 System.out.println(" La habitacion no se encuentra disponible"); 
             }
             System.out.println("------------------------------------------------------------------");
             System.out.print("si desea continuar ingrese 'true', de lo contrario ingrese false "); 
             seguir= Lector.leerBoolean(); 
             
             
         }
       
        System.out.println("         estado de las habitaciones del hotel            "); 
        System.out.println( hotel.toString()); 
        
         
        System.out.print(" ingrese el monto a incrementar al precio de las habitaciones: "); 
        double monto = Lector.leerDouble();
        hotel.aumentarPrecioHabitaciones(monto);
        
          System.out.println("         estado de las habitaciones del hotel            "); 
        System.out.println( hotel.toString()); 
                
    }
    
}
