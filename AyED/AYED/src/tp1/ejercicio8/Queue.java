package tp1.ejercicio8;
import java.util.List;
import java.util.ArrayList;
public class Queue <T> extends Sequence <T>{
	protected List<T>data; 
		
	public Queue () {
		this.data= new ArrayList <T>(); 
	}
	public void enqueue (T dato) {
		//Inserta el elemento al final de la cola
		data.add(dato);
	}
	public T dequeue() throws Exception{
		/*Elimina el elemento del frente de la cola y lo retorna. Si la cola
		está vacía se produce un error.*/
		if (this.size()==0) {
			throw new Exception("La cola esta vacia");
		}
		return this.data.remove(0);
	}
	public T head() throws Exception{
		/*Retorna el elemento del frente de la cola. Si la cola está vacía se
		produce un error.*/
		if(this.size()==0) {
			throw new Exception("La cola esta vacia"); 
		}
		return this.data.get(0);
	}
	public int size() {
		return data.size();
	}
	public boolean isEmpty() {
		/*Retorna verdadero si la cola no tiene elementos y falso en
		caso contrario*/
		return this.data.size()==0 ? true: false;
	}
	public String toString() {
		String aux="";
		for (int i =0; i< this.size(); i++) {
			aux= aux + this.data.get(i).toString();
		}
		return aux; 
	}
} 
