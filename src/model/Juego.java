package model;

import utils.Dado;

import java.util.List;
import java.util.Scanner;

public class Juego {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Dado dado;
    private int turnoActual;

    public Juego(List<Jugador> jugadores, Tablero tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.dado = new Dado();
        this.turnoActual = 0;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    //    public void jugarTurno(Jugador jugador) {
//        int resultadoDado = dado.lanzar();
//        System.out.println(jugador.getNombre() + " lanzo el dado y obtuvo:" + resultadoDado);
//        jugador.avanzar(resultadoDado);
//
//        int nuevaPosicion = jugador.getPosicion();
//        if (tablero.getEscaleras().containsKey(nuevaPosicion)) {
//            nuevaPosicion = tablero.getEscaleras().get(nuevaPosicion);
//            System.out.println(jugador.getNombre() + "subio por una escalera a la posicion" + nuevaPosicion);
//        } else if (tablero.getSerpientes().containsKey(nuevaPosicion)) {
//            nuevaPosicion = tablero.getSerpientes().get(nuevaPosicion);
//            System.out.println(jugador.getNombre() + "bajo por una serpiente a la posicion" + nuevaPosicion);
//        }
//
//        jugador.setPosicion(nuevaPosicion);
//    }
    public void mostrarEstadodelJuego() {
        try {
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
        System.out.println(tablero.obtenerEstadoJugadores(jugadores));
        System.out.println("**********************************************");
    }

    ;

    public void jugarTurno() {
        Jugador jugadorActual = jugadores.get(turnoActual);
        mostrarEstadodelJuego();
        System.out.println("Es el turno de " + jugadorActual.getNombre());
        System.out.println("Presiona Enter para lanzar el dado");
        new Scanner(System.in).nextLine();
        System.out.println("**********************************************");
        int resultadoDado = dado.lanzar();
        int nuevaPosicion = jugadorActual.getPosicion() + resultadoDado;

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

        if (tablero.getEscaleras().containsKey(nuevaPosicion)) {
            nuevaPosicion = tablero.getEscaleras().get(nuevaPosicion);
            System.out.println(jugadorActual.getNombre() + " subio por una escalera a la posicion " + nuevaPosicion);
        } else if (tablero.getSerpientes().containsKey(nuevaPosicion)) {
            nuevaPosicion = tablero.getSerpientes().get(nuevaPosicion);
            System.out.println(jugadorActual.getNombre() + " bajo por una serpiente a la posicion " + nuevaPosicion);
        }

        jugadorActual.setPosicion(nuevaPosicion);
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public void iniciarJuego() {
        while (jugadores.stream().noneMatch(jugador -> jugador.getPosicion() == 100)) {
            jugarTurno();
        }
        Jugador ganador = jugadores.stream().max((j1, j2) -> Integer.compare(j1.getPosicion(), j2.getPosicion())).orElse(null);
        if (ganador != null) {
            System.out.println("\n¡" + ganador.getNombre() + " ha ganado el juego!\n");
            System.out.println("Presiona una tecla para presumir tu victoria!");
            new Scanner(System.in).nextLine();
            System.out.println(ganador.getNombre() + " : GG Izi");
        }
    }
}
