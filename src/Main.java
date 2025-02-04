import model.Juego;
import model.Jugador;
import model.Tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de serpientes y escaleras!");

        // Solicitar el número de jugadores
        int numeroJugadores = 0;
        while (numeroJugadores < 1 || numeroJugadores > 4) {
            System.out.println("Ingrese el número de jugadores (1-4): ");
            numeroJugadores = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            if (numeroJugadores < 1 || numeroJugadores > 4) {
                System.out.println("El número de jugadores debe ser entre 1 y 4.");
            }
        }
        // Crear lista de jugadores
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador" + (i+1) + ":");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre));
        }
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

        // Crear Juego
        Juego juego = new Juego(jugadores, tablero);

        // Iniciar juego
        juego.iniciarJuego();
    }
}