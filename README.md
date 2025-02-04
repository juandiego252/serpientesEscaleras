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
  
#### Jugador
![image](https://github.com/user-attachments/assets/01dc5051-915d-4276-9f99-b38f5b97d6ce)

Es posble elegir hasta 4 jugadores al iniciar el juego y se representan con la Inicial de sus Nombres

![image](https://github.com/user-attachments/assets/27f33c98-0488-46c1-9e58-a53aa2801bc6)

![image](https://github.com/user-attachments/assets/8c6e45ba-20a9-4cc7-be33-5d3cfce79405)


Cuando un jugador cae en una escalera se presenta un mensaje con la posición a la cual llego.
![image](https://github.com/user-attachments/assets/474d5090-515e-4ef2-be33-7fcb487bcdd8)

Cuando un jugador cae en una serpiente se presenta un mensaje con la posición a la cual llego.
![image](https://github.com/user-attachments/assets/18a4d64e-f5c5-411c-908b-e8a45717e60a)



Cuando un jugador gana el juego se presenta el siguiente mensaje.

![image](https://github.com/user-attachments/assets/e28f53b8-10b2-4716-9cdc-b6a1246ef245)


## Pruebas US y UATs
### US1 - Mover la ficha por el tablero
Como jugador quiero poder mover mi ficha para acercarme a la meta.
**UAT1** Dado que el juego ha comenzado cuando la ficha se coloca en el tablero, entonces la ficha está en la casilla 1
![image](https://github.com/user-attachments/assets/2524316e-aef0-4b45-b022-7da9d4f76dee)
> Todos los jugadores comienzan en la casilla 1 y a medida en que tiren el dado pueden acercarse a la meta

**UAT2** Dado que  la ficha está en la casilla 1, cuando la ficha se mueve 3 espacio, entonces la fichara está en la casilla 4
![image](https://github.com/user-attachments/assets/569625ed-96aa-4967-8803-3a585e6d6dd9)

**UAT3** Dado que la ficha está en la casilla 1, cuando la ficha se mueve 3 espacios y luego se mueve 4 espacios entonces la ficha está en la casilla 8
![image](https://github.com/user-attachments/assets/9a680851-82b1-468f-9242-14db3d595ba5)
> El jugador Diego saco el número 6, Diego se encuentra en la posicion 1 es decir avanza a la posicion 7 donde se encuentra una escalera y sube a la posicion 14

### US2 - El jugador puede ganar el juego
Como jugador quiero poder ganar el juego y presumir ante todos
![image](https://github.com/user-attachments/assets/e28f53b8-10b2-4716-9cdc-b6a1246ef245)

**UAT1** Dado que la ficha está en la casilla 97 cuando la ficha se mueve 3 espacios entonces la ficha está en la casilla 100 y el jugador ha ganado el juego
![image](https://github.com/user-attachments/assets/5c8df1ef-e84f-48eb-b3a1-de5f895a6435)
> El Jugador Diego se encuentra en la posicion 96 al tirar el dado saca un 4 esto le permite avanzar a la posicion 100 y ganar el juego.

![image](https://github.com/user-attachments/assets/2daf8ac9-249f-491d-8550-7fa910232b8d)
> Cuando el jugador está cerca de llegar a la posicion 100 pero al tirar el dado saco un numero mayor que excede la posicion 100, se muestra un mensaje y la posicion del jugador se mantiene igual y continua con el turno del siguiente jugador.

### US3 - Los movimientos son determinados por el lanzamiento del dado.
Como jugador quiero mover mi ficha basándome en el lanzamiento de un dado para que haya un elemento de azar en el juego
![image](https://github.com/user-attachments/assets/19e936fc-ce4f-4df2-8fab-f30c578a98f1)

**UAT1** Dado que el juego ha comenzado cuando el jugador lanza un dado entonces el resultado debe estar entre (1-6)
![image](https://github.com/user-attachments/assets/6d6643dc-9259-4ac7-941d-96af05e355be)
> El metodo `lanzar` asegura que los valores entre 1 y 6 sean aleatorios.





