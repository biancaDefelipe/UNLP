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
public class Agencia {
    private Partido[] partidos;
    private Apuesta[] apuestas;
    private int dimLPartidos; 
    private int dimLApuestas; 
    
    
    
    
    public Agencia (){
        partidos= new Partido[20]; 
        apuestas = new Apuesta[100]; 
        this.iniciarPartidos(); 
        this.iniciarApuestas();
        this.dimLApuestas=0; 
        this.dimLPartidos=0; 
        
    }
    public void iniciarPartidos(){
        for (int i=0; i<20; i++){
            this.partidos[i]= null; 
        }
    }
    public void iniciarApuestas(){
        for (int i =0; i< 100; i++){
            this.apuestas[i]= null; 
        }
    }
    private boolean HayEspacioPartidos (){
        return (this.dimLPartidos < 20); 
    }
    public int agregarPartido(Partido partido){
        if (this.HayEspacioPartidos()){
        
            partidos[this.dimLPartidos]= partido; 
            this.dimLPartidos++; 
            return (this.dimLPartidos); 
        }
        else {
            return 0; 
        }
        
    }
    public boolean hayEspacioApuestas(){
        return this.dimLApuestas< 100; 
    }
    public boolean agregarApuesta (Apuesta apuesta){
        if (this.hayEspacioApuestas()){
            this.apuestas[this.dimLApuestas]= apuesta; 
            this.dimLApuestas++; 
            return true; 
        }
        else {
            return false; 
        }
    }
    
    public boolean cargarResultadoPartido (int id, String res){
        if ( (id < 20)){
            partidos[id-1].ingresarResultado(res.toLowerCase());
            return true; 
        }
        else
            return false; 
    }
    
   
    public String cerrarApuestas(){
        
       
        String aux= "";
        for (int i= 0; i < this.dimLApuestas; i++){
            int id_actual ; 
         
            id_actual = (apuestas[i].getId_partido ())-1 ;
           
       
            if (apuestas[i].acertada(partidos[id_actual].getResultado())   )   {
                aux= aux
                    +"nombre: "+ apuestas[i].getNombre()+ "\n"
                    +"dni: "+apuestas[i].getDni()+"\n"
                    +"dinero ganado: " +apuestas[i].calcularDinero(partidos[id_actual].obtenerMonto())+"\n"; 
        }
         
        }
        return aux;
     
    }

    public Partido[] getPartidos() {
        return partidos;
    }
    
    
}
