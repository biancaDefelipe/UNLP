/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final2021;

/**
 *
 * @author bianc
 */
public class Final2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Concurso concurso = new Concurso(20); 
       
        concurso.agregarPareja(new Pareja (" ballet", (new Participante ("shrek", 31241, 30)),
                                                        (new Participante("fiona", 4312, 29))) ); 
         concurso.agregarPareja(new Pareja ("salsa", (new Participante ("taylor swift", 131313, 34)),
                                                    (new Participante("travis", 121212, 34) )) ); 
      
            System.out.println(concurso.getParejas()[0].obtenerParticipantes() );
             System.out.println(concurso.getParejas()[1].obtenerParticipantes() );
        Pareja max= concurso.parejaConMayorDiferenciaDeEdad(); 
        
        System.out.println(max.obtenerParticipantes()); 
        
    }
    
}
