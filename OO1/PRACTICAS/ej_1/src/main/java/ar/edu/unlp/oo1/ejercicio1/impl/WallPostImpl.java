package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	
	/**
	 * Complete con su implementación
	 */
	private String text; 
	private int likes; 
	private boolean featured; 
	
	//constructor
	public WallPostImpl() {
		this.text="Undefined post"; 
		this.likes= 0; 
		this.featured =false; 
	}

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }
    
    @Override
    public String getText() {
    	//retorna texto descriptivo de la publicacion
    	return this.text; 
    }
    @Override
    public void setText (String descriptionText) {
    	//asigna el texto descriptivo a la publicacion
    	this.text= descriptionText; 
    	
    }
    @Override
    public int getLikes() {
    	//retorno cantidad de likes
    	return this.likes; 
    }
    @Override
    public void like() {
    	//incremento cantidad de likes en uno
    	this.likes ++; 
    }
    @Override
    public void dislike() {
    	//decremento cant de likes en uno. Si es 0 no hago nada
    	if (this.likes > 0){
    		this.likes --; 
    	}
    }
    @Override
    public boolean isFeatured() {
    	//retorna true si el post esta marcado como destacado sino retorna false
    	return (this.featured) ? true : false;
	}
    @Override
    public void toggleFeatured() {
    	//invierte estado del post
    	if (this.featured) {
    		this.featured = false; 
    	}
    	else {
    		this.featured = true; 
    	}
    }
}
