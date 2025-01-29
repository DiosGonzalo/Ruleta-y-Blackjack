package models;

public class Blackjack { // Pablo García María

	private int[] cartasUsuario;
	private int[] cartasDealer;
	private int apostado;

	public Blackjack(int[] cartasDealer, int[] cartasUsuario) { // Pablo García María
		this.cartasDealer = cartasDealer;
		this.cartasUsuario = cartasUsuario;
	}

	public int getApostado() {
		return apostado;
	}

	public void setApostado(int apostado) {
		this.apostado = apostado;
	}

	public int[] getCartasUsuario() {
		return cartasUsuario;
	}

	public void setCartasUsuario(int[] cartasUsuario) {
		this.cartasUsuario = cartasUsuario;
	}

	public int[] getCartasDealer() {
		return cartasDealer;
	}

	public void setCartasDealer(int[] cartasDealer) {
		this.cartasDealer = cartasDealer;
	}

}
