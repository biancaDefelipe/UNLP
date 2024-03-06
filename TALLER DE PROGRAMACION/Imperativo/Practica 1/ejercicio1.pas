program ejercicio1; 
{Implementar un programa que procese la información de las ventas de productos de un comercio (como máximo 20). 
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 99 unidades). 
El ingreso de las ventas finaliza con el código 0 (no se procesa).

a. Almacenar la información de las ventas en un vector. El código debe generarse automáticamente (random) y la edad se debe leer. 
b. Mostrar el contenido del vector resultante.
c. Ordenar el vector de ventas por código.
d. Mostrar el contenido del vector resultante.
e. Eliminar del vector ordenado las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Mostrar el contenido del vector resultante.
g. Generar una lista ordenada por código de producto de menor a mayor a partir del vector resultante del inciso e., sólo para los códigos pares.
h. Mostrar la lista resultante.}



Const
	maxVenta= 99; 
	dimF= 20; 
Type
	rangoCod= 0..15; 
	rangoVec= 0..dimF; 
	venta= record
		cod: rangoCod; 
		cantVendida: 0..maxVenta; 
	end; 
	
	vector= array [rangoVec] of venta; 
	lista=^nodo; 
	nodo= record
		dato:venta; 
		sig:lista; 
	end; 
	
procedure leerVenta ( var v: venta); 
begin
	Randomize; 
	write('Codigo del producto: --------------------------------------');
	v.cod:= random(16); 
	writeln(v.cod); 
	
	if (v.cod <> 0) then begin 
		write('cantidad vendida  (entre 1 y 99): '); 
		readln(v.cantVendida); 
	end; 
end; 

procedure procesarVentas (var  vec: vector; var dimL:rangoVec);
var
	v:venta; 
begin
	dimL:=0; 
	leerVenta(v); 
	while ((v.cod<>0) and (dimL< dimF)) do begin
		dimL := dimL +1; 
		vec[dimL] := v;
		writeln('dimL actualizada: ', dimL);
		leerVenta(v); 
	end; 
	
end; 



procedure imprimirVector (vec:vector; dimL:rangoVec); 
var 
	i: integer;
begin
	for i:= 1 to (dimL) do begin   
		write ('|',vec[i].cod,'|');
	end;
end; 	



 
procedure ordenarPorInsercion (var vec:vector; dimL: rangoVec); 
var
	i, j: rangoVec; 
	actual:venta; 
begin
	for i:= 2 to (dimL ) do begin 
		actual:= vec[i]; 
		j:= i-1;                        {j es el anterior}
		while (j>0) and (vec[j].cod >= actual.cod) do begin 
			vec[j+1]:= vec[j]; 
			j:= j-1; 
			{imprimirVector(vec, dimL);} 
			writeln(); 
			 
		end; 
		vec[j+1]:= actual; 
	end; 
end; 

//inciso e

{para aprovechar el orden, busca la posicion desde donde borrar}
function BuscarPosicionInicial (vec: vector; dimL: integer; valorInf: rangoCod): rangoVec;
  var pos: rangoCod;
  begin
    pos:= 1;
    while (pos <= dimL) and (valorInf > vec[pos].cod) do
       pos:= pos + 1;
    if (pos > dimL) then 
		BuscarPosicionInicial:= 0
    else  begin
		writeln('posInicial:',  pos);
		BuscarPosicionInicial:= pos
	end; 
  end;
  
function BuscarPosicionFinal(vec: vector; dimL, posInicial: integer; valorSuperior: rangoCod): rangoVec; 
  begin
    while (posInicial <= dimL) and (valorSuperior >= vec[posInicial].cod) do
       posInicial:= posInicial + 1;
    if (posInicial > dimL) then 
		buscarPosicionFinal:= dimL
    else begin
		writeln('posFinal:',  posInicial -1);
		BuscarPosicionFinal:= posInicial - 1
	end; 
  end;
  
procedure eliminarDelVector (var vec: vector;  var dimL: rangoVec; inicio, fin: integer); 
var
	posInicial, posFinal, cantElem, i, j: integer; 
begin 
	posInicial:= buscarPosicionInicial(vec, dimL, inicio); 
	if (posInicial <> 0) then begin   {si hay al menos 1 elemento dentro del rango}
		posFinal:= buscarPosicionFinal(vec, dimL, posInicial, fin); 
		cantElem:= (posFinal - posInicial)+1; 
		 
		writeln('POS INICIAL', posInicial, ' POS FINAL ', posFinal);
		writeln('cantElemen', cantElem); 
		
		{for i:= 1 to cantElem do begin
			for j:= posInicial to dimL -1 do 
			  vec[posInicial]:= vec[(posInicial +1) ] ;}
		for i:= posInicial to dimL-1 do 
			vec[posInicial] := vec [posInicial +1]; 
		
			{imprimirVector(vec, dimL);} 
			{writeln('dimL ahora ', dimL); }
			writeln('-------'); 
			
		end; 
		dimL := dimL-cantElem;
		
		
		
		{for i:= 0 to cantElem do begin
			for j := posInicial to posFinal -i do 
				vec[j]:= vec[j +1]; 
			dimL := dimL -1; 
		end; }
	end; 


	
function esPar(num: integer): boolean;
begin 
	if ((num mod 2) = 0) then 
		esPar:= true
	else
		esPar := false; 
end; 

procedure agregarAtras (var pI, pu: lista; v: venta); 
var 
	nuevo: lista; 
begin
	new (nuevo); 
    nuevo^.dato:= v; 
    nuevo^.sig:= nil; 
    if (pI = nil) then begin {si la lista está vacia ambos punteros apuntal al mismo elemento que es el primero y el último a la vez}
        pI:= nuevo; 
        pU:= nuevo; 
    end
    else begin     { si tiene elementos cargados}
        pU^.sig:= nuevo; {el ultimo elemento cargado apunta al nuevo elemento }
        pU:= nuevo;       {la dirección del puntero final es el último elemento }
    end; 
end; 

procedure generarLista(var li: lista; vec: vector; dimL: rangoVec);
var 
	pU:lista; 
	i: integer; 
begin
	for i:= 1 to dimL do begin
		if (esPar(vec[i].cod)) then 
			agregarAtras(li, pU, vec[i]); 
	end; 
end; 
 




procedure imprimirLista(l : lista); 
var 
    aux: lista; 
begin 
    aux := l; 
    while (aux <> nil) do begin 
            writeln ('codigo: ', aux^.dato.cod, ' | cant. vendida: ', aux^.dato.cantVendida); 
            aux := aux ^.sig; 
    end; 
end; 
{programa principal}


Var
	vec: vector; 
	dimL:rangoVec; 
	inicio, fin: integer; 
	listaPares: lista; 
begin 
	listaPares:= nil; 
	procesarVentas(vec, dimL); 
	imprimirVector(vec, dimL);
	
	writeln();
	ordenarPorInsercion(vec, dimL);
	imprimirVector(vec, dimL);
	
	writeln(); 
	
	write(' ingrese valor del borde inferior: '); 
	readln(inicio); 
	write('ingrese valor del borde superior: '); 
	readln(fin); 
	
	eliminarDelVector(vec, dimL, inicio, fin);
	writeln();
	imprimirVector(vec, dimL);
	 
	 
	writeln(); 
	generarLista(listaPares,vec,dimL);
	imprimirLista(listaPares); 
	
end.
	


















	
