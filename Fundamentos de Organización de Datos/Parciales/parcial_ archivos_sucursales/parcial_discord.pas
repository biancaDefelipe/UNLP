program parcial: 
const
	valor_alto=32000; 
type
	log= record
		numero: integer; 
		nombre: string; 
		nombre_usuario: string
		apellido_usuario: string; 
		cant_mails: integer; 
	end; 
	archivo_logs= file of log; 
	
	servidor=record
		numero_usuario:integer; 
		destino: string; 
		mensaje: string; 
	end; 
	archivo_detalle= file of servidor; 
	
	
procedure leerDetalle (var det: archivo_detalle; var reg: servidor); 
begin
	if (not eof(det)) then 
		read(det, reg); 
	else
		reg.numero_usuario:= valor_alto; 
end; 


procedure leerLogs (var log: archivo_logs; var reg: log); 
begin
	if (not eof(log)) then 
		read(log, reg); 
	else
		reg.numero:= valor_alto; 
end; 


procedure actualizar (var archLogs: archivo_logs; var det: archivo_detalle); 
var
	reg_det, act: servidor; 
	reg_mae:log; 
	total:integer; 
begin
	reset(archLogs); 
	reset(det); 
	leerDetalle(det, reg_det); 
	leerMaestro(archLogs, reg_mae);    //opcional?
	while (reg_det.numero_usuario <> valor_alto) do begin 
		act:=reg_det; 
		while (act.numero_usuario <> reg_mae.numero) do 
			leerMaestro(archLogs, reg_mae); 
		total:=0; 
		while (reg_det.numero_usuario <> valor_alto) and (reg_det.numero_usuario = act.numero) do begin 
			total:= total +1; 
			leerDetalle(det, reg_det); 
		end; 
		
		seek(archLogs, filepos(archLogs)-1); 
		reg_mae.cant_mails:=reg_mae.cant_mails + total; 
		write(archLogs, reg_mae); 
	end; 

	close(archLogs); 
	close(det); 
end; 

procedure exportarATXT(var det: archivo_detalle); 
var 
	detalleTxt:Text; 
begin 
	
	assing(detalleTxt, 'listado.txt'):
	rewrite(detalleTxt);
	reset(det); 
	leerDetalle(det, reg_det); 
	while (reg_det.numero_usuario <> valor_alto) do begin 
		act:=reg_det; 
		total:=0; 
		while (reg_det.numero_usuario <> valor_alto) and (reg_det.numero_usuario = act.numero) do begin 
			total:= total +1; 
			leerDetalle(det, reg_det); 
		end; 
		

		write(detalleTxt, act.numero); 
		write(detalleTxt, act.nombre); 
	end; 

	close(archLogs); 
	close(det); 
	










 
