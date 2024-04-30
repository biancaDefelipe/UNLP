{
   Definir un programa que genere un archivo con registros de longitud fija conteniendo
información de asistentes a un congreso a partir de la información obtenida por
teclado. Se deberá almacenar la siguiente información: nro de asistente, apellido y
nombre, email, teléfono y D.N.I. Implementar un procedimiento que, a partir del
archivo de datos generado, elimine de forma lógica todos los asistentes con nro de
asistente inferior a 1000.
Para ello se podrá utilizar algún carácter especial situándolo delante de algún campo
String a su elección. Ejemplo: ‘@Saldaño’.
   
}


program ejercicio2;
const 
	valor_invalido= -1; 
	marca_borrado='@'; 
type 
	asistente= record 
		numero: integer; 
		apnom: string; 
		email:string; 
		telefono: integer; 
		dni: integer; 
	end;  
	archivo_asistentes= file of asistente; 
	
procedure leerAsistenteDesdeArchivo(var arch: archivo_asistentes; var a : asistente);
begin 
	if (not eof(arch)) then 
		read(arch, a)
	else	
		a.numero:=valor_invalido; 
end; 
procedure leerAsistente (var a: asistente); 
begin
	write(' ingrese numero de asistente: '); 
	readln(a.numero); 
	
	if (a.numero <> -1) then begin 
		write(' ingrese apellido y nombre: '); 
		readln(a.apnom); 
		write(' ingrese email: '); 
		readln(a.email); 
		write(' ingrese numero de telefono: '); 
		readln(a.telefono); 
		write(' ingrese dni: '); 
		readln(a.dni);
	end; 
end;
procedure generarArchivo(var arch: archivo_asistentes); 
var
	a:asistente; 
begin
	leerAsistente(a); 
	while (a.numero <> -1) do begin 
		write(arch, a); 
		leerAsistente(a);
	end; 
	close(arch); 
end; 
procedure eliminarAsistentes(var arch: archivo_asistentes); 
var 
	a: asistente; 
	marca: string;
begin 
	reset (arch); 
	leerAsistenteDesdeArchivo(arch, a); 
	while (a.numero <> valor_invalido) do begin 
		if (a.numero < 1000) then begin
			marca:= Concat(marca_borrado, a.apnom); 
			a.apnom:= marca; 
			seek (arch, filepos(arch)-1); 
			write(arch, a); 
		end; 
		leerAsistenteDesdeArchivo(arch, a); 
	end; 
	close(arch); 
end; 

procedure exportar(var arch:archivo_asistentes);
var 
    txt:Text;
    a:asistente;
    texto:string; 
begin 
    assign(txt,'asistentes.txt');
    rewrite(txt);
    reset(arch);
    leerAsistenteDesdeArchivo(arch, a);
    while (a.numero <> valor_invalido) do begin 
            writeln(txt,' numero : ', a.numero,' telefono: ',a.telefono, ' dni: ', a.dni);
            texto:= Concat (' email: ', a.email);
            writeln(txt, texto); 
            texto:= Concat ('apellido y nombre: ', a.apnom);
            writeln(txt,texto);
            texto:= '------------------------------------------------------'; 
            writeln(txt, texto); 
            leerAsistenteDesdeArchivo(arch, a); 
     end;
    close(arch);
    close(txt);
end;
var
	arch: archivo_asistentes; 
begin
	Assign (arch, 'archivo de asistentes.dat');
	rewrite(arch); 
	generarArchivo(arch); 
	writeln('------ archivo binario creado exitosamente ------'); 
	eliminarAsistentes(arch); 
	writeln('------ eliminando asistentes con numero menor a 1000 ------'); 
	exportar(arch);
	
	
END.

