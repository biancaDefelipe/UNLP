program parcialEquipos;

const
	valor_alto=32000;
	
type 
	partido= record
		codigo_equipo: integer;
		nombre_equipo: string; 
		anio:integer; 
		codigo_torneo: integer; 
		codigo_equipo_rival: integer; 
		goles_favor: integer; 
		goles_contra: integer; 
		puntos obtenidos: integer; 
	end; 
	
	archivo_partidos= file of partido; 
	
procedure leer(var arch: archivo_partidos; var p: partido); 
begin 
	if(not eof(arch)) then 
		read(arch, p); 
	else
		p.anio:= valor_alto; 
end;
procedure resultados(var totalGanados, totalPerdidos, totalEmpatados, totalPuntos: integer;  p: partido); 
begin
	if (p.goles_favor> p.goles_contra) then begin
		totalGanados:= totalGanados +1; 
		totalPuntos:= totalPuntos +3; 
	end; 
	else 
		if (p.goles_favor= p.goles_contra) then begin
			totalEmpatados:= totalEmpatados +1; 
			totalPuntos:= totalPuntos+1; 
		end; 
		else 
			if (p.goles_favor< p.goles_contra) then 
				totalPerdidos := totalPerdidos+1; 
end; 	
procedure informar(var arch: archivo_partidos); 
var
	p, actEquipo: partido;
	actAnio: integer; 
	actTorneo: integer; 
	totalGanados, totalPerdidos, totalEmpatados, max, diferencia, totalPuntos: integer; 
	maxEquipo: string; 
	
begin 
	reset(arch); 
	max:=0; 
	leer(arch, p); 
	while (p.anio <> valor_alto) do begin
		actAnio:= p.anio; 
		writeln('Anio ', p.anio);
		max:=0; 
		
		while (p.anio <> valor_alto) and (p.anio= anio) do begin
			actTorneo:= p.codigo_torneo; 
			writeln('        cod_torneo ', p.cod_torneo); 
			while((p.anio <> valor_alto) and (p.anio= anio) and (p.torneo = actTorneo))do begin	
				actEquipo:= p.codigoEquipo; 
				writeln('                      cod_equipo ', p.cod_equipo,' nombre_equipo ', p.nombre_equipo); 
				totalGandos:=0; totalPedidos:=0; totalEmpatados:=0; totalPuntos:= 0; 
				while((p.anio <> valor_alto) and (p.anio= anio) and (p.torneo = actTorneo)and (p.codigo_equipo= actEquipo)do begin
							resultados(totalGanados, totalPerdidos, totalEmpatados, totalPuntos, p); 
							leer(arch, p); 
				end; 
				writeln('                                 cantidad de goles a favor equipo ', actEquipo.cod_equipo,' ', aactEquipo.goles_favor); 
				writeln('                                 diferencia de gol ', actEquipo.goles_favor - actEquipo.goles_contra, ' equipo ', actEquipo.cod_equipo ); 
				writeln('                                 cantidad de goles a favor equipo ',actEquipo.cod_equipo,' ', actEquipo.goles_favor); 
				writeln('                                 cantidad de partidos ganados: ',totalGanados);
				writeln('                                 cantidad de partidos perdidos: ',totalPerdidos); 
				writeln('                                 cantidad de partidos empatados: ',totalEmpatados);
				writeln('                                 cantidad total de puntos en el torneo 'actTorneo,' :',totalPuntos);
				writeln('-------------------------------------------------------------------------------------------------------');
				if (max< totalPuntos) then begin
					max:=totalPuntos; 
					maxEquipo:= actEquipo.nombre; 
				end; 
			end; 
			writeln('        el equipo maxEquipo ', maxEquipo,' es el ganador del torneo ', actTorneo,' del anio 'actAnio); 
			writeln('----------------------------------------------------------------------------------------------------');
			
		end; 
		writeln('Anio ', p.anio);
