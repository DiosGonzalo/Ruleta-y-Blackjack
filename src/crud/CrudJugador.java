package crud;

import models.Jugador;

public class CrudJugador { // Hecho por Hugo Carmona
    private Jugador jugador;

    public CrudJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean comprobarApuesta(int apostado) {
        boolean posible = true;
        if (jugador.getSaldo() < apostado) {
            posible = false;
        }
        return posible;
    }

    public void annadirSaldo(int annadir) { // Hugo Carmona
        jugador.setSaldo(jugador.getSaldo() + annadir); // Hugo Carmona
    }

    public void modificarNombre(String nombre) { // Hugo Carmona
        jugador.setNombre(nombre);
    }

    public void modificarContraseña(String contrasenia) { // Hugo Carmona
        jugador.setContrasenia(contrasenia);
    }

}
