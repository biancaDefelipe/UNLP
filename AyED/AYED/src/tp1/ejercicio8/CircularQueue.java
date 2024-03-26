package tp1.ejercicio8;

public class CircularQueue<T> extends Queue <T>{
	public T shift() throws Exception{
		/*Permite rotar los elementos, haciéndolo circular. Retorna el elemento
		encolado*/
		try {
			T elem = this.head();
			this.enqueue(this.dequeue());
			return elem; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("La cola esta vacia");
		} 
	}
}
