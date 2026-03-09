program ejercicio13; 
const 
	valor_alto= 'zzzz'; 

	
type 
	
	compra= record
		destino: string; 
		fecha: integer; 
		hora: integer; 
		cant_asientos: integer; 
	end; 
	vuelo= record
		destino: string; 
		fecha: integer; 
		hora: integer; 
		asientos_disp: integer; 
	end; 
	detalle = file of compra; 
	maestro= file of vuelo; 
	
procedure leerDetalle(var det: detalle; var c: compra); 
begin 
	if (not eof (det)) then
		readln(det, c); 
	else
		c.destino:= valor_alto; 
end; 

procedure leerMaestro( var mae: maestro; var v: vuelo); 
begin 
	(if not eof(mae)) then 
		read(mae, v);
	else
		v.destino:= valor_alto; 
end; 

procedure escribirEnTxt(var lista: Text; var v: vuelo); 
begin 
	with v do begin 
		
		writeln(lista, ' destino: ' ,destino); 
		writeln(lista, ' SALIDA fecha: ', fecha, '|  hora: ', hora); 
		writeln(lista, '-------------------------------------------------');
	end; 
end; 

procedure minimo(var det1: detalle; var det2: detalle; var c1: compra; var c2: compra; var min: compra);

begin
	min.destino:=valor_alto;  
	if (c1.destino< c2.destino) or ((( c1.destino = c2.destino ) and (c1.fecha < c2.fecha) ) or 
									((c1.destino = c2.destino) and (c1.fecha= c2.fecha) and (c1.hora< c2.hora))then begin 
							
		min:= c1; 
		leerDetalle(det1, c1); 
								
	end; 
	else begin 
			min:= c2; 
			leerDetalle(det2, c2); 
	end; 
	
end; 
			
										
										
										
procedure merge ( var mae: maestro; var det1: detalle; var det2: detalle); 
var
	c1, c2, min: compra; 
	v: vuelo; 
	tot, minAsientos: integer; 
	lista: Text; 
begin 
	assign(det1, 'detalle1.dat'); reset(det1); leerDetalle(det1, c1); 
	assign(det2, 'detalle2.dat'); reset(det2); leerDetalle(det2, c1); 
	minimo(det1, det2, c1, c2, min); 
	if (min <> valor_alto) then begin 
		tot:=0; 
		assign(mae, 'maestro.dat'); reset(mae); 
		assign(lista, 'vuelos.txt'); rewrite(lista); 
		write('ingrese la cantidad minima de asientos disponibles: '); 
		while (min.destino <> valor_alto) do begin 
			act.destino:= min.destino; 
			
			while (min.destino= act.destino) do begin 
				act.fecha:= min.fecha; 
				
					while ((min.destino= act.destino) and ( min.fecha= act.fecha) )do begin 
						act.hora:= min.fecha.hora; 
						
						while ((min.destino= act.destino) and ( min.fecha= act.fecha) and (min.hora= act.hora) )do begin 
							tot:= tot + min.cant_asientos; 
							minimo(det1, det2, c1, c2, min); 
						end; 
						leerMaestro(mae, v); 
						while ((v.destino <> act.destino) and (v.fecha<> act.fecha) and (v.hora <>v.hora)) do 
							leerMaestro(mae, v); 
						v.asientos_disp:=v.asientos_disp- tot; 
						if (v.asientos_disp < minAsintos)then 
							escribirEnTxt(lista, v); 
						seek(mae, filepos(mae)-1); 
						write(mae, v); 
						tot:=0; 
					end; 
				end; 
			end; 
		end; 
		  close(mae); close(lista); 
		
	end; 
	close(det1); close(det2);
end; 


