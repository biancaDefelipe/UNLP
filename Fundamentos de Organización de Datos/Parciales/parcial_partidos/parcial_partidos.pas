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
pro
procedure informar(var arch: archivo_partidos); 
var
	p: partido; 
	
begin 
	reset(arch); 
	leer(arch, p); 
	while (p.anio <> valor_alto) do begin
		act:= p; 
		writeln('Anio ', p.anio);
		writeln('        cod_torneo ', p.cod_torneo); 
		writeln('                      cod_equipo ', p.cod_equipo,' nombre_equipo ', p.nombre_equipo); 
		writeln('                                 cantidad de goles a favor equipo ', p.cod_equipo,' ', p.goles_favor); 
		writeln('                                 diferencia de gol ', p.goles_favor - p.goles_contra, ' equipo ', p.cod_equipo ); 
		writeln('                                 cantidad de goles a favor equipo ', p.cod_equipo,' ', p.goles_favor); 


