/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02;

/**
 *
 * @author bianc
 */
public class Estacionamiento {
    private String nombre;
    private String direccion; 
    private String horaApertura; 
    private String horaCierre; 
    private int cantPisos; 
    private int cantPlazas; 
    
    private Auto[][]cocheras; 
    
    private int cantAutos; 
    
    public Estacionamiento (String nom, String dir, String apertura, String cierre, int pisos, int plazas){
        this.nombre= nom; 
        this.direccion= dir; 
        this.horaApertura=apertura; 
        this.horaCierre= cierre; 
        this.cantPisos=pisos; 
        this.cantPlazas= plazas; 
        this.iniciarCocheras(pisos, plazas); 
        
        this.cantAutos=0; 
    }
    public Estacionamiento (String nom, String dir){
        this.nombre= nom; 
        this.direccion= dir; 
        this.horaApertura="8:00"; 
        this.horaCierre= "21:00"; 
        this.cantPisos=5; 
        this.cantPlazas= 10; 
        this.iniciarCocheras(5, 10); 
        
        this.cantAutos=0; 
    }
    
    public void iniciarCocheras(int pisos, int plazas ){
        this.cocheras= new Auto[pisos][plazas];
        for (int fila=0; fila< pisos; fila++){
            for (int colum=0; colum < plazas; colum++){
                this.cocheras[fila][colum]= null; 
            }
        }
    }
    public boolean hayLugar(int piso, int plaza){
        return cocheras[piso][plaza] == null; 
    }
    public boolean registrarAuto(Auto a,int x, int  y){
        if (this.hayLugar(x, y)){
            cocheras[x][y]= a; 
            this.cantAutos++; 
            return true; 
        }
        return false; 
    }
    public String buscarPatente(String pat){
        int piso=0;
        int plaza=0; 
        boolean encontre= false; 
        while(!(encontre) &&( piso< this.cantPisos)){
            if ((plaza<this.cantPlazas) &&(piso < this.cantPisos)){
                if (cocheras[piso][plaza].getPatente().equals(pat)){
                    encontre =true; 
                }
                else{
                        plaza++; 
                    }
            }
            else{
                if (plaza== this.cantPlazas){
                        plaza=0; 
                        piso++; 
                    }     
                }
        }
        if (encontre){
            return " AUTO "+ pat + ": PISO: "+piso + " PLAZA: "+ plaza; 
        }
        else
               return " AUTO INEXISTENTE";
    }
    public int cantAutosEnPlaza(int y){
        int cant=0; 
        for (int filas=0; filas< this.cantPisos; filas ++){
            if (!(this.hayLugar(filas, y))){
                cant++; 
            }
            
        }
        return cant; 
    }
    
    @Override
    public String toString (){
        String aux="";
        for (int i=0; i< this.cantPisos; i++){
                     aux= aux+"                                                                           \n"
                             +"                     PISO "+i+"                                            \n" ;                 
            for (int j=0; j< this.cantPlazas; j++){
                if (this.hayLugar(i, j)){
                    aux= aux +" PLAZA LIBRE |";
                }
                else{
                    aux= aux + cocheras[i][j].toString()+" | "; 
                }
            }
        }
        return aux; 
    }
    
}
