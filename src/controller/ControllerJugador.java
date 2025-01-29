package controller;

import models.*;

public class ControllerJugador { // Hecho por Pablo García

    private Jugador jugador;

    public ControllerJugador(Jugador jugador) { // Pablo García María
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}