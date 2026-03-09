program ejercicio4; 

const 
	dimF= 20; 
	numMin= 0; 
	numMax= 100; 
	
	
type 
	rangoNumeros= numMin.. numMax; 
	dimVec= 0..dimF; 
	
	vector= array [dimVec] of integer; 
	
function generarNumero():rangoNumeros; 
begin
	generarNumero := Random (numMax); 
end; 

procedure cargarVectorRecursivo (var vec: vector; var dimL: dimVec); 
var 
 
	num: rangoNumeros;
begin
	if (dimL < dimF) then begin 
		num:= generarNumero(); 
		dimL:= dimL +1; 
		vec[dimL] := num; 
		
		cargarVectorRecursivo(vec, dimL); 
	end; 
end; 


procedure imprimirVector (vec: vector; dimL: integer); 
var
	i: rangoNumeros; 
begin 
	for i:= 1 to dimL do 
		write('| ', vec[i],' ')
end; 


procedure buscarMaximoRecursivo(vec: vector; dimL:dimVec; var max:rangoNumeros); 
	
begin
	if (dimL >0) then begin
		if (vec[dimL] > max)then
			max:= vec[dimL]; 
		
		buscarMaximoRecursivo(vec, dimL-1, max);
	end; 
	
end;
procedure sumarValoresRecursivo (vec:vector; dimL: dimVec; var total: integer); 
begin
	if (dimL >0 ) then begin
		total:= total + vec[dimL]; 
		sumarValoresRecursivo(vec, dimL -1, total); 
	end;
end; 
//programa principal 
var
	dimL: dimVec; 
	vec:vector; 
	max:rangoNumeros; 
	total:integer; 
begin
	dimL:= 0; 
	
	writeln('-------------------------------------------------------------');
	cargarVectorRecursivo(vec, dimL); 
	writeln('-------------------------------------------------------------');
	imprimirVector(vec, dimL); 
	writeln(); 
	
	writeln('-------------------------------------------------------------');
	max:= 0; 
	buscarMaximoRecursivo(vec, dimL, max); 
	write('maximo numero del vector: ', max);  
	writeln(); 
	writeln('-------------------------------------------------------------');
	
	
	writeln('-------------------------------------------------------------');
	total:=0; 
	sumarValoresRecursivo(vec, dimL, total);
	write('la suma de los valores del vector es: ', total); 
	writeln(); 
	writeln('-------------------------------------------------------------');
end.
