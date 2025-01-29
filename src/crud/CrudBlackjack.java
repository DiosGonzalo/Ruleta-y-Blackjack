package crud;

import controller.ControllerBlackjack;
import data.Datos_BlackJack;
import models.*;

public class CrudBlackjack { // Hecho por Hugo Carmona

	private Blackjack blackjack;

	public CrudBlackjack(Blackjack blackjack) { // Hugo Carmona
		this.blackjack = blackjack;
	};

	public int buscarUltimaCarta(boolean objetivo) { // Hugo Carmona
		// Objetivo True = Usuario.
		// Objetivo False = Dealer.
		int posicion = -1;
		boolean encontrado = false;
		int[] cartas;

		if (objetivo) {
			cartas = blackjack.getCartasUsuario();
		} else {
			cartas = blackjack.getCartasDealer();
		}

		for (int i = 0; i < cartas.length && !encontrado; i++) {
			if (cartas[i] == 0) {
				posicion = i;
				encontrado = true;
			}
		}

		return posicion;
	}

	public void mostrarCartas(boolean objetivo) { // Hugo Carmona
		// True = usuario
		// False = dealer
		int cartas[];
		ControllerBlackjack controllerBlackjack = new ControllerBlackjack(blackjack);

		if (objetivo) {
			cartas = blackjack.getCartasUsuario();
		} else {
			cartas = blackjack.getCartasDealer();
		}

		for (int i = 0; i < cartas.length && cartas[i] != 0; i++) {
			System.out.printf(" %s	", Datos_BlackJack.getNombres()[cartas[i]]);
		}

		System.out.printf("( %d )	", controllerBlackjack.calcularValor(objetivo));
	}
}
