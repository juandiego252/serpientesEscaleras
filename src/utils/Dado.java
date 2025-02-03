package utils;

import java.util.Random;

public class Dado {
    private Random random = new Random();

    public int lanzar() {
        return random.nextInt(6) + 1;
    }
}
