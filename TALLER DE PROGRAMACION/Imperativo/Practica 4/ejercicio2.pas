// 2. Un cine posee la lista de películas que proyectará durante el mes de octubre. De cada
// película se conoce: código de película, código de género (1: acción, 2: aventura, 3: drama, 4:
// suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror) y puntaje promedio otorgado por
// las críticas. Implementar un programa que contenga:
// a. Un módulo que lea los datos de películas y los almacene ordenados por código de película y
// agrupados por código de género, en una estructura de datos adecuada. La lectura finaliza
// cuando se lee el código de película -1.
// b. Un módulo que reciba la estructura generada en el punto a y retorne una estructura de
// datos donde estén todas las películas almacenadas ordenadas por código de película.


program ejercicio2.pas; 
const 
	dimF= 8; 
	
type
	rangoGeneros= 1..dimF; 
	
	pelicula = record
		cod_peli: integer; 
		cod_genero: rangoGeneros; 
		puntaje: real; 
	end; 
	
	
	lista= ^nodo; 
	nodo= record
		dato: pelicula; 
		sig: lista; 
	end; 
	
	vector= array [rangoGeneros] of lista; 
	
procedure leerPelicula(var p: pelicula); 
begin
	write(' codigo de pelicula: '); 
	readln(p.cod_peli); 
	if (p.cod_peli <> -1) then begin
		write(' codigo de genero: '); 
		readln(p.cod_genero); 
		write(' puntaje promedio: '); 
		readln(p.puntaje);
	end; 
end;

procedure iniciarListas (var vec: vector);
var 
	i: integer; 
begin 
	for i:= 1 to dimF do 
		vec[i]:= nil; 
end; 

procedure insertarOrdenado(var l: lista; p: pelicula); 
var
	nue, act, ant: lista; 
begin 
	new(nue); 
	nue^.dato:= p; 
	nue^.sig:= nil; 
	
	if (l= nil) then 
		l:= nue
	else begin
		ant:= l; 
		act:=l; 
		while (act <> nil) and (act^.dato.cod_peli <p.cod_peli) do begin
			ant:= act; 
			act:= act^.sig; 
		end; 
		if (act= l) then 
			l:= nue
		else
			ant^.sig:= nue; 
		nue^.sig:= act; 
	end; 
end; 
procedure crearListasPeliculas(var vec: vector); 
var 
	p: pelicula; 
begin 
	leerPelicula(p); 
	while (p.cod_peli <> -1) do begin 
		insertarOrdenado(vec[p.cod_genero], p); 
		writeln('_________________________________'); 
		leerPelicula(p); 
	end; 
end; 

procedure imprimirLista(l:lista); 
begin
	if (l<> nil) then begin 
		writeln('								codigo de pelicula: ', l^.dato.cod_peli);
		writeln('								puntaje: ', l^.dato.puntaje:2:1);
		writeln('___________________________________________________________________'); 
		imprimirLista(l^.sig); 
	end; 
end; 
procedure imprimirVector(vec: vector); 
var 
	i: integer;
begin 
	for i:= 1 to dimF do begin 
		if( vec[i] <> nil) then begin
			writeln('				genero ', i); 
			imprimirLista(vec[i]); 
		end
		else 
			writeln(' el genero ',i,' no contiene peliculas '); 
	end; 
end; 

// b. Un módulo que reciba la estructura generada en el punto a y retorne una estructura de
// datos donde estén todas las películas almacenadas ordenadas por código de película.

procedure minimo (var vec: vector; var peliMin: pelicula); 
var
	i: integer;
begin
	peliMin.cod_peli:= 9999; 
	for i:=1 to dimF do begin
		if (vec[i] <> nil) and (vec[i]^.dato.cod_peli < peliMin.cod_peli) then begin
			peliMin:= vec[i]^.dato; 
		end; 
	end; 
	if (peliMin.cod_peli <> 9999) then 
		vec[i]:= vec[i]^.sig; 
end; 
			
procedure agregarAtras (var l, ult: lista; peli:pelicula); 
var 
	nue: lista; 
begin
	new (nue); 
	nue^.dato:= peli;
	nue^.sig:= nil; 
	
	if (l= nil) then 
		l:= nue 
	else 
		ult^.sig:= nue; 
	ult:= nue; 
end; 

procedure merge ( vec:vector; var li: lista); 
var 
	peli: pelicula; 
	ult: lista; 
begin 
	li:= nil; 
	minimo(vec, peli);
	while (peli.cod_peli <> 9999) do begin 
		agregarAtras(li, ult, peli); 
		minimo (vec, peli); 
	end; 
end; 



{programa principal} 


var 
	vec: vector; 
	todasLasPelis:lista; 
	
begin 
	writeln('---------------------------------------------');
	iniciarListas(vec); 
	
	writeln('---------------------------------------------');
	crearListasPeliculas(vec); 
	
	
	writeln('---------------------------------------------');
	imprimirVector(vec); 
	
	writeln('---------------------------------------------');
	merge(vec, todasLasPelis); 
	
	writeln('---------------------------------------------');
	writeln('lista con todas las pelis: '); 
	imprimirLista(todasLasPelis); 
end. 

