program fulbo; 
const 
	valor_alto=9999; 
type 
	partido= record
		codigo_equipo: integer; 
		nombre_equipo: string; 
		anio: integer; 
		cod_torneo: integer; 
		codigo_rival: integer; 
		goles_favor: integer; 
		goles_contra: integer; 
		puntos: integer; 
	end; 
	archivo= file of partido; 
	
procedure maximo(var maxTorneo: integer; var ganador: string; puntos: integer;  nombre: string); 
begin
	if (maxTorneo< puntos) then begin
		maxTorneo:= puntos; 
		ganador:= nombre; 
	end; 
end; <s
procedure informar(var arch: archivo); 
var 
	ganador, nombreActual: string; 
	torneoAct, torneoAct, equipoAct, cantGolesFavor, cantGolesContra, perdidos, ganados, empatados, puntos, maxTorneo: integer; 
	p: partido; 
begin 
	leer(arch, p);
	maxTorneo:=0; 
	while (p. anio<> valor_alto) do begin 
		anioAct:= p.anio; 
		writeln('ANIO : ', anioAct); 
		
		while  (p.anio = anioAct) do begin 
			torneoAct:= p.cod_torneo; 
			 
			writeln('	torneo: ', toneoAct); 
			
			while (p.anio = anioAct) and (p.cod_torneo= torneoAct) do begin 
				equipoAct:= p.cod_equipo; nombreActual:= p.nombre_equipo; 
				writeln('		equipo: ', equipoAct,' nombre: ', p.nombre_equipo); 
				
				cantGolesFavor:=0; cantGolesContra:=0; 
				perdidos:=0; ganados:=0; empatados:=0; puntos:=0; 
				while  (p.anio = anioAct) and (p.cod_torneo= torneoAct) and (p.cod_equipo= equipoAct) do begin
					cantGolesFavor:= cantGolesFavor+p.goles_favor; 
					cantGolesContra:= cantGolesContra+ p.goles_contra; 
					if (p.puntos= 0) then 
						perdidos:= perdidos +1; 
					else if (p.puntos = 1) then 
							empatados:0 empatados +1; 	
					else ganados:= ganados +1; 
					
					puntos:= puntos+ p.puntos; 
					leer(arch, p); 
				end; 
				writeln(' 		cantidad total de goles a favor: ', cantGolesFavor); 
				writeln(' 		cantidad total de goles en contra: ', cantGOlesContra); 
						
				writeln(' 		diferencia de gol(resta de goles a favor- goles en contra): ', cantGolesFavor-cantGolesContra);
				writeln('       partidos ganados : ', ganados); 
				writeln('       partidos perdidos: ', perdidos); 
				writeln('       partidos empatados: ', empatados); 
				writeln('       puntos: ', puntos ); 
				writeln('-------------------------------------'); 
				maximo(maxTorneo, ganador, puntos, nombreActual);  
				
			end; 		
			writeln('	el equipo ', ganador,' fue campeon del torneo ', torneoAct,' del anio ', anioAct); 
						
		end; 
	end; 
	close(arch); 									
end; 
						
						
						
		
