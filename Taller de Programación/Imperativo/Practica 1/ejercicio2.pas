program ejercicio2; 
const 
	dimF= 300; 
type
	rangoVec= 0..dimF; 
	
	oficina = record
		cod_id: integer; 
		dni_prop: integer; 
		valor_exp: real; 
	end; 
	
	vector= array [rangoVec] of oficina; 
	
procedure leerOficina ( var o: oficina); 
begin 
	write('codigo de indentificacion: '); 
	readln(o.cod_id); 
	if (o.cod_id <> -1) then begin 
		write('dni del propietario: '); 
		readln(o.dni_prop); 
		write('valor de expensas: '); 
		readln(o.valor_exp); 
	end; 
end; 

procedure procesarOficinas (var vec: vector; var dimL: rangoVec); 
var 
	o:oficina; 
begin 
	leerOficina(o); 
	while (o.cod_id <> -1) do begin 
		dimL := dimL +1; 
		vec[dimL]:=o; 
		leerOficina(o);
	end; 
end; 

procedure imprimirVector(vec:vector; dimL: rangoVec); 
var
	i: integer; 
begin
	for i:= 1 to dimL  do begin 
		writeln('_________________________________________________________________');
		writeln('codigo:         |           dni prop.          |           valor exp'); 
		writeln( vec[i].cod_id, '         |           ',vec[i].dni_prop,'.          |           ', vec[i].valor_exp:1:2); 
		writeln('_________________________________________________________________'); 
	end; 
end; 

procedure ordenarPorInsercion(var vecInsercion:vector;  dimL: rangoVec); 
var 
	actual: oficina; 
	i, j: integer; 
begin 
	for i:= 2 to dimL do begin 
		actual:= vecInsercion[i];
		j:=i-1; 
		while ( j> 0) and (vecInsercion[j].cod_id > actual.cod_id) do begin
			vecInsercion[j+1]:= vecInsercion[j];
			j:= j-1; 
		end; 
		vecInsercion[j+1]:=actual; 
	end; 
end; 

procedure ordenarPorSeleccion (var vecSeleccion: vector; dimL: integer); 
var 
	i,j,p:integer; 
    min_actual: oficina;                      {item=elemento mas chico dentro de cada vuelta}
begin
	for i:=1 to (dimL -1) do begin 
		p:=i;                 {p= vuelta en la que estoy/pos del valor minimo de la vuelta}
		for j:= i +1 to dimL do 
			if (vecSeleccion[j].cod_id < vecSeleccion[p].cod_id) then {j= recorre todos los elementos a partir de p}
				p:=j; 
		min_actual:= vecSeleccion[p];
		vecSeleccion[p] := vecSeleccion[i]; 
		vecSeleccion[i]:= min_actual;
	end; 
end; 
{programa principal}

var 
	vec, vecInsercion, vecSeleccion: vector; 
	dimL: rangoVec; 
begin
	dimL:=0; 
	procesarOficinas(vec, dimL); 
	imprimirVector(vec, dimL); 
	writeln(); 
	vecInsercion:= vec; 
	ordenarPorInsercion(vecInsercion, dimL); 
	writeln('VECTOR ORDENADO POR INSERCION'); 
	imprimirVector(vecInsercion, dimL); 
	vecSeleccion:= vec ;
	ordenarPorSeleccion(vecSeleccion, dimL);
	writeln('VECTOR ORDENADO POR SELECCION'); 
	imprimirVector(vecSeleccion, dimL); 
end.
	

