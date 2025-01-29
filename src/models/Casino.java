package models;

public class Casino { // Pablo García María
    private Jugador[] jugadores; // Pablo García María
    private double saldo; // Pablo García María

    public Casino(Jugador[] jugadores, double saldo) {
        this.jugadores = jugadores;
        this.saldo = saldo;
    }

    public Jugador[] getJugadores() { // Pablo García María
        return jugadores;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setJugadores(Jugador[] jugadores) { // Pablo García María
        this.jugadores = jugadores;
    }

    public String toString() { // Pablo García María
        return "Jugadores: " + jugadores + "Saldo casino: " + saldo;
    }

}
