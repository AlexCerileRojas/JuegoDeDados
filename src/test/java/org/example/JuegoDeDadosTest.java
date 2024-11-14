package org.example;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

class JuegoDeDadosTest {

    @Test
    void testJuegoVictoria() throws NoSuchFieldException, IllegalAccessException {
        // Creamos los mocks de Dado y Calculadora (para que no use el random)
        Dado dadoMock1 = mock(Dado.class);
        Dado dadoMock2 = mock(Dado.class);
        Calculadora calculadoraMock = mock(Calculadora.class);


        when(dadoMock1.lanzar()).thenReturn(3);  // Simulamos que el dado 1 lanza un 3
        when(dadoMock2.lanzar()).thenReturn(4);  // Simulamos que el dado 2 lanza un 4
        when(calculadoraMock.sumar(3, 4)).thenReturn(7);  // Simulamos que la calculadora suma 7


        JuegoDeDados juego = new JuegoDeDados();

        // Usamos reflexión para inyectar los mocks en los campos privados
        Field dado1Field = JuegoDeDados.class.getDeclaredField("dado1");
        dado1Field.setAccessible(true);
        dado1Field.set(juego, dadoMock1);  // Inyectamos el mock de dado1

        Field dado2Field = JuegoDeDados.class.getDeclaredField("dado2");
        dado2Field.setAccessible(true);
        dado2Field.set(juego, dadoMock2);  // Inyectamos el mock de dado2

        Field calculadoraField = JuegoDeDados.class.getDeclaredField("calculadora");
        calculadoraField.setAccessible(true);
        calculadoraField.set(juego, calculadoraMock);  // Inyectamos el mock de la calculadora

        // Llamamos al metodo jugar
        juego.jugar();

        // Verificamos que el comportamiento esperado ocurra
        verify(dadoMock1).lanzar();  // Verificamos que se haya llamado al lanzar() del dado 1
        verify(dadoMock2).lanzar();  // Verificamos que se haya llamado al lanzar() del dado 2
        verify(calculadoraMock).sumar(3, 4);  // Verificamos que se haya llamado al sumar() con los valores 3 y 4
    }

    @Test
    void testJuegoDerrota() throws NoSuchFieldException, IllegalAccessException {
        // Creamos los mocks de Dado y Calculadora
        Dado dadoMock1 = mock(Dado.class);
        Dado dadoMock2 = mock(Dado.class);
        Calculadora calculadoraMock = mock(Calculadora.class);

        // Configuramos el comportamiento esperado de los mocks
        when(dadoMock1.lanzar()).thenReturn(2);  // Simulamos que el dado 1 lanza un 2
        when(dadoMock2.lanzar()).thenReturn(3);  // Simulamos que el dado 2 lanza un 3
        when(calculadoraMock.sumar(2, 3)).thenReturn(5);  // Simulamos que la calculadora suma 5

        // Creamos el objeto JuegoDeDados
        JuegoDeDados juego = new JuegoDeDados();

        // Usamos reflexión para inyectar los mocks en los campos privados
        Field dado1Field = JuegoDeDados.class.getDeclaredField("dado1");
        dado1Field.setAccessible(true);
        dado1Field.set(juego, dadoMock1);

        Field dado2Field = JuegoDeDados.class.getDeclaredField("dado2");
        dado2Field.setAccessible(true);
        dado2Field.set(juego, dadoMock2);

        Field calculadoraField = JuegoDeDados.class.getDeclaredField("calculadora");
        calculadoraField.setAccessible(true);
        calculadoraField.set(juego, calculadoraMock);

        // Llamamos al metodo jugar
        juego.jugar();

        // Verificamos que el comportamiento esperado ocurra
        verify(dadoMock1).lanzar();  // Verificamos que se haya llamado al lanzar() del dado 1
        verify(dadoMock2).lanzar();  // Verificamos que se haya llamado al lanzar() del dado 2
        verify(calculadoraMock).sumar(2, 3);  // Verificamos que se haya llamado al sumar() con los valores 2 y 3
    }
}
