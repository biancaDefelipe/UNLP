program parcialIndumentaria; 
const 
	valor_alto= 9999; 
 
 
type
	prenda = record
		cod_prenda: integer; 
		descripcion: string; 
		colores: string; 
		tipo_prenda: string; 
		stock: integer; 
		precio_unitario: real; 
	end; 
	
	maestro= file of prenda; 
	detalle= file of integer; 

procedure leerMaestro(var mae: maestro: var p: prenda); 
begin 
	if ( not (eof(mae)) then 
		read(mae, p); 
	else
		p.cod_prenda:= valor_alto; 
end; 

procedure leerDetalle(var det: detalle: var cod: integer); 
begin 
	if ( not (eof(det)) then 
		read(det, cod); 
	else
		cod:= valor_alto; 
end; 

procedure merge( var mae: maestro; var det: detalle); 
var
	p, aux: prenda; 
	cod, act: integer; 
begin 
	reset(det); 
	
	leerDetalle(det, cod); 
	leerMaestro(mae, p);
	while (cod <> valor_alto ) do begin 
		act:=cod; 
		reset(mae); 
		leerMaestro(mae, p); 
		while (p.cod_prenda <> valor_alto) and (p.cod_prenda <> act) do 
			leerMaestro(mae, p); 
		end; 
		//tomo como precondicion que todos los codigos del detalle estan en el maestro
		p.stock:= p.stock*-1; 
		seek(mae, filepos(mae)-1); 
		write(mae, p); 
		close(mae)
		leerDetalle(det); 
	end; 
	close(mae); 
	close (det); 
	
end; 
		
