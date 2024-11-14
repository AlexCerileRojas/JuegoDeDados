package org.example;

public class JuegoDeDados {
	private Dado dado1;
	private Dado dado2;
	private Calculadora calculadora;

	public JuegoDeDados() {
		dado1 = new Dado();  // Crea los dados
		dado2 = new Dado();
		calculadora = new Calculadora();  // Crea la calculadora
	}

	public void jugar() {
		int resultadoDado1 = dado1.lanzar();  // Lanza el primer dado
		int resultadoDado2 = dado2.lanzar();  // Lanza el segundo dado

		// Suma los resultados de los dos dados usando la calculadora
		int suma = calculadora.sumar(resultadoDado1, resultadoDado2);

		System.out.println("La suma de los dados es: " + suma);

		if (suma == 7) {
			System.out.println("Has ganado");
		} else {
			System.out.println("Has perdido, la suma no es 7.");
		}
	}
}

