
program ejercicio14; 
Uses crt, SysUtils;
const
	dimf= 10; 
	valor_alto= 9999; 
type 
	reg_mae= record
		cod_pcia: integer;
		nom_pcia: string; 
		cod_loc: integer; 
		nom_loc: string; 
		v_sin_luz: integer; 
		v_sin_gas: integer; 
		v_de_chapa: integer; 
		v_sin_agua: integer; 
		v_sin_sanitarios: integer; 
	end; 
	
	reg_det= record
		cod_pcia: integer;
		cod_loc: integer;
		v_con_luz: integer; 
		v_construidas: integer; 
		v_con_agua: integer; 
		v_con_gas: integer; 
		sanitarios_entregados: integer; 
	end; 
	
	detalle= file of reg_det;
	maestro= file of reg_mae; 
	vec_det= array[1..dimf] of detalle; 
	vec_reg= array[1..dimf] of reg_det; 
	
procedure leerDetalle( var det: detalle; var r: reg_det); 
begin 
	if ( not eof(det)) then 
		read(det, r); 
	else
		r.cod_pcia:= valor_alto; 
end; 

procedre leerMaestro(var mae: maestro; var r: reg_mae); 
begin 
	if (not eof(mae)) then 
		read(mae, r); 
	else
		r.cod_pcia:= valor_alto; 
end; 


procedure calcularMinimo(var vd: vec_det; var vr: vec_reg; var min: reg_det); 
var
	i, posMin: integer; 
begin 
	min.cod_pcia:= valor_alto; min.cod_loc:= valor_alto; 

	for i:= 1 to dimf do begin 
		if (vr[i].cod_pcia < min.cod_pcia) or ((vr[i].cod_pcia= min.cod_pcia) and (vr[i].cod_loc < min.cod_pcia)) then begin 
			min:= vr[i]; 
			minPos:=i; 
		end; 
	end; 
	if (min.cod_pcia <> valor_alto) then 
		leerDetalle(vd[minPos], vr[minPos]); 
end; 

procedure inicialDetalles(var vd: vec_det; var vr: vec_reg); 
var 
	num,nom: string; 
	i: integer; 
begin 
	for i:= 1 to dimf do begin 
		str(i, num); 
		//nom:= Concat( 'detales_', num, '.dat'); 
		assign (vd[i], 'detalle_'+num+'.dat'); 
		reset(vd[i]); 
		leerDetalle(vd[i], vr[i]); 
	end; 
end; 
procedure actualizarRegistro(var r: reg_mae;var rd: reg_det); 
begin 
	r.v_sin_luz:= r.v_sin_luz - rd.v_con_luz; 
	r.v_sin_agua:= r.v_sin_agua - rd.v_con_agua; 
	r.v_sin_gas:= r.v_sin_gas- rd.v_con_gas; 
	r.v_sin_sanitarios:= r.v_sin_sanitarios- rd.sanitarios_entregados; 
	r.v_de_chapa:= r.v_de_chapa -rd.v_construidas; 
end; 

procedure actualizarMaestro(var mae: maestro; var; vd: vec_det); 
var 
	vr: vec_reg; 
	r: reg_mae; 
	min: reg_det; 
	i, cantLoc:integer; 
	
	
begin 
	Assign(mae, 'maestro.dat');reset(mae); leerMaestro(mae, r); 
	inicialDetalles(vd, vr); calcularMinimo(vd, vr, min);
	cantLoc:=0; 
	while (r.cod_pcia <> valor_alto) do begin 
		if( (min.cod_pcia <> valor_alto) and (min.cod_pcia = r.cod_pcia) and (min.cod_loc =r.cod_loc) )then begin
			actualizarRegistro(r, min); 
			calcularMinimo(vd, vr, min); 
		end; 
		//pregunto por 0 o pregunto por <= a 0?
		if (r.v_de_chapa <= 0) then 
			cantLoc:= cantLoc +1; 
		leerMaestro(mae, r); 
	end; 
	writeln('Cantidad de localidades sin viviendas : ', cantLoc); 
	for i:= 1 to dimf do 
		close(vd[i]); 
	close(mae); 
end; 




	
	
