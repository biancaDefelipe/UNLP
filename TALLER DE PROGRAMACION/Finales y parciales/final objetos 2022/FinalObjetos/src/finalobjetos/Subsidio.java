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
public abstract class Subsidio {
    private String nombreInvestigador;
    private String planDeTrabajo; 
    private String fecha; 

    public Subsidio(String nombreInvestigador, String planDeTrabajo, String fecha) {
        this.nombreInvestigador = nombreInvestigador;
        this.planDeTrabajo = planDeTrabajo;
        this.fecha = fecha;
    }
    
    public abstract double  obtenerMontoTotal(); 

    public String getNombreInvestigador() {
        return nombreInvestigador;
    }

    public String getPlanDeTrabajo() {
        return planDeTrabajo;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    @Override
    public String toString (){
        String aux= ""; 
        aux = aux + " Nombre del investigador: "+ this.getNombreInvestigador()+ "\n"
                  + " Plan de trabajo: "+ this.getPlanDeTrabajo()+" \n"
                  + " Fecha de solicitud: "+ this.getFecha() + "\n"; 
        return aux; 
        
    }
}
