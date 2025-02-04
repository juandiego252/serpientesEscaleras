package model;

import java.util.List;
import java.util.Map;

public class Tablero {

    private int tamanio = 10; // Tablero de 10 x 10
    private Map<Integer, Integer> escaleras;
    private Map<Integer, Integer> serpientes;


    // Constructor para inicializar el tablero con las serpientes y escaleras
    public Tablero(Map<Integer, Integer> escaleras, Map<Integer, Integer> serpientes) {
        this.escaleras = escaleras;
        this.serpientes = serpientes;
    }

    // Getters para obtener las serpientes y escaleras
    public Map<Integer, Integer> getEscaleras() {
        return escaleras;
    }

    public Map<Integer, Integer> getSerpientes() {
        return serpientes;
    }

    public void dibujarTablero(List<Jugador> jugadores) {
        System.out.println();
        int celdasTotales = tamanio * 10; // 100 celdas

        // Recorre cada fila del tablero
        for (int fila = 0; fila < tamanio; fila++) {
            // Si la fila es par se recorre de izquierda a derecha
            if (fila % 2 == 0) {
                for (int col = 0; col < tamanio; col++) {
                    // Calcula el numero de la celda actual
                    int numeroCelda = celdasTotales - (fila * tamanio + col);
                    // Imprime la celda con el numero y los judadores en esa posicion
                    imprimirCelda(numeroCelda, jugadores);
                }
            } else {
                // Si la fila es impar se recorre de derecha a izquierda
                for (int col = tamanio - 1; col >= 0; col--) {
                    // Calcula el numero de la celda actual
                    int numeroCelda = celdasTotales - (fila * tamanio + col);
                    // Imprime la celda con el numero y los judadores en esa posicion
                    imprimirCelda(numeroCelda, jugadores);
                }
            }
            System.out.println();
        }

    }

    private void imprimirCelda(int numeroCelda, List<Jugador> jugadores) {
        String simbolo = " ";
        String color = "\u001B[0m"; // Reset color

        boolean igualPosicion = true;
        // Verifica si todos los jugadores estan en la misma posicion
        for (Jugador jugador : jugadores) {
            if (jugador.getPosicion() != numeroCelda) {
                igualPosicion = false;
                break;
            }
        }

        if (igualPosicion && jugadores.size() <= 4) {
            simbolo = "I"; // Representa la igualdad de posiciones
            color = "\u001B[33m"; // Color amarillo
        } else {
            // Verifica si hay jugadores en la celda actual
            for (Jugador jugador : jugadores) {
                if (jugador.getPosicion() == numeroCelda) {
                    simbolo = jugador.getNombre().substring(0, 1).toUpperCase(); // Primer Caracter del nombre
                    color = "\u001B[34m"; // Color azul
                    break;
                }
            }

            // Verifica si hay una escalera o serpiente en la celda actual
            if (escaleras.containsKey(numeroCelda)) {
                simbolo = "E"; // Representa la Escalera
                color = "\u001B[32m"; // Color verde
            } else if (serpientes.containsKey(numeroCelda)) {
                simbolo = "S"; // Represna la Serpiente
                color = "\u001B[31m"; // Color rojo
            }
        }

        System.out.printf("%3d%s%s\u001B[0m |", numeroCelda, color, simbolo);
    }

    public String obtenerEstadoJugadores(List<Jugador> jugadores) {
        // Crea un StringBuilder para almacenar el estado de los jugadores
        StringBuilder estado = new StringBuilder();
        // Recorre cada jugador y obtiene su estado
        for (Jugador jugador : jugadores) {
            estado.append(jugador.getNombre())
                    .append(" esta en la casilla: ")
                    .append(jugador.getPosicion())
                    .append("\n");
        }
        return estado.toString();
    }

}
