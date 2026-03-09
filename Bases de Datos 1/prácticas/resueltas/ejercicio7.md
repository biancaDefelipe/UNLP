# Ejercicio 7

## 7.	Indique si las siguientes afirmaciones sobre triggers son verdaderas o falsas. Justifique las falsas.

---
 **a. Un trigger se ejecuta únicamente cuando se inserta una fila en una tabla**
FALSO. El trigger puede ser activado por tres tipos de operaciones: INSERT (inserción), UPDATE (actualización) o DELETE (eliminación). La operación que dispara el trigger se define al crearlo.

---
**b. Un trigger puede ejecutarse antes o después de la operación, esto es definido automáticamente según el tipo de la operación (UPDATE, INSERT o DELETE)**
FALSO.  El momento en que se activa el trigger (BEFORE o AFTER) es una elección que se indica mediante {BEFORE | AFTER} en la definición del trigger, no es un comportamiento definido automáticamente por el tipo de operación (INSERT | UPDATE | DELETE)

---

**c. Todo trigger debe asociarse a una tabla en concreto.**

VERDADERO. Un disparador (trigger) es un objeto con nombre dentro de una base de datos el cual se asocia con una tabla


**d. NEW y OLD son palabras clave que permiten acceder a los valores de las filas afectadas y se pueden usar ambos independientemente de la operación utilizada.**

FALSO. Aunque NEW y OLD son palabras clave que permiten acceder a los valores de las filas afectadas, no se usan ambas independientemente de la operación:
* OLD se refiere a un registro existente que va a borrarse o que va a actualizarse antes de que esto ocurra. Una columna OLD es de solo lectura y requiere privilegios de SELECT.
* NEW se refiere a un registro nuevo que se insertará o a un registro modificado luego de que ocurre la modificación. Una columna NEW requiere privilegio de SELECT

---
**e. FOR EACH ROW en un trigger se usa para indicar que el trigger se ejecutará una vez por cada fila afectada por la operación.**

VERDADERO