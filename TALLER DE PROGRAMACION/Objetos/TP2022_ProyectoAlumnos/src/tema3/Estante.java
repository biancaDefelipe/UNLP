/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author bianc
 */
public class Estante {
    private Libro libros[] ; 
    private int dimF= 20; 
    private int dimL; 
    
    
    public Estante(){
       this.libros= new Libro[20]; 
       this.dimL=0; 
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public int getDimF() {
        return dimF;
    }

    public int getDimL() {
        return dimL;
    }
    
    public int getCantidadLibros(){
        return this.dimL; 
    }
    public boolean estaLleno(){
        return this.getCantidadLibros()== this.dimF; 
    }
    public boolean agregarLibro(Libro libro){
        if (!(this.estaLleno())){
            this.libros[dimL]= libro; 
            dimL= dimL +1; 
            return true; 
        }
        else{
            return false; 
        }
    }
    public Libro buscarLibro (String titulo){
        boolean encontre= false; 
        int i = 0; 
        while (!(encontre) && (i< dimL)){
            if (libros[i].getTitulo().equals(titulo)){
                encontre=true; 
            }
            else {
                i++; 
            }
        }
        if (encontre){
            return libros[i]; 
            
        }
        else{
            return null;
        }
    }
}
