/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01;

/**
 *
 * @author bianc
 */
public class EJ01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Investigador inv1= new Investigador("pepe", 1, "nose"); 
        Investigador inv2= new Investigador("moni", 4, "qsy");
        Investigador inv3= new Investigador("pepe2", 1, "nose"); 
        
        inv1.agregarSubsidio(new Subsidio(165000, "porfas ayuda"));
        inv1.agregarSubsidio(new Subsidio(70000, "porfas ayuda x2"));
        
        inv2.agregarSubsidio(new Subsidio(50000, "unMotivo"));
        inv2.agregarSubsidio(new Subsidio(30000, "cafecitoo"));
        
        inv3.agregarSubsidio(new Subsidio(120000, "motivos academicos¿?"));
        inv2.agregarSubsidio(new Subsidio(94500, "mas motivos academicos"));
        
        
        
        Proyecto proyecto1 = new Proyecto(" blabla", 123, "ehh messi");
        proyecto1.agregarInvestigador(inv1);
        proyecto1.agregarInvestigador(inv2);
        proyecto1.agregarInvestigador(inv3);
        proyecto1.otorgarTodos("moni");
        System.out.println(proyecto1.toString());
        
    }
    
}
