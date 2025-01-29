package data;

import models.Jugador;

public class DatosPrincipal { // Hecho por Pablo García

    private static Jugador jugadorInicializado = new Jugador("admin", "admin", 1000);

    public static Jugador getJugadorInicializado() {
        return jugadorInicializado;
    }

}