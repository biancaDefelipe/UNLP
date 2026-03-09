package io.github.unlp_oo.ejercicio_14_patrones;

import java.util.ArrayList;
import java.util.List;

public class Combinada extends Prenda{
	private List<Prenda>prendas; 
	
	
	public Combinada() {
		super();
		this.prendas = new ArrayList<Prenda>();
	}

	@Override
	public double getLiquidez() {
		// TODO Auto-generated method stub
		return 0.5;
	}

	@Override
	public double valor() {

		return this.prendas.stream().mapToDouble(p->p.valor()).sum(); 
	}

	@Override
	public void addChild(Prenda prenda) {
		this.prendas.add(prenda); 
	}

	@Override
	public void removeChild(Prenda prenda) {
		this.prendas.remove(prenda); 
		
	}

}
