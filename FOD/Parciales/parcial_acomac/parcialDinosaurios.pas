program parcial_dinosaurios; 
const
	valor_alto:= 9999; 
type 
	recordDinos= record
		codigo: integer; 
		tipo: string; 
		altura: real; 
		peso_promedio: real; 
		descripcion: string; 
		zona_ geografica: string; 
	end; 
	tArchDinos= file of recordDinos; 
	
procedure leer( var arch: tArchDinos; var d: recordDinos); 
begin 
	if (not eof(arch)) then 
		read(arch, d); 
	else
		d.codigo:= valor_alto; 
end; 

procedure leerDinosaurio(var dino: recordDinos); 
begin
	write('codigo de dinosaurio: '); 
	readln(dino.codigo); 
	if (dino.codigo <> valor_alto) then begin
		write('tipo de dinosaurio: '); 
		readln(dino.tipo); 
		write('altura del  dinosaurio: '); 
		readln(dino.codigo); 
		write('peso promedio del dinosaurio: '); 
		readln(dino.peso_promedio);
		write('descripcion: '); 
		readln(dino.descripcion); 
		write('zona_ geografica: '); 
		readln(dino.zona_geografica), 
	end; 
end; 

procedure agregarDinosaurio (var a: tArchDinos ; registro: recordDinos);
var 
	dino: recordDinos; 
begin 
	reset(a); 
	leer(a, cabecera); 
	if (cabecera.codigo =0) then 
		seek(a, filesize (a)) 
		write(a, dino); 
	else begin
		seek(a, cabecera.codigo*-1); 
		leer(a, cabecera); 
		seek(a, filepos(a)-1); 
		write(a, dino); 
		seek(a, 0); 
		write(a, cabecera);
	end; 
	close (a); 
end; 

procedure exportarATXT(var a: tArchDinos); 
var 
	txtDinos: text; 
begin 
	reset(a); 
	rewrite(txtDinos); 
	assign(txtDinos, 'archivo_dinosaurios.txt'); 
	
	leer(a, dino); 
	leer(a, dino); 
	while (dino.codigo <> valor_alto) do begin 
		if (dino.codigo >0)then 
			with dino do begin
				writeln(txtDinos, ' codigo ', codigo, '| altura ', altura,'| peso promedio: 'peso_promedio); 
				writeln(txtDinos, ' tipo ', tipo); 
				writeln(txtDinos, ' descripcion ', descripcion); 
				writeln(txtDinos, ' zona geografica ', zona_geografica); 
				writeln('-------------------------------------------------------------------------------------------'); 
			end; 
		leer(a, dino); 
	end; 
	
	close(txtDinos); 
	close(a); 
end; 

procedure agregar (var a: tArchDinos); 
var 
	ok: boolean;
	dino:recordDinos; 
begin 
	write('¿desea agregar un dinosaurio al archivo? (true/false)... '  ); 
	readln(ok); 
	while (ok) do begin
		leerDinosaurio(dino); 
		agregarDinosaurio(a, dino); 
		writeln(); 
		write('¿desea agregar un dinosaurio al archivo? (true/false)... '  ); 
		readln(ok); 
	end; 
end; 
{programa principal}
			
var
	a: tArchDinos; 
begin 
	assign(a, 'archivo_binario_dinosaurios'); 
	rewrite(a); 
	close(a); 
	
	//agregar dinosaurios
	agregar(a); 
	
	//exportar a txt
	exportarATXT(a); 
end.
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
