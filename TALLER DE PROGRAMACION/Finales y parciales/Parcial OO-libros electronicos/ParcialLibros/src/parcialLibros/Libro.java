/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialLibros;

/**
 *
 * @author bianc
 */
public abstract class Libro {
    private String titulo; 
    private double precioBase; 
    private String[] autores; 
    private final int dimF=8; 
    private int cantAutores;

    public Libro(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.autores= new String [this.dimF]; 
        this.inicializarAutores(); 
        this.cantAutores= 0; 
     
    }
    private void inicializarAutores (){
        for (int i=0; i< this.dimF; i++){
            autores[i]= null; 
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String[] getAutores() {
        return autores;
    }

    public int getCantAutores() {
        return cantAutores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setCantAutores(int cantAutores) {
        this.cantAutores = cantAutores;
    }
    
    
    //i- Agregar al libro un autor cuyo nombre se recibe. Asuma que hay espacio.
    public boolean hayEspacio(){
        return (this.cantAutores< this.dimF); 
    }
    public boolean agregarAutor (String autor){
        if (this.hayEspacio()){
            this.autores[this.cantAutores]= autor;
            this.cantAutores++; 
            return true; 
        }
        return false; 
    }
   // ii- Obtener el precio final del libro teniendo en cuenta que:
//- Para los libros electrónicos es el precio base al que se adiciona un impuesto de descarga de
//2,5$ por MB.
//- Para los libros impresos es el precio base al que se adiciona 500$ si es de tapa dura.
    public abstract double obtenerPrecioFinal(); 
    
    @Override
    public String toString (){
        String aux=  " TITULO: " + this.getTitulo()+ "\n"; 
        aux= " AUTORES: \n"; 
        for (int i =0; i< this.cantAutores; i++){
            aux= aux+ "       " + autores[i]+ "\n"; 
        }
        return aux; 
    }; 
}
