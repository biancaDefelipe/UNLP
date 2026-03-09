{5.- Implementar un módulo que realice una búsqueda dicotómica en un vector, utilizando el siguiente encabezado:}

program ejercicio5; 


const
	dimF= 20; 
	
type
	indice = 1..dimF; 
	
	vector= array [indice] of integer; 

procedure cargarVector (var vec: vector; var dimL: integer; dimF: indice ); 
var 
	 num: integer; 
begin 
	if (dimL<dimF) then begin 
	
		num:= random (30); 
		dimL:= dimL+1; 
		vec[dimL]:= num;
		cargarVector(vec, dimL,dimF); 
	end;
end; 

procedure ordenarVectorPorIncersion(var vec: vector; dim: indice); 
var 
	i, j, act: integer; 
begin
	for i:= 2 to dim do begin 
		act:= vec[i]; 
		j:= i-1; 
		while (j>0) and (vec[j] > act) do begin 
			vec[j+1] := vec[j]; 
			j:= j-1; 
		end; 
		
		vec[j+1]:= act; 
	end; 
end; 

procedure imprimirVectorRecursivo(vec: vector; dimF: indice; dimL: integer); 
begin 
	if (dimL >0) then begin
		
		imprimirVectorRecursivo(vec, dimF,( dimL -1)); 
		
		write(' | ', vec[dimL]); 
	end; 
end; 




procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: integer);
var
	medio: indice; 
begin
	medio:= (ini +fin) div 2; 
	if (ini > fin) then 
		pos := -1
	else begin
		if (dato = v[medio]) then 
			pos := medio
		else 
			if (v[medio] <> dato) then begin
				if (dato > v[medio])then 
					busquedaDicotomica(v, medio +1, fin, dato, pos)
				else
					busquedaDicotomica(v,ini, medio-1, dato, pos)
			end; 
	end; 
end; 	
		
var
	vec: vector; 
	dimL: integer;
	pos, dato: integer; 
begin
	writeln('-----------------------------------------------------'); 
	writeln(' CARGA DEL VECTOR'); 
	dimL:= 0;
	cargarVector(vec, dimL, dimF); 
	writeln('-----------------------------------------------------'); 
	
	writeln('-----------------------------------------------------'); 
	writeln(' VECTOR CARGADO');
	imprimirVectorRecursivo(vec, dimF, dimL); 
	writeln('-----------------------------------------------------'); 
	
	writeln('-----------------------------------------------------'); 
	writeln(' ORDENAMIENTO DEL VECTOR');
	ordenarVectorPorIncersion(vec, dimF); 
	writeln('-----------------------------------------------------'); 
	
	writeln('-----------------------------------------------------'); 
	writeln(' VECTOR ORDENADO'); 
	imprimirVectorRecursivo(vec, dimF, dimL); 
	writeln('-----------------------------------------------------'); 
	
	writeln('-----------------------------------------------------'); 
	write(' ingrese el dato a buscar un valor entre 0 y 29): '); 
	readln(dato); 
	pos:= -1; 
	busquedaDicotomica(vec, 1, dimF, dato, pos); 
	writeln(' ...buscando el dato en el vector');
	writeln('-----------------------------------------------------'); 
	
	if (pos <>-1) then 
		write('el valor ', dato, ' se encuentra en el vector')
	else
		write ('el valor ', dato, ' no se encuentra en el vector');
	writeln(); 
	writeln('-----------------------------------------------------'); 
	write('bye'); 
end.
