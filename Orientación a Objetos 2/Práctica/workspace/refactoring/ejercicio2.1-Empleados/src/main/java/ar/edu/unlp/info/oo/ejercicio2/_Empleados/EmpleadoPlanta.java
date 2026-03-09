package ar.edu.unlp.info.oo.ejercicio2._Empleados;

public class EmpleadoPlanta {
	    public String nombre;
	    public String apellido;
	    public double sueldoBasico = 0;
	    public int cantidadHijos = 0;
	    // ......
	    
	    public double sueldo() {
	    	return this.sueldoBasico 
	    			+ (this.cantidadHijos * 2000)
	    			- (this.sueldoBasico * 0.13);
		}
}
