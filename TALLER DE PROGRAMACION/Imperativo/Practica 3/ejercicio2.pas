{
2.Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio. 
	De cada venta se lee código de producto, fecha y cantidad de unidades vendidas.
	La lectura finaliza con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
		i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto.
		ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por código de producto.
			Cada nodo del árbol debe contener el código de producto y la cantidad total vendida.
               Nota: El módulo debe retornar los dos árboles. 
        b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.
		c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.

}
program ejercicio2.pas; 


type
	producto= record
		cod_prod:integer;
		cant_vendida: integer; 
	end; 

	venta= record
		producto:producto; 
		fecha: string; 
	end; 
	
	arbolProductos= ^nodoProd;
	nodoProd=record
		dato:producto; 
		HI:arbolProductos; 
		HD: arbolProductos; 
	end; 
	
	arbolVentas = ^nodoVenta;
	nodoVenta=record
		dato: venta; 
		HI:arbolVentas; 
		HD: arbolVentas; 
	end; 
	
	

procedure leerProducto( var p: producto); 
begin 
	write(' codigo de producto: '); 
	readln(p.cod_prod); 
	if (p.cod_prod <> 0 ) then begin 
		write(' cantidad vendida: '); 
		readln(p.cant_vendida);
	end; 
end; 

procedure leerVenta (var  v: venta; p:producto); 
begin

		write(' fecha de venta: '); 
		readln(v.fecha); 
		v.producto:= p; 
	end; 


//puede haber repetidos 
procedure insertarNodoVenta (var a: arbolVentas; v: venta);
  begin
    if (a = nil) then begin
      new(a);
      a^.dato:= v;
      a^.HI:= nil;
      a^.HD:= nil;
    end
    else 
		if(v.producto.cod_prod < a^.dato.producto.cod_prod) then
			insertarNodoVenta(a^.HI, v)
		else
			insertarNodoVenta(a^.HD, v);
  end;


procedure insertarNodoProducto (var a: arbolProductos ; p:producto); 
begin
	if (a = nil) then begin 
		new(a);
		a^.dato:= p; 
		a^.HI:= nil; 
		a^.HD:= nil; 
	end
	else 
		if( p.cod_prod = a^.dato.cod_prod) then 
			a^.dato.cant_vendida:= a^.dato.cant_vendida + p.cant_vendida
		else 
			if (p.cod_prod < a^.dato.cod_prod) then 
				insertarNodoProducto(a^.HI, p)
			else 
				insertarNodoProducto (a^.HD, p); 
end; 


procedure leerYcrear( var aP: arbolProductos; var aV: arbolVentas);
var 
	v:venta; 
	p:producto; 
begin 
	aP:=nil;
	aV:= nil;  
	leerProducto(p); 
	while(p.cod_prod <> 0)do  begin   
		leerVenta(v, p); 
		insertarNodoProducto(aP, v.producto); 
		insertarNodoVenta(aV, v);   
		writeln('---------------------------------------------'); 
		leerProducto(p);  
		 
	end; 
end; 


procedure imprimirProductosEnorden(a:arbolProductos); 
begin 
	if (a <> nil) then begin 
		imprimirProductosEnOrden (a^.HI); 
		write ('| codigo: ', a^.dato.cod_prod, '| cantidad vendida: ', a^.dato.cant_vendida);
		writeln('----');
		imprimirProductosEnOrden(a^.HD); 
	end; 
end; 

procedure imprimirVentasEnorden(a:arbolVentas); 
begin 
	if (a <> nil) then begin 
		imprimirVentasEnOrden (a^.HI); 
		write ('| codigo: ', a^.dato.producto.cod_prod, '| cantidad vendida: ', a^.dato.producto.cant_vendida,' | fecha: ', a^.dato.fecha);
		writeln('----');
		imprimirVentasEnOrden(a^.HD); 
	end; 
end; 

{
 b. Implemente un módulo que reciba el árbol generado en i. 
 y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.}
 
 function sumarUnidadesVendidas(a:arbolVentas; cod:integer):integer; 
 begin 
	if (a=nil) then 
		sumarUnidadesVendidas := 0
	else
		if (a^.dato.producto.cod_prod= cod) then 
			sumarUnidadesVendidas:= a^.dato.producto.cant_vendida+ sumarUnidadesVendidas(a^.HD, cod)
		else 
			if (a^.dato.producto.cod_prod > cod) then 
				sumarUnidadesVendidas:= sumarUnidadesVendidas(a^.HI, cod)
			else 
				sumarUnidadesVendidas:= sumarUnidadesVendidas(a^.HD, cod)
end; 
procedure buscarEnVentas (a:arbolVentas); 
var
	cod: integer; 
begin 
	write('ingrese un codigo de producto: '); 
	readln(cod); 
	
	writeln(' el producto de codigo: ', cod,  ' tiene ', sumarUnidadesVendidas(a, cod), ' unidades vendidas'); 
end; 
{
* 
	 Implemente un módulo que reciba el árbol generado en ii. 
	 y un código de producto y retorne la cantidad total de unidades vendidas de ese producto.
* }
function buscar (a:arbolProductos;  cod:integer):arbolProductos; 
begin 
	if (a = nil) then 
		buscar:= nil
	else
		if (a^.dato.cod_prod = cod) then 
			buscar:=a
		else
			if (a^.dato.cod_prod > cod) then
				buscar:= buscar(a^.HI,cod)
			else 
				buscar:= buscar(a^.HD, cod); 
				
end; 
procedure buscarEnProductos(a:arbolProductos); 
var
	cod: integer; 
	arb: arbolProductos; 
begin 
	write('ingrese un codigo de producto: '); 
	readln(cod); 
	arb := buscar(a, cod); 
	if (arb <> nil) then 
		writeln(' el producto de codigo: ', cod,  ' tiene ', arb^.dato.cant_vendida, ' unidades vendidas')
	else
		writeln('el codigo de producto no existe'); 
end; 



{programa principal}

var
	aP:arbolProductos;
	aV:arbolVentas;
	
	flag: integer; 
begin 


	//creo los arboles
	leerYCrear(aP, aV); 
	
	
	//imprimir
	writeln('---------------------------------------------');
	writeln('arbol de productos vendidos: '); 
	imprimirProductosEnorden(aP); 
	
	writeln('---------------------------------------------');
	writeln('arbol de ventas: ');
	imprimirVentasEnOrden(aV); 
	
	write('ingrese 1 para continuar y 0 para salir '); 
	readln(flag); 
	while (flag <> 0 )do begin 
		
		//contar unidades vendidas a partir del arbol de ventas
		writeln('---------------------------------------------');
		buscarEnVentas(aV); 
		
		
		//informar unidades vendidas de un producto a traves del arbol de productos
		writeln('---------------------------------------------');
		buscarEnProductos(aP); 
		
		
		writeln('---------------------------------------------');
		write('ingrese 1 para continuar y 0 para salir '); 
		readln(flag); 
	
	end; 
end.
