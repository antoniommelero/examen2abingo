# Examen 2A bingo
Examen de programación 25 de marzo de 2026 ejercicio 2 del modelo A
***

En esta práctica modelarás el funcionamiento de una máquina de bingo. El bingo tradicional utiliza bolas numeradas del 1 al 90 que se extraen de forma aleatoria, una a una y **sin repetición** (cuando una bola ya ha salido no puede volver a salir), hasta que algún jugador canta línea o bingo.

**Clase que debes implementar: Bingo**

***

Decide que estructura de datos vas a usar, pensando que no todas son igual de eficientes para lo que se pretende.

**Métodos:**

**1. iniciarJuego()**

Prepara el juego para una nueva partida. Debe dejar todas las bolas disponibles (del 1 al 90) listas para ser extraídas, descartando cualquier estado anterior.

**2. obtenerBola()**

Extrae una bola al azar de entre las disponibles y la registra como ya salida. Garantiza que ningún número se repita a lo largo de la partida.

-   Si quedan bolas disponibles, devuelve el número extraído.
-   Si ya se han sacado todas las bolas, devuelve -1.

**3. comprobarLineaBingo(String numeros)**

Recibe un String con números separados por comas (formato CSV) y comprueba si todos esos números han salido ya durante la partida.

-   Devuelve true si todos los números del String han sido extraídos previamente.
-   Devuelve false si alguno de ellos aún no ha salido.

Ejemplo de llamada:

bingo.comprobarLineaBingo("5,17,34,52,71");

**4. mostrarBolas()**

Devuelve un String con todas las bolas que han salido hasta ahora separadas por comas. Saldrán en orden ascendente de número. Ejemplo: [3, 14, 31, 42, 43, 68, 81, 89]

**Programa principal**

***

El programa principal hará uso de la clase Bingo desarrollada.

Al comenzar llama al método de la clase para inicializar los datos.

A continuación va sacando bolas en bucle y tras cada extracción de bola premiada muestra en pantalla el número y pide una entrada de teclado (un entero)

Si se pulsa 0 termina el juego sin más.

Si se pulsa 1 continua con la extracción de la siguiente bola.

Si se pulsa 2 pide un String para comprobar si se ha producido una linea/bingo correcto. Tras llamar al método correspondiente de la clase informará del resultado y vuelve a pedir la entrada de opción.

Si se pulsa 3 comienza una nueva partida.

**Justificacion de estructuras de datos**

| *Antes del código, incluye un comentario en la cabecera de la clase donde expliques:*<br>*Que estructura o estructuras del framework Collections has utilizado.*<br>*Por qué esa estructura es adecuada para cada caso (bolas disponibles, bolas ya extraídas).*<br>*No es imprescindible almacenar todas las bolas disponibles, pero si al menos todas las que han salido para poder hacer las comprobaciones.* |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

**Restricciones**

***

-   No se pueden usar arrays primitivos (int[]) como estructura principal de almacenamiento.
-   Debes usar al menos una clase del framework Collections (java.util.\*).
-   El código debe compilar y no lanzar excepciones durante un uso normal.
