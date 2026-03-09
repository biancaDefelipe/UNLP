program ejercicio4; 
const 
	valor_alto ='zzz'
type
	reg_mae= record
		nombre: string; 
		alfabrtizadas: integer; 
		encuestadas: integer; 
	end; 
	arch_maestro= file of reg_mae; 
	
	registro_det= record 
		nombre: string; 
		cod_loc: integer; 
		alfabetizadas: integer; 
		encuestadas: integer; 
	end; 
	archivo_detalle= file of reg_det; 
	
	
procedure leer (var rdet: reg_det; var det: archivo_detalle); 
begin
	if (not eof(det)) then begin
		read(det, rdet); 
	else
		rdet.nombre:= valor_alto; 
end; 


procedure minimo (var det1, det2: archivo_detalle; var rdet1, rdet2, min: reg_det); 
begin
	if (rdet1.nombre<= rdet1.nombre) then  begin
		min:= rdet1; 
		leer(det1, rdet1); 
	end
	else begin
		min:= rdet2; 
		leer(rdet2, det2); 
	end; 
end; 
procedure actualizarMae ( var mae: archivo_maestro; var det1, det2: archivo_detalle); 
var
	rdet1, rdet2, min: reg_det; 
	rmae: reg_mae; 
begin 
	reset(mae); 
	reest(det1); 
	reset(det2); 
	leer(rdet1, det1); 
	leer(rdet2, det2);  

procedure crearMae(var mae:archivo_maestro; va

{prorgama principal}
* 
