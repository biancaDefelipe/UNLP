package io.github.unlp_oo.parcicial3raFecha2022;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contenedor implements Componente{
	private List<Componente>componentes;
	private Object components; 
	
	public Contenedor() {
		super();
		this.componentes = new ArrayList<Componente>();
	}

	@Override
    public String imprimir() {
        String contenido = this.componentes.stream()
        						.map(c -> c.imprimir())
        						.collect(Collectors.joining("\n"));

        return "<contenedor>\n" + contenido + "\n</contenedor>";
    }

	@Override
	public void aplicarEstilo(ConfiguracionEstilo config) {
		this.componentes.forEach(c->c.aplicarEstilo(config));
		
	}
	public void add(Componente c) {
	    this.componentes.add(c);
	}
}
