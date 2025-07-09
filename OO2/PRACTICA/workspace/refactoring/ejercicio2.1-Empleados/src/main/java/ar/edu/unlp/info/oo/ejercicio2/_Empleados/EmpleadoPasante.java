package ar.edu.unlp.info.oo.ejercicio2._Empleados;

public class EmpleadoPasante {
	  public String nombre;
	  public String apellido;
	  public double sueldoBasico = 0;
	    // ......
	    
	  public double sueldo() {
		  return this.sueldoBasico - (this.sueldoBasico * 0.13);
	   }

}


