/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalobjetos;

/**
 *
 * @author bianc
 */
public class FinalObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int maxBienes, String nombreInvestigador, String planDeTrabajo, String fecha)
        SubsidioDeBien subDeTaylor= new SubsidioDeBien (7, "taylor swift", "reputation", "10 de noviembre" ); 
        
        //String descripcion, int cantidad, double costoPorUnidad
        subDeTaylor.agregarBien(new Bien("paraguas", 10000, 10000)); 
        subDeTaylor.agregarBien(new Bien ("anillos de serpiente", 1, 1000000)); 
        subDeTaylor.agregarBien(new Bien ("vinos caros",89, 89000 )); 
        //String destino, double costoPasajes, int diasDeEstadia, double montoHotelPorDia, String nombreInvestigador, String planDeTrabajo, String fecha
        SubsidioDeEstadia subDePedro = new SubsidioDeEstadia("algun lado", 100000,20,95000, "pedro pascal", "no se","1 de enero"  ); 
        
        System.out.println(subDeTaylor.toString()); 
         System.out.println(subDePedro.toString()); 
    }
    
}
