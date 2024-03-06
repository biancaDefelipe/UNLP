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
// Declaración del estado o atributos
public class Autor {
    private String nombre; 
    private String biografia; 
    private String origen; 

    
    //CONSTRUCTOR 
   public Autor ( String nom, String bio, String ori ) {
      nombre = nom; 
      biografia = bio; 
      origen = ori; 
   }
    

    //METODOS 
    
               //get y set 
    public String getNombre (){
        return nombre;
    }
     public String geBiografia (){
        return biografia;
    }
    public String getOrigen  (){
        return origen;
    }

    public void seNombre (String nom){ 
        nombre = nom; 
    }
    public void setLado2 (String bio){ 
        biografia = bio; 
    }
    public void setLado3 (String ori){ 
       origen = ori; 
     }
    @Override
    public String toString(){
      String aux = "nombre : " + nombre + " | biografia "+ biografia + " | origen  " + origen ; 
      return aux;
    }
    
    
    
    
    
    
     
    
    
}
