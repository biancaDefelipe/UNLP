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

public class Entrenador extends Empleado{
    private int cantCampeonatosGanados; 
 
    public Entrenador(){
        super(); 
    }
    public Entrenador (String nombre, double sueldoBasico, int antiguedad, int cantCampeonatos){
        super(nombre, sueldoBasico, antiguedad); 
        this.cantCampeonatosGanados= cantCampeonatos; 
    }

    public int getCantCampeonatosGanados() {
        return cantCampeonatosGanados;
    }

    public void setCantCampeonatosGanados(int cantCampeonatosGanados) {
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }
    
    private  double calcularPlusPorCampeonatos(){
        if( this.getCantCampeonatosGanados()> 0){
            if ((this.getCantCampeonatosGanados()>=1 ) && (this.getCantCampeonatosGanados() <=4)){
                return 5000; 
             }
             else if((this.getCantCampeonatosGanados()>=5) && (this.getCantCampeonatosGanados() <=10)){
                 return 30000; 
             }
             else {
                 return 50000;
             }
        }
            else{
                    return 0; 
                    }
    }
    
    @Override 
    public double calcularEfectividad(){
        return this.getCantCampeonatosGanados()/this.getAntiguedad(); 
    }
    @Override 
    public double calcularSueldoACobrar(){
        double base = this.calcularSueldoInicial(); 
        return base +this.calcularPlusPorCampeonatos(); 
    }

}
