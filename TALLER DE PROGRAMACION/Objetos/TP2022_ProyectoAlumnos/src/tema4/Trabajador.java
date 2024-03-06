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
public class Trabajador   {
    private Persona persona; 
    private String tareaARealizar; 
  


    //constructor
  public Trabajador (Persona person, String unaTarea){
      persona = person;
      setTareaARealizar(unaTarea); 
  }

    public void setTareaARealizar(String unaTarea) {
        this.tareaARealizar = unaTarea;
    }

    public String getTareaARealizar() {
        return tareaARealizar;
    }

    @Override
    public String toString() {
      String aux = persona.toString()
                   +". Soy " + getTareaARealizar();
      return aux; 
      
    }
    
    

    
  
  
  

  
  
  
  }
  
