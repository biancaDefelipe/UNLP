package general;



import java.util.*;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}
	private int contarHojasRecursivo() {
		
	int hojasIzq=0; int hojasDer=0; 
		if (this.isLeaf()) {return 1;}
		else {
			if (this.hasLeftChild()) {
				hojasIzq= this.getLeftChild().contarHojasRecursivo(); 
			}
			if (this.hasRightChild()) {
				hojasDer= this.getRightChild().contarHojasRecursivo(); 
			}
		}
	return hojasIzq+ hojasDer; 
	}

	public  int contarHojas() {
	   if (this.isEmpty()) {return 0; }
	   else {return this.contarHojasRecursivo();}
	}
		
	private BinaryTree<T> espejar() {
	    BinaryTree<T> espejo = new BinaryTree<T>(this.getData());
        if(this.hasLeftChild()) {
            espejo.addRightChild(this.getLeftChild().espejo());
        }
        if(this.hasRightChild()) {
            espejo.addLeftChild(this.getRightChild().espejo());
        }
        return espejo;
	}
	
		
    	 //Devuelve el árbol binario espejo del árbol receptor.
    public BinaryTree<T> espejo(){
    	
    	if (this.isEmpty()){return null;}
    	else {return (this.espejar()); }
    }

	// 0<=n<=m
    private void imprimirEntreNiveles(int n, int m) throws Exception {
    	Queue <BinaryTree<T>> cola =  new Queue<BinaryTree<T>>(); 
    	cola.enqueue(this);
    	int nivel =0; 
    	while (!(cola.isEmpty())) {
    		int nivelActual= cola.size(); 
    		if((nivel>=n) && (nivel <= m)) {			
    				//si estoy en rango, por cada nivel imprimo sus elmentos 
    			   for(int i=0; i < nivelActual; i++) {
                       BinaryTree<T> ab = cola.dequeue(); 
                       System.out.print(ab.toString()+" | "); 
                       if(ab.hasLeftChild()) cola.enqueue(ab.getLeftChild());
                       if(ab.hasRightChild()) cola.enqueue(ab.getRightChild());
                   }
    			   //ya no tengo que encolar mas elementos, asi que solo imprimo hasta que se vacie la cola 
    			   for (int i=0; i< cola.size(); i++) {
    				   BinaryTree<T> ab = cola.dequeue();
    				   System.out.print(ab.toString()+" | ");
    			   }
    		}
    		else { //si no estoy en rango 
    			if (nivel< n) {
    				System.out.println("no estoy en rango"); 
    				if (n%2 ==0) {
    					for (int i =0 ; i<=n; i++) {
    						BinaryTree<T> ab = cola.dequeue(); 
    						if (ab.hasLeftChild()) {cola.enqueue(ab.getLeftChild()); }
    						if (ab.hasRightChild()) {cola.enqueue(ab.getRightChild()); } 
    						nivel++;
    					
    					}
    				}else {
    					for (int i =0 ; i<n; i++) {
    						BinaryTree<T> ab = cola.dequeue(); 
    						if (ab.hasLeftChild()) {cola.enqueue(ab.getLeftChild()); }
    						if (ab.hasRightChild()) {cola.enqueue(ab.getRightChild()); } 
    						nivel++;
    				}
    			}
    			}
    		}
    		nivelActual++; 
    			}
    		
    		
    		}
    		
    
	public void entreNiveles (int n, int m) throws Exception{
		
		if (this.isEmpty() || n < 0 || m < n) {System.out.println("arbol vacio");}
		else {this.imprimirEntreNiveles(n,m); }
	} 
	
        
		
		
		/*encolar(raíz);
		mientras (cola no se vacíe) {
		desencolar(v);
		imprimir (dato de v);
		si (tiene hijo_izquierdo)
		encolar(hijo_izquierdo);
		si (tiene hijo_derecho)
		encolar(hijo_derecho);
		}*/
		

    public void imprimirInOrden() {
        if(this.hasLeftChild()) this.getLeftChild().imprimirInOrden();
        System.out.print(this.getData() + " ");
        if(this.hasRightChild()) this.getRightChild().imprimirInOrden();
    }
    public void imprimirPostOrden() {
        if(this.hasLeftChild()) this.getLeftChild().imprimirPostOrden();
        if(this.hasRightChild()) this.getRightChild().imprimirPostOrden();
        System.out.print(this.getData() + " ");
    }
 
		
}

