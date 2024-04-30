program ejercicio3; 
const 
	valor_alto= 9999; 
type 
	producto= record
		codigo: integer; 
		nombre: string; 
		precio: real; 
		stock_actual: integer; 
		stock_minimo: integer; 
	end; 
	venta= record
		codigo: integer; 
		cant_vendida: integer; 
	end; 
	maestro= file of producto; 
	detalle = file of venta; 

procedure leerProducto(var p: producto); 
begin 
	write(' codigo: '); 
	readln(p.codigo); 
	if (p.codigo <> -1) then begin 
		write(' nombre comercia: '); 
		readln(p.nombre);
		write(' precio: '); 
		readln(p.precio);
		write(' stock actual: '); 
		readln(p.stock_actual);	
		write(' stock minimo: '); 
		readln(p.stock_minimo);	
	end; 
end; 
procedure leerVenta(var v: venta); 
begin 
	write(' codigo: '); 
	readln(v.codigo); 
	if (v.codigo <> -1) then begin 
		write(' cantidad vendida: '); 
		readln(v.cant_vendida); 
	end; 
end; 
procedure crearArchivoMaestro(var mae: maestro)
var 
	p: producto; 
begin 
	Assign(mae, 'archivo_productos'); 
	rewrite(mae); 
	leerProducto(p); 
	while (p.codigo<>-1) do begin 
		write(mae, p); 
		leerProducto(p); 
	end; 
	close(mae); 
end; 

procedure crearArchivoDetalle(var det: detalle);
var 
	v: venta; 
begin 
	Assign(det, 'archivo_ventas'); 
	rewrite(det); 
	leerVenta(v); 
	while (v.codigo <>-1) do begin 
		write(det, v); 
		leerVenta(v); 
	end; 
	close(det); 
end; 

end; 
procedure actualizarMaestro(var mae: maestro; var det:detalle); 
var
	v: venta; 
	prod: producto; 
begin
	reset(mae); 
	reset(det); 
	leer(det, v); 
	while (v.codigo <> valor_alto) do begin 
		read(mae, prod); 
		while(v.codigo <> prod.codigo) do 
			read(mae, prod); 
		while (v.codigo = prod.codigo) do begin
			prod.stock_actual:=prod.stock_actual- v.cant_vendida; 
		end

