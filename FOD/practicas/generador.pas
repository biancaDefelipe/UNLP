program generador;
const
  dimF = 100;
  
type
  regMaestro = record
    destino: string;
    fecha: string;
    horaSalida: string;
    asientosDisp: integer;
  end;

  registro = record
    destino: string;
    fecha: string;
    horaSalida: string;
    asientosComp: integer;
  end;
  
  archivo = file of registro;
  maestro = file of regMaestro;
  
  vArchivos = array [0..dimF] of archivo;


procedure cargarArchivo(var arch: archivo; var seguir: boolean);
var
  reg: registro;
begin
  writeln('Ingrese los datos del detalle ("fin" para terminar): ');
  readln(reg.destino);
  
  if(reg.destino <> 'fin') then begin
    readln(reg.fecha); readln(reg.horaSalida); readln(reg.asientosComp);
    
    write(arch, reg);
  end
  else
	seguir:= false;
end;


procedure cargarMaestro(var maes: maestro);
var
  reg: regMaestro;
begin
  writeln('Ingrese los datos del maestro ("fin" para terminar): ');
  readln(reg.destino);
  
  while(reg.destino <> 'fin') do begin
    readln(reg.fecha); readln(reg.horaSalida); readln(reg.asientosDisp);
    
    write(maes, reg);
    
    writeln('Ingrese los datos del maestro ("fin" para terminar): ');
    readln(reg.destino);
  end;  
end;


var
  vArch: vArchivos; maes: maestro;
  i: integer; i_str: string; seguir: boolean;
begin
  Assign(maes, 'Log_Vuelos');
  Rewrite(maes);
  
  cargarMaestro(maes);
  
  close(maes);
  
  i:= 0;
  seguir:= true;
  
  while (i < dimF) and (seguir) do begin
    Str(i, i_str);
    Assign(vArch[i], 'log_0' + i_str);
    writeln('-- log_0', i_str, ' --');
    Rewrite(vArch[i]);
    
    cargarArchivo(vArch[i], seguir);
    
    close(vArch[i]);
    i:= i + 1;
  end;
end.
