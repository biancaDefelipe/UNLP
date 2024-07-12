program parcial;
const 
	valor_alto=9999;
type
	log= record
		nro_usuario: integer; 
		nombre_usuario: string; 
		nombre: string; 
		apellido: string; 
		cant_mails_enviados: integer; 
	end; 
	
	movimiento= record
		nro_usuario: integer; 
		cuenta_destino: string; 
		cuerpo_mensaje: string; 
	end; 
	
	maestro= file of log; 
	detalle= file of movimiento; 
	
	
	
	
procedure leerMaestro(var mae: maestro; var l: log) ; 
begin 
	if (not eof(mae ))then 
		read(mae, l)
	else
		l.nro_usuario:= valor_alto; 
end; 

procedure leerDetalle(var det: detalle; var m: movimiento) ;
begin 
	if (not eof(det))then 
		read(det, m)
	else
		m.nro_usuario:= valor_alto; 
end; 

procedure mostrarMenu(var op: integer); 
begin 
	writeln('----- Seleccione una opcion -----'); 
	writeln('1: Actualizar archivo de logs '); 
	writeln('2: Generar listado '); 
	writeln('0: salir  '); 
	readln(op); 
	writeln('---------------------------------'); 
end; 

procedure actualizarMaestro(var mae: maestro; var det: detalle);
var 
	m:movimiento; 
	l: log; 
	totalMails, usuarioActual: integer; 
begin 
	reset (det); reset(mae); 
	leerDetalle(det, m); leerMaestro(mae, l); 
	while (m.nro_usuario<> valor_alto) do begin 
		usuarioActual:= m.nro_usuario; 
		totalMails:= 0; 
		while (m.nro_usuario <> valor_alto) and (m.nro_usuario = usuarioActual) do begin 
			totalMails:= totalMails+1; 
			leerDetalle(det, m); 
		end; 
		while (l.nro_usuario<> usuarioActual) do 
			leerMaestro(mae, l); 
		l.cant_mails_enviados:= l.cant_mails_enviados + totalMails; 
		seek(mae, filepos(mae)-1); 
		write(mae, l); 
	end; 
	close(det); close(mae); 
end; 

procedure generarInforme(var mae: maestro); 
var
	texto: Text; 
	l: log; 
begin
	reset(mae); 
	assign(texto, 'listado.txt'); 
	rewrite(texto); 
	leerMaestro(mae, l); 
	while(l.nro_usuario <> valor_alto) do begin 
		with l do begin 
			writeln(texto, ' numero usuario: ', nro_usuario,' cantidad de mails enviados: ',cant_mails_enviados); 
			writeln(texto,' nombre usuario: ', cant_mails_enviados); 
		end;
		leerMaestro(mae, l); 
	end; 
	close (mae); 
	close(texto); 
end;  



/// para prueba
procedure leerLog(var l: log); 
begin

	write(' numero usuario: '); 
	readln(l.nro_usuario); 
	if (l.nro_usuario <> -1) then begin 
		write(' nombre usuario: '); 
		readln(l.nombre_usuario); 
		write('nombre: '); 
		readln(l.nombre); 
		write('apellido: '); 
		readln(l.apellido);
		write('cant mails enviados: '); 
		readln(l.nombre);
	end; 
end; 
procedure leerMovimiento(var m: movimiento); 
begin 
	write(' numero usuario: '); 
	readln(m.nro_usuario); 
	if (m.nro_usuario <> -1) then begin 
		write('cuenta destino: '); 
		readln(m.cuenta_destino); 
		write('cuerpo mensaje: '); 
		readln(m.cuerpo_mensaje); 
	end; 
end; 
procedure crearArchivos(var mae: maestro; var det: detalle); 
var 
	l: log; m: movimiento; 
	
begin 
	rewrite(mae); 
	rewrite(det);
	leerLog(l);
	while (l.nro_usuario <> -1) do begin 
		 write(mae, l); 
		 leerLog(l); 
	end;
	leerMovimiento(m);
	while (m.nro_usuario <> -1) do begin 
		 write(det, m); 
		 leerMovimiento(m); 
	end; 
	close(mae); close(det); 
end; 

var
	mae: maestro; 
	det: detalle; 
	op: integer; 
begin 
	assign(mae, '/var/log/logsmaill.dat'); 
	assign(det, '6junio2017.dat'); 
	crearArchivos(mae, det); 
	//exportarATXT(mae, det); 
	mostrarMenu(op);
	while (op <> 0) do begin
		case op of 
		1: actualizarMaestro(mae, det); 
		2: generarInforme(mae); 
		end; 
		mostrarMenu(op); 
	end; 
end.

	
	
