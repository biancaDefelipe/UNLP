program ejercicio1; 

const
	orden=
type 
	alumno= record
		apnom: string; 
		dni: integer; 
		legajo: integer; 
		ingreso: integer; 
	end; 

	nodo= record 
		elementos : array [1..orden] of alumno; 
		hijos :array[0..orden ]of ^nodo;
		cantElem:integer;
	end;
	
	arbol=file of nodo;
