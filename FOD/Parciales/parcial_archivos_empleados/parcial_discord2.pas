program parcial2; 

const
	valor_alto= 32000; 

type
	empleado=record
		dni: integer; 
		nombre: string; 
		apellido:string; 
		edad: integer; 
		domicilio:string; 
		fechaN: string; 
	end; 
	
	empleados= file of empleado; 

procedure leer(var f: empleados; e: empleado);
begin
	if(not eof(f) )then 
		read(f, e); 
	else
		e.dni:= valor_alto; 
end; 

procedure leerEmpleado(var e: empleado); 
begin 
	write('dni: '); 
	readln(e.dni); 
	if (e.dni <> -1) do begin	
		write('nombre: '); 
		readln(e.nombre); 
		write('apellido: '); 
		readln(e.apellido);
		write('edad: '); 
		readln(e.edad); 
		write('domicilio: '); 
		readln(e.domicilio);
		write('fecha de nacimiento: '); 
		readln(e.fechaN);  
	end; 
end; 
procedure agregarEmpleado(var f: empleados); 
var
	e, cabecera: empleado; 
begin
	leerEmpleado(e); 

	if (existeEmpleado(e.dni, f)) then
		write('existe empleado');
	else begin
		reset(f); 
		leer(f, cabecera); 
		if (cabecera.dni <0) then begin
			seek(f, cabecera.dni*-1); 
			leer(f, cabecera); 
			seek(f, filepos(arch)-1); 
			write(f, e); 
			seek(f, 0); 
			write(f, c); 
		end; 
		else begin
			seek(f, filesize(f)); 
			write(f, e); 
		end; 
		close(f); 
	end; 
end; 

procedure quitarEmpleado(var f: empleados)
var 
	cabecera, eNuevo, aux:empleado;  
	dni: integer; 
begin
	write(' ingrese dni del empleado a eliminar: '); 
	readln(dni); 
	if (existeEmpleado(dni, f))then begin
		reset(f); 
		leer(f, cabecera); 
		leer(f, aux) //1er registtro
		while (aux.dni <> dni) do begin 
			leer(f, aux); 
		end;
		seek(f, filepos(f)-1);  
		aux.dni:= (filepos(f) )*-1;  //pongo en -1 el dni del reg que quiero datr de baja
		write(f, cabecera);
		seek(f, 0); 
		write(f, aux); 
		
		close(f); 
	end; 
		
		
end; 
