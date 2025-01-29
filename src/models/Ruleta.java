package models;

public class Ruleta { // Gonzalo Dios

    private Jugador jugador; // Gonzalo Dios
    private int[] opcionesApostadas; // Gonzalo Dios

    public void setJugador(Jugador jugador) {// Gonzalo Dios
        this.jugador = jugador;
    }

    public Jugador getJugador() {// Gonzalo Dios
        return jugador;
    }

    public void setOpcionesApostadas(int[] opcionesApostadas) {// Gonzalo Dios
        this.opcionesApostadas = opcionesApostadas;
    }

    public int[] getOpcionesApostadas() {// Gonzalo Dios
        return opcionesApostadas;
    }
}
