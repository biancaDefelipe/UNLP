/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01;

/**
 *
 * @author bianc
 */
public class Investigador {
    private String nombreCompleto; 
    private int categoria; 
    private String especialidad; 
    private Subsidio [] subsidios;
    
    private int subsidiosPedidios;  
    
    //Un investigador sólo debería poder construirse con nombre, categoría y 
    //especialidad.
    
    public Investigador (String nombre, int categoria, String especialidad){
        this.nombreCompleto= nombre; 
        this.especialidad= especialidad; 
        this.categoria= categoria; 
        this.subsidios= new Subsidio[5]; 
        this.subsidiosPedidios=0; 
        
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setSubsidiosOtorgados(int subsidiosPedidios) {
        this.subsidiosPedidios = subsidiosPedidios;
    }


    public int getSubsidiosOtorgados() {
        return subsidiosPedidios;
    }
    
    
    public void agregarSubsidio(Subsidio unSubsidio){
        this.subsidios[this.subsidiosPedidios]= unSubsidio; 
        this.subsidiosPedidios++; 
    }
    
    public double dineroTotalOtorgado(){
    //devolver el monto total otorgado en subsidios del proyecto (tener en cuenta 
    //todos los subsidios otorgados de todos los investigadores)
        double monto=0; 
        for (int i=0; i< this.subsidiosPedidios; i++){
            if( subsidios[i].isOtorgado()){
                monto= monto+ subsidios[i].getMontoPedido(); 
            }
        }
        return monto; 
     }
    public void otorgarTodos(){
//otorgar todos los subsidios no-otorgados del investigador llamado 
//nombre_completo
        for (int i=0; i<this.subsidiosPedidios; i++){
               if (!(this.subsidios[i].isOtorgado())){
                   subsidios[i].setOtorgado(true);
               }
        }
    
    }
  
    @Override
    public String toString(){
        String aux= " NOMBRE: "+ this.getNombreCompleto()+"\n"
                  + " CATEGORIA: "+ this.getCategoria()+ "\n"
                  + " ESPECIALIDAD: "+ this.getEspecialidad()+"\n"
                  + " TOTAL DE DINERO DE LOS SUBSIDIOS OTORGADOS: "+ this.dineroTotalOtorgado();
                  
        return aux; 
        
    }
    
}
