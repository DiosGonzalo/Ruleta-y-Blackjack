package controller;

import java.util.Random;

import crud.CrudBlackjack;
import data.Datos_BlackJack;
import models.*;

public class ControllerBlackjack { // Hecho por Pablo García María

	private Blackjack blackjack;

	public ControllerBlackjack(Blackjack blackjack) {
		this.blackjack = blackjack;
	}

	public void darCarta(boolean objetivo) { // Pablo García María
		// Objetivo True = Usuario.
		// Objetivo False = Dealer.
		int posicion;
		int[] cartas;
		CrudBlackjack crudBlackjack = new CrudBlackjack(blackjack);

		posicion = crudBlackjack.buscarUltimaCarta(objetivo);

		if (objetivo) {
			cartas = blackjack.getCartasUsuario();
			cartas[posicion] = generarNuevaCarta();
			blackjack.setCartasUsuario(cartas);
		} else {
			cartas = blackjack.getCartasDealer();
			cartas[posicion] = generarNuevaCarta();
			blackjack.setCartasDealer(cartas);
		}

	}

	public int calcularValor(boolean objetivo) { // Pablo García María
		// Objetivo True = Usuario.
		// Objetivo False = Dealer.
		int[] cartas;
		int posicionA = 1, numA = 0, barrierA = 11, valorA = 11, valorCartas = 0;
		boolean reCheck = false;

		if (objetivo) {
			cartas = blackjack.getCartasUsuario();
		} else {
			cartas = blackjack.getCartasDealer();
		}

		valorCartas = 0;
		for (int i = 0; i < cartas.length && cartas[i] != 0; i++) {
			if (cartas[i] == posicionA) {
				reCheck = true;
				numA++;
			}
			valorCartas += Datos_BlackJack.getValores()[cartas[i]];
		}

		if (reCheck) {
			valorCartas = 0;
			for (int i = 0; i < cartas.length; i++) {
				if (cartas[i] != posicionA) {
					valorCartas += Datos_BlackJack.getValores()[cartas[i]];
				}
			}

			valorA = 11;
			for (int i = 0; i < numA; i++) {
				if (valorCartas >= barrierA) {
					valorA = 1;
				}

				valorCartas += valorA;
			}
		}

		return valorCartas;

	}

	public int generarNuevaCarta() { // Pablo García María
		int max, min = 1;
		Random rnd = new Random(System.nanoTime());
		max = Datos_BlackJack.getNombres().length - 1;
		return rnd.nextInt(max - min + 1) + 1;
	}
}
