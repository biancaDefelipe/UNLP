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



public class VisorFigurasModificado {
    private int guardadas;
    private int capacidadMaxima=5;
    private Figura [] vector;
 
    public VisorFigurasModificado(){
        this.vector= new Figura[5];
        guardadas=0; 
    }
 
    public void guardar(Figura f){
        if (this.quedaEspacio()){
            this.vector[guardadas]= f; 
            guardadas++; 
        }
        else{
            System.out.println("no queda espacio suficiente para guardar la figura");
        }
    }
    public boolean quedaEspacio(){
        return this.guardadas<this.capacidadMaxima; 
    }
 
    public void mostrar(){
        for (int i= 0; i <this.guardadas ;i++){
            System.out.println(vector[i].toString());
        }
    }
    public int getGuardadas() {
        return guardadas;
    }
 
}
 
 //sigue a la derecha ->
/*
public class VisorFigurasModificado {
   private int guardadas;
   private int capacidadMaxima=5;
   private Figura [] vector;

   
       //constructor 
   public VisorFigurasModificado(Figura f){
     if (quedaEspacio() == true ) {
        guardar(f); 
     }
   }  

   public void guardar(Figura f){
     vector = new  Figura [getGuardadas()]; //tipo de figura  
     vector[getGuardadas()]= f; 
     guardadas ++; 
           
 
   }
   public boolean quedaEspacio(){
     if (getGuardadas() <= capacidadMaxima) {
         return true; 
     }
     else
       return false; 
   }

   public void mostrar(Figura f){
    for (int i=0 ; i<capacidadMaxima; i ++ ){
        System.out.println(f.toString()); 
    }
   }
   public int getGuardadas() {
   return guardadas;
   }

}
*/