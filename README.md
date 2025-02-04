# Serpientes y Escaleras 🐍

## Descripción
Este proyecto es una implementación en consola del clásico juego de Serpientes y escaleras.
El juego consiste en que dos o más jugadores tiren dados para mover sus fichas por un tablero adornado con serpientes y escaleras.
El objetivo es llegar a la casilla final antes que los oponentes.

## Estructura del proyecto
* `src/Main.java:` Punto de entrada de la aplicación.
* `src/model/Jugador.java:` Representa al Jugador del juego.
* `src/model/Juego.java:` Manejo de lógica y control del juego.
* `src/model/Tablero.java:` Representa el tablero con las serpientes y escaleras.
* `src/utils/Dado.java:` Clase de utilidad para el manejo del dado.

## Como Correr el Proyecto
* Clonar el repositorio.
* Abrir el proyecto en el IDE de su preferencia.
* Ejecute la clase `Main`.
> Notas Adicionales
> 
>  Versión JDK
> Asegúrate de tener instalado JDK 17 o una versión superior. Puedes descargarlo desde el sitio web de Oracle JDK o utilizar una alternativa de código abierto como OpenJDK.
> 
> Salida en Consola
> El juego se ejecutará en la consola. Sigue las instrucciones para jugar.

## Flujo del Juego
1. El juego comienza con los jugadores en la casilla 1.
2. Los jugadores se turnan para tirar los dados y mover sus fichas.
3. Si un jugador cae en la parte inferior de una escalera, pasa a la parte superior de la misma.
4. Si un jugador cae en la cabeza de una serpiente, pasa a la cola de la serpiente.
5. El primer jugador que llegue a la casilla 100 gana el juego.
   
## Tablero Utilizado
![image](https://github.com/user-attachments/assets/497a5204-91a6-490e-a110-5ec3510a5024)

## Tablero en Consola
![image](https://github.com/user-attachments/assets/e723f38b-bbf7-4282-89cb-aa1d83e7cd70)

* `S` reprensenta las serpientes en el tablero con el color rojo
* `E` representa las escaleras en el tablero con el color verde
* `I` represa cuando ambos jugadores estan en la misma casilla con el color amarillo




