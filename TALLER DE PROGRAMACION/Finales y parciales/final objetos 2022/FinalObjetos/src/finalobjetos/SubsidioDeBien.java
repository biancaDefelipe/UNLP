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
public class SubsidioDeBien extends Subsidio {
    private Bien[] bienesSolicitados; 
    private int maxBienes; 
    private int dimL; 

    public SubsidioDeBien( int maxBienes, String nombreInvestigador, String planDeTrabajo, String fecha) {
        super(nombreInvestigador, planDeTrabajo, fecha);
        this.maxBienes = maxBienes;
        this.dimL = 0;
        this.iniciarBienes(maxBienes); 
    }
    
    public void iniciarBienes(int dimF){
        this.bienesSolicitados= new Bien[20]; 
        for (int i =0; i< dimF; i++){
            this.bienesSolicitados[i]= null; 
        }
    }
    public boolean hayEspacio(){
        return this.dimL< this.maxBienes; 
    }
    public boolean agregarBien(Bien bien){
        if (this.hayEspacio()){
            this.bienesSolicitados[this.dimL]= bien; 
            this.dimL++; 
            return true; 
        }
        else{
            return false; 
        }
    }
    
    public double obtenerCostoFinal(){
        double aux=0; 
        for (int i=0; i< this.dimL; i++ ){
            aux= aux+ this.bienesSolicitados[i].obtenerCostoFinalBien(); 
            
        }
        return aux; 
    }

    public Bien[] getBienesSolicitados() {
        return bienesSolicitados;
    }

    public int getMaxBienes() {
        return maxBienes;
    }

    public int getDimL() {
        return dimL;
    }
    
    @Override
    public double obtenerMontoTotal() {
        double aux=0; 
       for (int i=0; i< this.dimL; i++){
           aux= aux + this.bienesSolicitados[i].obtenerCostoFinalBien();
       }
       return aux; 
    }
    @Override
    public String toString (){
        String aux= super.toString()+ " costo final: "+ this.obtenerCostoFinal()+"\n"; 
        for (int i=0; i< this.getDimL(); i++){
            aux= aux+ "bien "+i+ ": "+this.bienesSolicitados[i].toString()+"\n"; 
    }
        return aux; 
}

 
    
}
