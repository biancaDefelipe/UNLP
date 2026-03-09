program ejercicio3;
const 
	dimF= 8; 
type 
	rangoGenero= 1..dimF; 
	pelicula = record
		cod_peli:integer; 
		cod_gen:rangoGenero; 
		puntaje: real; 
	end; 
	
	lista= ^nodo; 
	nodo= record
		dato: pelicula; 
		sig: lista; 
	end; 
	punteros = record 
		pri: lista; 
		ult: lista; 
    end; 
	vecPunteros = array [rangoGenero] of punteros; 
	
	vecPuntaje = array[rangoGenero] of pelicula; 
	
procedure leerPelicula ( var p: pelicula); 
begin 
	write('codigo de pelicula: '); 
	readln(p.cod_peli); 
	if (p.cod_peli <> -1) then begin 
		write('codigo genero: '); 
		readln(p.cod_gen);
		write('puntaje promedio: '); 
		readln(p.puntaje);
	end; 
end; 

procedure agregarAtras (var pri, ult: lista; p:pelicula); 
var 
	nuevo: lista; 
begin
	new (nuevo); 
    nuevo^.dato:= p; 
    nuevo^.sig:= nil; 
    if (pri = nil) then begin {si la lista está vacia ambos punteros apuntal al mismo elemento que es el primero y el último a la vez}
        pri:= nuevo; 
        ult:= nuevo; 
    end
    else begin     { si tiene elementos cargados}
        ult^.sig:= nuevo; {el ultimo elemento cargado apunta al nuevo elemento }
        ult:= nuevo;       {la dirección del puntero final es el último elemento }
    end; 
end; 
		
					{INCISO A}
procedure procesarPeliculas (var vec: vecPunteros); 
var
	peli: pelicula; 
begin 
	leerPelicula(peli); 
	while (peli.cod_peli <> -1 ) do begin 
		agregarAtras(vec[peli.cod_gen].pri, vec[peli.cod_gen].ult, peli); 
		leerPelicula(peli); 
	
	end; 
end; 

					{INCISO B}
procedure inicializarVec (var vp: vecPuntaje); 
var
	i: integer; 
begin
	for i:= 1 to dimF do 
		vp[i].puntaje:= 0; 
end; 

procedure generarTopPeliculas(vec:vecPunteros; 	var vp: vecPuntaje); 
var
	act: lista; 
	i: integer; 
begin 
	for i:= 1 to dimF do begin
		act:= vec[i].pri; 
		while (act <> nil ) do begin
			if (act^.dato.puntaje> vp[i].puntaje ) then
				vp[i]:= act^.dato; 
			act:= act^.sig; 
		end;
	end;
end; 

procedure imprimirTopPeliculas (vp: vecPuntaje); 
var 
  i: integer;
begin 
  for i:= 1 to dimF do begin 
    writeln ('genero de pelicula:', vp[i].cod_gen); 
    writeln ('codigo de pelicula:', vp[i].cod_peli);
    writeln ('puntaje de pelicula:', vp[i].puntaje:2:1); 
  end; 
end;



{inciso c}
procedure ordenarPorInsercion( var vp: vecPuntaje);
var  
	i, j: rangoGenero; 
	act: pelicula;
begin 
	for i:= 2 to dimF do begin
		act:= vp[i]; 
		while  (j> 0) and (vp[j].puntaje > act.puntaje) do begin 
			vp[j+1]:= vp[j]; 
			j:= j-1; 
		end; 
		vp[j+1]:= act;
	end; 
end; 


{inciso d}
procedure imprimirMaxMin(vp: vecpuntaje); 

begin 
	write('------------------------- CODIGO DE PELICULA CON MAYOR PUNTAJE: '); 
	writeln(vp[dimF].puntaje:2:1, '------------------------- '); 
	write('------------------------- CODIGO DE PELICULA CON MENOR PUNTAJE: '); 
	writeln(vp[1].puntaje:2:1, '------------------------- '); 
	

end; 
{programa principal}
var
	vec:vecPunteros; 
	vp:vecPuntaje; 
begin 
	
	procesarPeliculas(vec); 
	
	generarTopPeliculas(vec, vp); 
	
	imprimirTopPeliculas(vp); 
	
	imprimirMaxMin(vp); 
end.
