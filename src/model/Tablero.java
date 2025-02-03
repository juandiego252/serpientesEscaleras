package model;

import java.util.List;
import java.util.Map;

public class Tablero {

    private int tamanio = 10; // Tablero de 10 x 10
    private Map<Integer, Integer> escaleras;
    private Map<Integer, Integer> serpientes;


    // Constructor para inicializar el tablero
    public Tablero(Map<Integer, Integer> escaleras, Map<Integer, Integer> serpientes) {
        this.escaleras = escaleras;
        this.serpientes = serpientes;
    }

    public Map<Integer, Integer> getEscaleras() {
        return escaleras;
    }

    public Map<Integer, Integer> getSerpientes() {
        return serpientes;
    }

    public void dibujarTablero(List<Jugador> jugadores) {
        int celdasTotales = tamanio * 10; // 10 x 10
        for (int fila = 0; fila < tamanio; fila++) {
            // Filas pares
            if (fila % 2 == 0) {
                for (int col = 0; col < tamanio; col++) {
                    int numeroCelda = celdasTotales - (fila * tamanio + col);
                    imprimirCelda(numeroCelda, jugadores);
                }
            } else {
                // Filas impares
                for (int col = tamanio - 1; col >= 0; col--) {
                    int numeroCelda = celdasTotales - (fila * tamanio + col);
                    imprimirCelda(numeroCelda, jugadores);
                }
            }
            System.out.println();
        }
    }

    private void imprimirCelda(int numeroCelda, List<Jugador> jugadores) {
        String simbolo = "";
        String color = "\u001B[0m"; // Reset color

        boolean igualPosicion = true;
        for (Jugador jugador : jugadores) {
            if (jugador.getPosicion() != numeroCelda) {
                igualPosicion = false;
                break;
            }
        }

        if (igualPosicion && jugadores.size() <= 4) {
            simbolo = "I"; // Representa la igualdad de posiciones
            color = "\u001B[33m";
        } else {
            for (Jugador jugador : jugadores) {
                if (jugador.getPosicion() == numeroCelda) {
                    simbolo = jugador.getNombre().substring(0, 1).toUpperCase(); // Primer Caracter del nombre
                    color = "\u001B[34m"; // Color azul
                    break;
                }
            }

            if (escaleras.containsKey(numeroCelda)) {
                simbolo = "E"; // Representa la Escalera
                color = "\u001B[32m"; // Color verde
            } else if (serpientes.containsKey(numeroCelda)) {
                simbolo = "S"; // Represna la Serpiente
                color = "\u001B[31m"; // Color rojo
            }
        }

        System.out.printf("%3d%s%s\u001B[0m ", numeroCelda, color, simbolo);
    }

    public String obtenerEstadoJugadores(List<Jugador> jugadores) {
        StringBuilder estado = new StringBuilder();
        for (Jugador jugador : jugadores) {
            estado.append(jugador.getNombre())
                    .append(" esta en la posicion ")
                    .append(jugador.getPosicion())
                    .append("\n");
        }
        return estado.toString();
    }

    ;

}
