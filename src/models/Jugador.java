package models;

public class Jugador { // Principalmente Hugo carmona, con algunas cosas hechas por Pablo Garcia
    private double saldo; // Pablo García María
    private String nombre; // Hugo Carmona Jiménez
    private String contrasenia; // Hugo Carmona Jiménez

    public Jugador(String nombre, String contrasenia, double saldo) {// Pablo García María
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Jugador [saldo=" + saldo + ",nombre=" + nombre + ", contrasenia=" + contrasenia + "]";
    }

    public double getSaldo() {// Pablo García María
        return saldo;
    }

    public void setSaldo(double saldo) {// Pablo García María
        this.saldo = saldo;
    }

    public String getNombre() {// Hugo Carmona Jiménez
        return nombre;
    }

    public void setNombre(String nombre) {// Hugo Carmona Jiménez
        this.nombre = nombre;
    }

    public String getContrasenia() {// Hugo Carmona Jiménez
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {// Hugo Carmona Jiménez
        this.contrasenia = contrasenia;
    }

}
