program parcial_29_6;

const 
	valor_alto= 'zzz';
	
type 
	municipio = record 
		nombre: string; 
		descripcion: string; 
		cant_habitantes: integer; 
		extension: real; 
		anio_creacion: integer; 
	end; 
	
	archivo_municipios= file of municipio;

procedure leer(var arch: archivo_municipios; var m: municipio) ;
begin 
	if (not eof(arch)) then 
		read(arch, m)
	else 
		m.nombre:= valor_alto; 
end; 

function existeMunicipio(var arch: archivo_municipios; nombre: string) : boolean;
var 
	m: municipio; 
	encontre: boolean; 
begin 
	reset (arch); 
	encontre:= false; 
	leer(arch, m); //1er reg es de cabecera
	leer(arch, m); 
	while(m.nombre<> valor_alto) and( not encontre) do begin 
		if (m.nombre = nombre) then 
			encontre := true
		else
			leer(arch,m); 
	end;
	//close(arch); 
	existeMunicipio:= encontre; 
end; 
procedure leerMunicipio(var m: municipio); 
begin 
	write('nombre: '); 
	readln(m.nombre);  
	if (m.nombre <> valor_alto) then begin
		write('descripcion: '); 
		readln(m.descripcion);  
		write('cantidad de habitantes: '); 
		readln(m.cant_habitantes);  
		write('extendsion en metros cuadrados: '); 
		readln(m.extension);  
		write('anio de creacion '); 
		readln(m.anio_creacion);  
	end;
	writeln(); 
end; 

procedure agregarMunicipio(var arch: archivo_municipios); 
var 
	nuevo, cabecera, aux: municipio; 
	ok: boolean;
begin 
	reset (arch); 
	leerMunicipio(nuevo); 
	if((nuevo.nombre <> valor_alto) and (not existeMunicipio(arch, nuevo.nombre)))then begin
		//reset (arch);
		seek(arch, 0);
		leer(arch, cabecera); 
		if (cabecera.cant_habitantes <0) then begin 
			seek(arch, cabecera.cant_habitantes* -1); 
			leer(arch, cabecera); 
			seek(arch, filepos(arch)-1);
			write(arch, nuevo); 
			seek(arch, 0); 
			write(arch, cabecera);
		end
		else begin
			seek(arch, filesize(arch)); 
			write(arch, nuevo); 
		end
	end
	else 
		if (nuevo.nombre<> valor_alto) then 
			writeln('ya existe el municipio en el archivo');
	close(arch); 
end; 

procedure bajaMunicipio(var arch :archivo_municipios);
var
	nom: string;
	cabecera, m: municipio;
	pos: integer;
begin 
	write('ingrese nombre del municipio a eliminar: '); 
	readln(nom); 
	if (existeMunicipio(arch, nom)) then begin
		pos:=filePos(arch)-1;
		seek(arch, pos); 
		leer(arch, m); 
		m.cant_habitantes:=pos*-1; 
		
		seek(arch, 0); 
		leer(arch, cabecera);
		seek(arch, filepos(arch)-1); 
		write(arch, m); 
		
		seek(arch, pos); 
		write(arch, cabecera); 
		 
	end
	else
		write('Municipio no existe'); 
		
	close(arch); 
	writeln();
end; 


{para probar}

procedure crearArchivo(var arch: archivo_municipios); 
var 
	m: municipio; 
begin 
	reset(arch);
	m.cant_habitantes:= 0; 
	write(arch, m); 
	leerMunicipio(m); 
	while (m.nombre<> valor_alto) do begin 
		write(arch,  m); 
		leerMunicipio(m); 
	end; 
	close(arch); 
end; 

procedure exportarATXT(var arch: archivo_municipios); 
var 
	m: municipio; 
	txt: text; 
	nom: string; 
begin 
	Assign(txt, 'municipios.txt'); 
	rewrite(txt); 
	reset (arch); 
	leer(arch, m); 
	leer(arch, m); 
	while (m.nombre <> valor_alto) do begin
		with m do begin 
			writeln(txt, cant_habitantes, extension, anio_creacion, descripcion); 
			writeln(txt, nombre); 
			writeln(txt, '___________________________________________________'); 
		end; 
		leer(arch, m); 
	end; 
	close(arch); 
	close(txt); 
end; 
		
//programa principal
var
	arch: archivo_municipios; 

begin
	Assign(arch, 'archivo_municipios.dat');
	rewrite(arch); 
	close(arch); 
	
	crearArchivo(arch); 
	writeln('ARCHIVO CREADO'); 
	writeln('alta 1'); 
	agregarMunicipio(arch); 
	writeln('alta 2'); 
	agregarMunicipio(arch); 
	writeln('alta 3'); 
	agregarMunicipio(arch); 
	
	writeln('baja 1'); 
	bajaMunicipio(arch); 
	writeln('baja 2');
	bajaMunicipio(arch); 
	exportarATXT(arch); 

end.
