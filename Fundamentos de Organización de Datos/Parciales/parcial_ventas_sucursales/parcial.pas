program parcial6.pas; 
const
	dimf = 3;
	valor_alto=9999;
type
	venta= record
		cod_repuesto: integer;
		nombre_repuesto:string;
		cantidad_vendida:integer;
		fechaYhora_venta:string;
	end;
	reg_maestro=record
		cod_repuesto:integer; 
		nombre_repuesto:string;
		cantidad_total_vendida:integer; 
	end; 
	archivo_detalle= file of venta; 
	sucursales =array[1.. dimf] of archivo_detalle; 
	archivo_maestro =file of reg_maestro; 
procedure leerDetalle(var det:archivo_detalle; var reg: venta);
begin
	if (not eof (det)) then
		read(det, reg)
	else
		reg.cod_repuesto:= valor_alto; 
end;


procedure minimo (var vec: sucursales; var min, min1, min2, min3: venta);

begin
	if( (min1.cod_repuesto <> valor_alto) and ((min1.cod_repuesto <= min2.cod_repuesto) and (min1.cod_repuesto <= min3.cod_repuesto)) ) then begin
		min:= min1;
		leerDetalle(vec[1], min1); 
	end
	else 
		if ( (min2.cod_repuesto <> valor_alto) and ((min2.cod_repuesto <= min1.cod_repuesto) and (min2.cod_repuesto <= min3.cod_repuesto)) ) then begin
			min:= min1;
			leerDetalle(vec[2], min2); 
		end
		else begin 
			if ( (min3.cod_repuesto <> valor_alto) and ((min3.cod_repuesto <= min1.cod_repuesto) and (min3.cod_repuesto <= min2.cod_repuesto)) ) then begin	
				min:= min1;
				leerDetalle(vec[3], min2); 
			end
		end;
	end;  

procedure merge (var mae:archivo_maestro;var vec:sucursales);
var
	reg:reg_maestro;
	min, min1, min2, min3:venta;
	total, i :integer; 
begin
	for i:=1 to dimf do 
		reset(vec[i]);
	leerDetalle(vec[1],min1);
	leerDetalle(vec[2],min2);
	leerDetalle(vec[3],min3);
	minimo(vec, min,min1, min2, min3);
	while (min.cod_repuesto<> valor_alto) do begin
		reg.nombre_repuesto:= min.nombre_repuesto;
		reg.cod_repuesto:= min.cod_repuesto;
		reg.cantidad_total_vendida:=0; 
		while (min.cod_repuesto<> valor_alto) and (min.cod_repuesto =reg.cod_repuesto) do begin
			reg.cantidad_total_vendida:= reg.cantidad_total_vendida+ min.cantidad_vendida;
			minimo(vec, min, min1, min2, min3); 
		end; 
		write(mae, reg); 
		writeln(); 
	end; 
	
	for i:=1 to dimf do 
		close(vec[i]);
	close(mae); 
end; 

var 
	mae: archivo_maestro; 
	
begin
	

end.
 
