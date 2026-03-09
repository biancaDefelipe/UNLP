package ar.edu.unlp.objetos.uno.ejercicio11_elInversor;
import java.util.List;
import java.util.LinkedList;
public class Inversor {
	private String nombre; 
	private List<Inversion>inversiones;
	
	public Inversor(String nombre) {
		super();
		this.nombre = nombre;
		this.inversiones= new LinkedList<Inversion>(); 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Inversion> getInversiones() {
		return inversiones;
	}

	public void añadirInversion(Inversion inversion) {
		this.inversiones.add(inversion);
	} 

	public double valorActualInversiones(){
		/*El valor actual de las inversiones de un inversor es la suma de los valores actuales de 
		cada una de las inversiones en su cartera (su colección de inversiones).  */

		return this.getInversiones().stream().mapToDouble(i->i.valorActual()).sum();	
	}


	
	
}
