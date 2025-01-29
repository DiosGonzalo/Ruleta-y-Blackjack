package controller;

import java.util.Random;

import crud.CrudCasino;
import models.*;
import data.DatosRuleta;

public class ControllerRuleta { // Hecho principalmente por Gonzalo Dios
    private Jugador jugador;
    private CrudCasino crudCasino;

    public ControllerRuleta(Jugador jugador, CrudCasino crudCasino) {
        this.jugador = jugador;
        this.crudCasino = crudCasino;
    }

    public void mostrarOpcionesGanadas() { // Pablo García María
        boolean usado = false;
        for (int i = 0; i < DatosRuleta.getOpcionesJugadasNombre().length; i++) {
            if (DatosRuleta.getOpcionesJugadas()[i] != 0 || DatosRuleta.getOpcionesJugadasAntiguas()[i] != 0) {
                if (!usado) {
                    System.out.printf("""
                            ╔═══════════════════════════════════════╗
                            ║   Desglose de ganancias/pérdidas      ║
                            ╚═══════════════════════════════════════╝
                            """);
                    usado = true;
                }
                if (DatosRuleta.getOpcionesJugadas()[i] == 0) {
                    System.out.printf("El usuario apostó %d al %s, y los perdió. \n",
                            DatosRuleta.getOpcionesJugadasAntiguas()[i], DatosRuleta.getOpcionesJugadasNombre()[i]);
                } else {
                    System.out.printf("El usuario apostó %d al %s, y ganó: +%d. \n",
                            DatosRuleta.getOpcionesJugadasAntiguas()[i], DatosRuleta.getOpcionesJugadasNombre()[i],
                            DatosRuleta.getOpcionesJugadas()[i] - DatosRuleta.getOpcionesJugadasAntiguas()[i]);
                }

            }
        }
    }

    public int generarRandom() {// Gonzalo Dios
        int hasta = 37;
        int desde = 0;
        Random rnd = new Random(System.nanoTime());
        return rnd.nextInt(hasta - desde + 1) + desde;
    }

    public void restablecer() {// Gonzalo Dios
        for (int i = 0; i < DatosRuleta.getOpcionesJugadas().length; i++) {
            DatosRuleta.insertarOpcionJugada(i, 0);
        }

        for (int i = 0; i < DatosRuleta.getOpcionesJugadas().length; i++) {
            DatosRuleta.insertarOpcionJugada(i, 0);
        }
    };

    public int generarPremiado() {// Gonzalo Dios

        int premiado = generarRandom();
        if ((premiado % 2) == 0) {
            DatosRuleta.insertarOpcionJugada(0,
                    DatosRuleta.getOpcionesJugadas()[0] * DatosRuleta.getMultiplicadores()[0]);
            DatosRuleta.insertarOpcionJugada(1, 0);
        } else {
            DatosRuleta.insertarOpcionJugada(1,
                    DatosRuleta.getOpcionesJugadas()[1] * DatosRuleta.getMultiplicadores()[1]);
            DatosRuleta.insertarOpcionJugada(0, 0);
        }
        
        if (premiado > 0 && premiado <= 12) {
            DatosRuleta.insertarOpcionJugada(2,
                    DatosRuleta.getOpcionesJugadas()[2] * DatosRuleta.getMultiplicadores()[2]);
            DatosRuleta.insertarOpcionJugada(3, 0);
            DatosRuleta.insertarOpcionJugada(4, 0);

        } else if (premiado > 12 && premiado <= 24) {
            DatosRuleta.insertarOpcionJugada(3,
                    DatosRuleta.getOpcionesJugadas()[3] * DatosRuleta.getMultiplicadores()[3]);
            DatosRuleta.insertarOpcionJugada(2, 0);
            DatosRuleta.insertarOpcionJugada(4, 0);

        } else if (premiado > 24 && premiado <= 37) {
            DatosRuleta.insertarOpcionJugada(4,
                    DatosRuleta.getOpcionesJugadas()[4] * DatosRuleta.getMultiplicadores()[4]);
            DatosRuleta.insertarOpcionJugada(3, 0);
            DatosRuleta.insertarOpcionJugada(2, 0);
        }
        
        if (premiado > 0 && premiado < 19) {

            DatosRuleta.insertarOpcionJugada(43,
                    DatosRuleta.getOpcionesJugadas()[43] * DatosRuleta.getMultiplicadores()[43]);
            DatosRuleta.insertarOpcionJugada(44, 0);
        } else if (premiado > 18 && premiado <= 37) {
            DatosRuleta.insertarOpcionJugada(44,
                    DatosRuleta.getOpcionesJugadas()[44] * DatosRuleta.getMultiplicadores()[44]);
            DatosRuleta.insertarOpcionJugada(43, 0);
        }
        
        for (int i = 0; i <= 37; i++) {
            if (premiado == i) {
                DatosRuleta.insertarOpcionJugada(i + 5,
                        DatosRuleta.getOpcionesJugadas()[i + 5] * DatosRuleta.getMultiplicadores()[i + 5]);
            } else {
                DatosRuleta.insertarOpcionJugada(i + 5, 0);
            }
        }

        return premiado;
    }

    public void apostarRojoNegro(int seleccion, int apostado) {// Gonzalo Dios

        if (seleccion == 1) { // NEGRO
            data.DatosRuleta.insertarOpcionJugada(0, apostado);

        } else if (seleccion == 2) { // ROJO
            data.DatosRuleta.insertarOpcionJugada(1, apostado);
        }
        jugador.setSaldo(jugador.getSaldo() - apostado);
        crudCasino.annadirSaldo(apostado);

    }

    public void apostarTercios(int seleccion, int apostado) {// Gonzalo Dios
        if (seleccion == 1) {
            data.DatosRuleta.insertarOpcionJugada(2, apostado);
        } else if (seleccion == 2) {
            data.DatosRuleta.insertarOpcionJugada(3, apostado);
        } else if (seleccion == 3) {
            data.DatosRuleta.insertarOpcionJugada(4, apostado);
        }
        jugador.setSaldo(jugador.getSaldo() - apostado);
        crudCasino.annadirSaldo(apostado);

    }

    public void apostarNumero(int seleccion, int apostado) {// Gonzalo Dios
        System.out.printf("Has apostado %d al %s", apostado,
                data.DatosRuleta.getOpcionesJugadasNombre()[seleccion + 5]);
        data.DatosRuleta.insertarOpcionJugada(seleccion + 5, apostado);
        System.out.println(DatosRuleta.getOpcionesJugadas()[37 + 5]);
        jugador.setSaldo(jugador.getSaldo() - apostado);
        System.out.println(jugador.getSaldo());
        crudCasino.annadirSaldo(apostado);
    }

    public void apostarMitades(int seleccion, int apostado) {// Gonzalo Dios
        if (seleccion == 1) {
            DatosRuleta.insertarOpcionJugada(43, apostado);
        } else if (seleccion == 2) {
            DatosRuleta.insertarOpcionJugada(44, apostado);
        }
        jugador.setSaldo(jugador.getSaldo() - apostado);
        crudCasino.annadirSaldo(apostado);
    }
}
