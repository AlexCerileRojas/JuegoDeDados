package org.example;

public class Dado {
	private int cara;

	public int lanzar() {
		cara = (int)(Math.random() * 6) + 1; // Genera un valor aleatorio entre 1 y 6
		return cara;
	}

	public int getCaraSuperior() {
		return cara;
	}

	public void setCaraSuperior(int cara) {
		this.cara = cara;
	}
}
