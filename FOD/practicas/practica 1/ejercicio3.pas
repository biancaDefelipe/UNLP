{
 Realizar un programa que presente un menú con opciones para:
a. Crear un archivo de registros no ordenados de empleados y completarlo con
datos ingresados desde teclado. De cada empleado se registra: número de
empleado, apellido, nombre, edad y DNI. Algunos empleados se ingresan con
DNI 00. La carga finaliza cuando se ingresa el String ‘fin’ como apellido.
b. Abrir el archivo anteriormente generado y
i. Listar en pantalla los datos de empleados que tengan un nombre o apellido
determinado, el cual se proporciona desde el teclado.
ii. Listar en pantalla los empleados de a uno por línea.
iii. Listar en pantalla los empleados mayores de 70 años, próximos a jubilarse.
NOTA: El nombre del archivo a crear o utilizar debe ser proporcionado por el usuario. 
}


program ejercicio3; 

type 
	empleado= record
		num: integer; 
		apellido: string; 
		nombre: string; 
		edad: integer;
		dni: integer; 
	end; 
	archivo_empleados= file of empleado; 

procedure mostrarMenu(var op: integer); 
begin 
	writeln('  							BIENVENIDO                    ');
	writeln('seleccione una opcion:                                   '); 
	writeln('                     1 | Generar un archivo de empleados '); 
	writeln('                     2 | Listar datos de empleados con un nombre/apellido deseado '); 
	writeln('                     3 | Listar todos los empleados '); 
	writeln('                     4 | Listar empleados proximos a jubilarse '); 
	writeln('                     5 | salir '); 
	readln(op); 
end; 
procedure leerEmpleado(var emp: empleado); 
begin 
	write('apellido: '); 
	readln(emp.apellido); 
	if (emp.apellido <> 'fin')then begin
		write('nombre: '); 
		readln(emp.nombre);
		write('edad: '); 
		readln(emp.edad);
		emp.num:= 100+ random(99); 
		writeln('numero de empleado: ', emp.num);  
		write('dni: '); 
		readln(emp.dni);
	end; 
end; 
procedure imprimirEmpleado(emp: empleado); 
begin
	writeln('		nombre: ', emp.nombre); 
	writeln('		apellido ', emp.apellido);
	writeln('		edad: ', emp.edad);
	writeln('		numero de empleado: ', emp.num);
	writeln('		dni: ', emp.dni); 
end; 
function proximoAJubilarse(emp:empleado): boolean; 
begin
	proximoAJubilarse:= emp.edad > 70 ; 
end; 
procedure listarEmpleadosApNom(var arch: archivo_empleados);
var
	emp: empleado; 
	apnom: string; 
begin 
	write('ingrese el apellido/ nombre buscado'); 
	readln(apnom); 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		if ((emp.nombre = apnom) or (emp.apellido= apnom))then 
			imprimirEmpleado(emp); 
	end; 
	close(arch); 
end; 

procedure listarTodosLosEmpleados(var arch: archivo_empleados); 
var 
	emp: empleado; 
begin 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		imprimirEmpleado(emp); 
	end; 
	close(arch); 
end; 

procedure listarProximosAJubilarse(var arch: archivo_empleados); 
var 
	emp: empleado; 
begin 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		if (proximoAJubilarse(emp) )then 
			imprimirEmpleado(emp); 
	end;
	close(arch); 
end; 
procedure crearArchivoEmpleados(var arch: archivo_empleados; var arch_fisico: string); 
var
	emp: empleado; 
begin 
	write('ingrese el nombre del archivo: '); 
	readln(arch_fisico); 
	Assign (arch, arch_fisico); 	
	leerEmpleado(emp); 
	rewrite(arch); 
	while (emp.apellido <> 'fin') do begin 
		write(arch, emp); 
		leerEmpleado(emp); 
	end; 
	close(arch); 
end; 





var 
	arch: archivo_empleados; 
	arch_fisico: string; 
	op: integer; 
begin 
	
	mostrarMenu(op); 
	while (op <> 5) do begin 
		case op of
			1 : crearArchivoEmpleados(arch, arch_fisico); 
			2 : listarEmpleadosApNom(arch); 
			3 : listarTodosLosEmpleados(arch); 
			4 : listarProximosAJubilarse(arch);
		end; 	
		mostrarMenu(op); 
	end; 
end.
	
	
	
	
