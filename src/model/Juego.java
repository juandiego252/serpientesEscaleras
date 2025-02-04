package model;

import utils.Dado;

import java.util.List;
import java.util.Scanner;

public class Juego {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Dado dado;
    private int turnoActual;

    // Constructor para inicializar el juego con los jugadores y el tablero
    public Juego(List<Jugador> jugadores, Tablero tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.dado = new Dado();
        this.turnoActual = 0;
    }

    // obtener los jugadores
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    // Metodo para mostrar el estado del juego
    public void mostrarEstadodelJuego() {
        try {
            // Limpiar la consola
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar estado del tablero y los jugadores
        tablero.dibujarTablero(jugadores);
        System.out.println("**********************************************");
        // Mostrar la posicion actual de los jugadores
        System.out.println(tablero.obtenerEstadoJugadores(jugadores));
        System.out.println("**********************************************");
    }


    public void jugarTurno() {

        // Obtener el jugador actual
        Jugador jugadorActual = jugadores.get(turnoActual);
        mostrarEstadodelJuego();

        System.out.println("**********************************************");
        System.out.println("Es el turno de " + jugadorActual.getNombre());
        System.out.println("Presiona Enter para lanzar el dado: ");
        System.out.println("**********************************************");
        new Scanner(System.in).nextLine();

        int resultadoDado = dado.lanzar();
        int nuevaPosicion = jugadorActual.getPosicion() + resultadoDado;

        // Verificar si el jugador se pasa de la casilla 100
        if (nuevaPosicion > 100) {
            System.out.println("No te puedes mover más allá de la casilla 100");
            nuevaPosicion = jugadorActual.getPosicion();
        } else {
            System.out.println("Sacaste un: " + resultadoDado + "! \nTe mueves hacia la casilla " + nuevaPosicion);
            System.out.println("\nPresiona una tecla para moverte");
            new Scanner(System.in).nextLine();
            System.out.println("\n");
            jugadorActual.avanzar(resultadoDado);
            nuevaPosicion = jugadorActual.getPosicion();
        }

        // Verificar si el jugador cayo en una escalera o serpiente
        if (tablero.getEscaleras().containsKey(nuevaPosicion)) {
            nuevaPosicion = tablero.getEscaleras().get(nuevaPosicion);
            System.out.println(jugadorActual.getNombre() + " subio por una escalera a la posicion " + nuevaPosicion);
        } else if (tablero.getSerpientes().containsKey(nuevaPosicion)) {
            nuevaPosicion = tablero.getSerpientes().get(nuevaPosicion);
            System.out.println(jugadorActual.getNombre() + " bajo por una serpiente a la posicion " + nuevaPosicion);
        }

        // Actualizar la posicion del jugador
        jugadorActual.setPosicion(nuevaPosicion);
        // Cambiar al siguiente jugador
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public void iniciarJuego() {
        Jugador gamador = null;
        // Mientras no haya un ganador, seguir jugando
        while (gamador == null) {
            jugarTurno();
            for (Jugador jugador : jugadores) {
                if (jugador.getPosicion() == 100) {
                    gamador = jugador;
                    System.out.println("\n¡" + gamador.getNombre() + " ha ganado el juego!\n");
                    System.out.println("Presiona una tecla para presumir tu victoria!");
                    new Scanner(System.in).nextLine();
                    System.out.println(gamador.getNombre() + " : ¡Soy el mejor!");
                    break;
                }
            }
        }
    }
}
