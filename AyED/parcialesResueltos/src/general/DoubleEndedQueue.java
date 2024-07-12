package general;

public class DoubleEndedQueue <T> extends Queue <T>{
	public void  enqueueFirst(T data) {
		/*
			● enqueueFirst():void Permite encolar al inicio.
		 */
		super.data.add(0, data);
	}
}
