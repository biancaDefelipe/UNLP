/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author bianc
 */
public class EventoOcasional extends Recital{
    private String motivo; 
    private String nombreContratante; 
    private Fecha dia ; 
    
    public EventoOcasional (String banda, int cantTemas,String motivo, String contratista, Fecha dia ){
        super (banda, cantTemas); 
        this.motivo=motivo; 
        this.nombreContratante= contratista; 
        this.dia= dia; 
    }

    public String getMotivo() {
        return motivo;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public Fecha getDia() {
        return dia;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public void setDia(Fecha dia) {
        this.dia = dia;
    }
    
    public String actuar(){
        String aux = "";
        if ((this.getMotivo().equals("a beneficio")) || 
            (this.getMotivo().equals("A BENEFICIO"))||
             (this.getMotivo().equals("A beneficio"))){
             
            aux= " Recuerden colaborar con "+this.getNombreContratante()+ "\n";
             
    }
        if ((this.getMotivo().equals("show de tv")) || 
            (this.getMotivo().equals("SHOW DE TV"))||
             (this.getMotivo().equals("Show de TV"))){
            aux= " Saludos amigos televidentes \n"; 
            
        }
        if ((this.getMotivo().equals("show privado")) || 
            (this.getMotivo().equals("SHOW PRIVADO"))||
             (this.getMotivo().equals("Show privado"))) {
            aux= " Un feliz cumpleaños para "+this.getNombreContratante(); 
        }
        
        aux = aux + super.actuar(); 
        return aux; 
    }
    @Override
      public double calcularCosto(){
        if ((this.getMotivo().equals("a beneficio")) || 
            (this.getMotivo().equals("A BENEFICIO"))||
             (this.getMotivo().equals("A beneficio"))){
            return 0;
        }
        else{
            if ((this.getMotivo().equals("show de tv")) || 
                 (this.getMotivo().equals("SHOW DE TV"))||
                 (this.getMotivo().equals("Show de TV"))){
                    return 50000; 
            }
            }
      
            
        
       
         
            return 150000;
        }
    }

