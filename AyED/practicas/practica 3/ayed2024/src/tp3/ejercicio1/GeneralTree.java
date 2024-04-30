package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTreeInterna<T>> children = new LinkedList<GeneralTreeInterna<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTreeInterna<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTreeInterna<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTreeInterna<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTreeInterna<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTreeInterna<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
			
		return 0;
	}
	
	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		
		return 0;
	}
}