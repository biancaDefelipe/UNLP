package parcialLibros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bianc
 */
public class LibroElectronico extends Libro{
    private String formato;
    private double tamanio; 

    public LibroElectronico(String formato, double tamanio, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.formato = formato;
        this.tamanio = tamanio;
    }

    public double getTamanio() {
        return tamanio;
    }
    
    
    @Override 
    public double obtenerPrecioFinal(){
        return (super.getPrecioBase() + this.getTamanio()*2.5); 
    }
    @Override
    public String toString(){
        String aux= super.toString() + "\n "+ "PRECIO FINAL: "+ this.obtenerPrecioFinal(); 
        return aux; 
    }
    
    
}
