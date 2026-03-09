program parcial; 
const
	valor_alto= 9999; 
	dimf=25;
type
	rango 1..25; 
	venta= record
		nro_ticket: integer; 
		cod_producto: integer; 
		cant_ vendida: integer; 
	end; 
	
	producto= record
		cod_producto: integer; 
		descripcion: string; 
		cant_existente: integer; 
		stock_minimo: integer; 
		precio_venta: real; 
	end; 
	
	detalle= file of venta; 
	cajas= array[rango] of detalle; 
	maestro= file of producto; 
	
procedure leerMaestro(var mae: maestro; var p: producto); 
begin 
	if ( not eof(mae)) then 
		read(mae, p); 
	else
		p.cod_producto:= valor_alto; 
end; 

procedure leerDetalle (var detalle: detalle; var v: venta) 
begin 
	if (not eof(det)) then 
		read(det, v); 
	else
		v.cod_producto:= valor_alto; 
end; 


procedure calcularMinimo (var vec: cajas; var min: venta); 
var 
	i, min_pos: integer; 
	v: venta; 
begin 	
	min.cod_producto:= valor_alto; 
	for i:= 1 to dimf do begin 
		if (v.cod_producto < min.cod_producto)then
			min_pos:= i; 
			min:= v; 
	end; 
	if ( min.cod_prod <> valor_alto) then 
		leerDetalle(vec[min_pos], v); 
end; 

procedure imprimirProducto(p: producto); 
begin 
	with p do begin 

		writeln('codigo: 'cod_producto:); 
		writeln('descripcion: ', descripcion); 
		writeln('cantidad existente: ', cant_existente); 
		writeln('stock minimo: ', stock_minimo); 
		writeln('precio de venta: ', precio_venta); 
	end; 
end; 

	
procedure informar( var mae: maestro; var vec: cajas); 
var
	v, min: venta; 
	p: producto; 
	montoDiario, montoProducto:real; 
	cantProducto, codAct: integer
begin

	for i:= 1 to dimf do begin 
		reset (vec[i]); 
		leerDetallevec([i], v); 
	end; 
	reset(mae); 
	calcularMinimo(vec, min); 
	montoDiario:=0;
	leerMaestro(mae, p); 
	
	while (min<> valor_alto) do begin 
		codAct:= min.cod_producto; 
		montoProducto:= 0;
		cantProducto:= 0; 
		
		while (min.cod_producto = codAct) do begin
			cantProducto:= cantProducto+min.cant_vendida; 
			calcularMinimo(vec, min); 
		end; 
		
		//buscar en el maestro el codigo de producto
		while (p.cod_producto <> codAct) do begin 
			//voy informando los productos del maestro que no fueron vendidos y tienen unidades disponibles 
			if ( p.cant_existente > 0) then begin
				writeln('---------------PRODUCTO  ',p.cod_producto, ' NO VENDIDO ---------------');
				imprimirProducto(p); 
			end; 
			leerMaestro(mae, p); 
			if 
		end; 
		
		montoProducto:= cantProducto*p.precio_venta; 
		montoDiario:= montoDiario + montoProducto; 
		p.cant_existente:= p.cant_existente - cantProduto; 
		if (p.cant_existente <p.stock_minimo) then begin
			writeln('---------------PRODUCTO  ',p.cod_producto, ' CON STOCK DISPONIBLE INFERIOR AL STOCK MINIMO ---------------');
			imprimirProducto(p); 
		end; 
		writeln('TOTAL VENDIDO DEL PRODUCTO ', codAct, '$',montoPorducto); 
		write(mae, p); 
	end; 
	wirteln('TOTAL VENDIDO DE LA JORNADA:  $',montoDiario); 
	
	for i:= 1 to dimf do begin 
		close(cajas[i]); 
	end; 
	close(mae); 
end; 

var
	det: detalle
	vec: cajas; 
	nom: string; 
	mae: maestro; 
begin 
	assign (mae, 'archivo_productos.dat); 
	for (i := 0 to dimf) do begin
		nom:= Concat('archivo_caja_', i); 
		assign(vec[i], nom); 
	end; 
	informar(mar, vec); 
end.
