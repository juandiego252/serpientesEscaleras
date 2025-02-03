package model;

public class Jugador {
    private String nombre;
    private int posicion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 1;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void avanzar(int espacios) {
        posicion += espacios;
    }
}
