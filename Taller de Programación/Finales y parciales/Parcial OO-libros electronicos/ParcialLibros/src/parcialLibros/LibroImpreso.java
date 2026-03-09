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
public class LibroImpreso extends Libro {
    private boolean tapaDura; 

    public LibroImpreso(boolean tapaDura, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.tapaDura = tapaDura;
    }

    public boolean isTapaDura() {
        return tapaDura;
    }
   
    @Override
    public double obtenerPrecioFinal(){
        if (this.isTapaDura()){
            return super.getPrecioBase()+500; 
        }
     
         return super.getPrecioBase(); 
        
    }
      @Override
    public String toString(){
        String aux= super.toString() + "\n "+ "PRECIO FINAL: "+ this.obtenerPrecioFinal(); 
        return aux; 
    }
}
