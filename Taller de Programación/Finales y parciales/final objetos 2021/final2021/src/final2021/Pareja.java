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
public class Pareja {
    private String estilo; 
    private Participante participante1; 
    private Participante participante2; 

    public Pareja(String estilo, Participante participante1, Participante participante2) {
        this.estilo = estilo;
        this.participante1 = participante1;
        this.participante2 = participante2;
    }
    
    
    public int obtenerDiferenciaDeEdad(){
        if (this.participante1.getEdad()> this.participante2.getEdad()){
            return (this.participante1.getEdad()- this.participante2.getEdad()); 
        }
        else{
            return (this.participante2.getEdad()-this.participante1.getEdad()); 
        }
    }
    public String obtenerParticipantes(){
        return this.participante1.getNombre() +" , "+ this.participante2.getNombre(); 
    }
      
}
