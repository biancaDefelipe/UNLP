{
El encargado de ventas de un negocio de productos de limpieza desea administrar el
stock de los productos que vende. Para ello, genera un archivo maestro donde figuran
todos los productos que comercializa. De cada producto se maneja la siguiente
información: código de producto, nombre comercial, precio de venta, stock actual y
stock mínimo. Diariamente se genera un archivo detalle donde se registran todas las
ventas de productos realizadas. De cada venta se registran: código de producto y
cantidad de unidades vendidas. Resuelve los siguientes puntos:
* 
* a. Se pide realizar un procedimiento que actualice el archivo maestro con el
archivo detalle, teniendo en cuenta que:
i. Los archivos no están ordenados por ningún criterio.
ii. Cada registro del maestro puede ser actualizado por 0, 1 ó más registros
del archivo detalle.
b. ¿Qué cambios realizaría en el procedimiento del punto anterior si se sabe que
cada registro del archivo maestro puede ser actualizado por 0 o 1 registro del
archivo detalle?
   
   
}

program ejercicio1; 

const 
	valor_alto= 99999; 
type
	producto= record
		codigo: integer, 
		nombre: string; 
		precio: real; 
		stock_actual: integer; 
		stock_minimo: integer; 
	end; 
	
	venta= record
		codigo: integer; 
		cant_vendida: integer; 
	end; 
	archivo_maestro= file of producto; 
	archivo_detalle= file of venta; 
	
procedure leerProducto(var p: producto); 
begin
	writeln(); 
	write('ingrese codigo de producto: '); 
	readln(p.codigo); 
	if (p.codigo <> -1)then begin 
		write('ingrese nombre comercial: '); 
		readln(p.nombre); 
		write('ingrese precio: '); 
		readln(p.precio); 
		write('ingrese stock actual: '); 
		readln(p.stock_actual); 
		write('ingrese stock minimo: '); 
		readln(p.stock_minimo); 
	end; 
	writeln('-----------------------------------------------------------------------'); 
end; 

procedure leerVenta(var v: venta); 
begin 
	writeln(); 
	write('ingrese codigo de producto vendido: '); 
	readln(v.codigo); 
	if (p.codigo <> -1) then begin
		write('ingrese cantidad vendida: '); 
		readln(p.cant_vendida); 
	end; 
	writeln('-----------------------------------------------------------------------'); 
end; 

procedure generarMaestro(var arch: archivo_maestro); 
var 
	p: producto; 
	nom: string; 
begin 
	write(' ingrese nombre del archivo maestro: '); 
	readln(nom); 
	
	nom:= concat(nom, '.dat'); 
	assign (arch, nom); 
	rewrite(arch);
	
	leerProducto(p); 
	while (p.codigo <> -1) do begin 
		write(arch, p); 
		leerProducto(p);
		
	end; 
	
	close(arch); 
end; 

procedure generarDetalle (var arch: archivo_detalle);
var 
	v: venta; 
	nom: string; 
begin 
	write('ingrese nombre del archivo detalle: '); 
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	
	asiign(arch, nom); 
	rewrite(arch); 
	
	leerVenta(v); 
	while (v.codigo <> -1) do begin 
		write(arch, v); 
		leerVenta(v); 
	end; 
	
	close(arch); 
end; 
procedure leerProductoDesdeMaestro(var arch: archivo_maestro; var p: producto); 
begin 
	if (not eof(arch)) then 
		read(arch, p); 
	else 
		p.codigo:= valor_alto; 
end; 

procedure leerVentaDesdeDetalle(var arch: archivo_detalle; var v: venta); 
begin 
	if (not eof(arch))then 
		read(arch, v); 
	else
		v.codigo:= valor_alto; 
end; 
procedure actualizarMaestro( var mae: archivo_maestro; var det: archivo_detalle); 
var 
	p, actual: producto; 
	v: venta; 
	total: integer; 
	nom: string; 
begin 
	write('ingrese nombre del archivo maestro que desea actualizar: '); 
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	assign(mae, nom); 
	reset(mae); 
	
	write('ingrese nombre del archivo detalle con el cual actualizar el maestro: '); 
	readln(nom); 
	nom:= concat(nom, 'dat'); 
	assign(det, nom); 
	reset(det); 

	leerProductoDesdeMaestro(mae, p); 
	leerVentaDesdeDetalle(det, v); 
	
	while (p.codigo <> valor_alto) and (v.codigo <> valor_alto) do begin
		
		while (p.codigo <> v.codigo) do 
			leerProductoDesdeMaestro(mae, p); 
		
		if (p.codigo= v.codigo) then begin 
			actual:= p; 
			actual.stock_actual:= actual.stock_actual - v.cant_vendida; 
			
			while (v.codigo <> valor_alto) do begin 
				leerVentaDesdeDetalle(v.
			
			
		
	
	
END.

