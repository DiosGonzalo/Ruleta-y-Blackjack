package crud;

import models.Casino;
import models.Jugador;

public class CrudCasino { // Hecho por Hugo Carmona y Pablo garcia

    private Casino casino;

    public CrudCasino(Casino casino) {
        this.casino = casino;
    }

    public void anadirJugador(Jugador jugadorObjetivo) { // Pablo García María
        Jugador jugadores[] = casino.getJugadores();
        boolean annadido = false;
        for (int i = 0; i < jugadores.length && !annadido; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = jugadorObjetivo;
                annadido = true;
            }
        }
    }

    public Jugador buscarJugadorNombre(String nombre) { // Hugo Carmona
        Jugador jugadorEncontrado = null;
        boolean encontrado = false;
        for (int i = 0; i < casino.getJugadores().length && casino.getJugadores()[i] != null && !encontrado; i++) {
            if (casino.getJugadores()[i].getNombre().equals(nombre)) {
                jugadorEncontrado = casino.getJugadores()[i];
                encontrado = true;
            }
        }
        return jugadorEncontrado;
    }

    public boolean comprobarDisponibilidad() { // Pablo García María
        boolean disponible = false;
        Jugador[] jugadores = casino.getJugadores();
        for (int i = 0; i < jugadores.length && !disponible; i++) {
            if (jugadores[i] == null) {
                disponible = true;
            }
        }
        return disponible;
    }

    public int findPositionByName(String nombre) { // Hugo Carmona
        int posicionJugador = -1; // Hugo Carmona
        boolean encontrado = false; // Hugo Carmona
        for (int i = 0; i < casino.getJugadores().length && !encontrado; i++) { // Hugo Carmona
            if (casino.getJugadores()[i].getNombre().equalsIgnoreCase(nombre)) { // Hugo Carmona
                posicionJugador = i; // Hugo Carmona
                encontrado = true; // Hugo Carmona
            } // Hugo Carmona
        } // Hugo Carmona
        return posicionJugador; // Hugo Carmona
    }

    public void eliminarUsuario(String nombre) { // Hugo Carmona
        Jugador[] jugadores = casino.getJugadores(); // Hugo Carmona
        jugadores[findPositionByName(nombre)] = null; // Hugo Carmona
        casino.setJugadores(jugadores); // Hugo Carmona
    }

    public void annadirSaldo(int annadir) { // Hugo Carmona
        casino.setSaldo(casino.getSaldo() + annadir);
    }

}
