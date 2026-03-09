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
public class Concurso {
    private Pareja[] parejas; 
    private int dimF; 
    private int dimL; 

    public Concurso(int dimF) {
        this.dimF = dimF;
        this.dimL = 0;
        this.iniciarParejas(dimF); 
        
    }
    public void iniciarParejas(int dimF){
        this.parejas= new Pareja[dimF] ;
        for (int i=0; i< dimF; i++){
            parejas[i]= null; 
       }
    }
    
    public boolean hayEspacio(){
        return this.dimL<this.dimF; 
    }
    public boolean agregarPareja(Pareja pareja){
        if (this.hayEspacio()){
            parejas[this.dimL]= pareja; 
            this.dimL++; 
            return true; 
            
        }
        return false;
        
    }

    public Pareja[] getParejas() {
        return parejas;
    }
    
    public Pareja parejaConMayorDiferenciaDeEdad(){
        int indiceMax=-1; 
        int diferencia=0; 
        for (int i=0; i<this.dimL; i++){
            System.out.println(parejas[i].obtenerDiferenciaDeEdad());
            if (this.parejas[i].obtenerDiferenciaDeEdad()> diferencia){
           
                indiceMax= i;
                diferencia= parejas[i].obtenerDiferenciaDeEdad(); 
                
            }
        }
        return parejas[indiceMax]; 
    }
}
