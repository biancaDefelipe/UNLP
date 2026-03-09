/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final12.pkg12;

/**
 *
 * @author bianc
 */
public class Partido {
    private String local;
    private String visitante;
    private String resultado;
    private double factorPagoEmpate; 
    private double factorPagoVisitante; 
    private double factorPagoLocal; 

    public Partido(String local, String visitante, double facEmpate, double facVisitante, double facLocal ) {
        this.local = local;
        this.visitante = visitante;
        this.resultado ="";
        this.factorPagoEmpate= facEmpate; 
        this.factorPagoLocal= facLocal; 
        this.factorPagoVisitante= facVisitante; 
       
    }
    
    
    public void ingresarResultado(String resultado){
        this.resultado= resultado; 
    }

    public String getResultado() {
        return resultado;
    }

    public double getFactorPagoEmpate() {
        return factorPagoEmpate;
    }

    public double getFactorPagoVisitante() {
        return factorPagoVisitante;
    }

    public double getFactorPagoLocal() {
        return factorPagoLocal;
    }
    public double obtenerMonto(){
        if (this.resultado.equals("empate")){
            return this.factorPagoEmpate; 
        }
        else{
            if (this.resultado.equals("victoria local")){
                return this.factorPagoLocal; 
            }
            
            else{
                return this.factorPagoVisitante; 
            }
        }
    }
}
