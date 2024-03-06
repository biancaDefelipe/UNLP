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
public class Proyecto {
    private String nombre; 
    private int codigo; 
    private String director; 
    private Investigador [] investigadores; 
    
    private static int maxInvestigadores = 50; 
    private int cantInvestigadores; 
    
    public Proyecto( String nombre, int codigo, String director){
        this.nombre=nombre; 
        this.codigo= codigo; 
        this.director= director; 
        this.cantInvestigadores= 0; 
        this.investigadores= new Investigador[50];
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDirector() {
        return director;
    }

    public int getCantInvestigadores() {
        return cantInvestigadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCantInvestigadores(int cantInvestigadores) {
        this.cantInvestigadores = cantInvestigadores;
    }
    
    public  void agregarInvestigador(Investigador unInvestigador){
        this.investigadores[this.cantInvestigadores]= unInvestigador; 
        this.cantInvestigadores++; 
    }
    public double dineroTotalOtorgado(){
    //devolver el monto total otorgado en subsidios del proyecto (tener en cuenta 
    //todos los subsidios otorgados de todos los investigadores)
        double monto=0; 
        for (int i =0; i< this.cantInvestigadores; i++){
            monto = monto + investigadores[i].dineroTotalOtorgado(); 
        }
        return monto; 
     }
    public void otorgarTodos(String investigador){
        for (int i=0; i< this.cantInvestigadores; i++){
            if (investigadores[i].getNombreCompleto().equals(investigador)){
                investigadores[i].otorgarTodos();
            }
        }
    }
    @Override
   public String toString(){
       String aux= " PROYECTO NRO    :   "+ this.codigo+ "\n"
                 + "         NOMBRE:     "+ this.getNombre()+"\n"
                 + "         DIRECTOR:   "+ this.getDirector()+"\n"   
                 + "MONTO TOTAL OTORGADO: "+ this.dineroTotalOtorgado()+"\n"
                 +" investigadores: \n"; 
       for (int i=0; i< this.getCantInvestigadores(); i++){
           aux = aux + investigadores[i].toString()+"\n";
           
       }
       return aux;
       
       
   }
    
          

}
