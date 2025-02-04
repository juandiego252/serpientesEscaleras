import model.Juego;
import model.Jugador;
import model.Tablero;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Configuración de serpientes y escaleras;
        Map<Integer, Integer> escaleras = Map.ofEntries(
                Map.entry(2, 38), Map.entry(7, 14), Map.entry(8, 31), Map.entry(15, 26),
                Map.entry(21, 42), Map.entry(28, 84), Map.entry(36, 44), Map.entry(51, 67),
                Map.entry(71, 91), Map.entry(78, 98), Map.entry(87, 94)
        );
        // Serpientes y sus posiciones
        Map<Integer, Integer> serpientes = Map.of(
                16, 6, 46, 25, 49, 11, 62, 19, 64, 60,
                74, 53, 89, 68, 92, 88, 95, 75, 99, 80
        );

        // Crear Tablero
        Tablero tablero = new Tablero(escaleras, serpientes);

        // Crear Jugadores
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Martin");

        // Crear Juego
        Juego juego = new Juego(List.of(jugador1, jugador2), tablero);

        // Iniciar juego
        juego.iniciarJuego();
    }
}