package juego.ahorcado;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JuegoAhorcado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		final byte intentos = 6; // Número máximo de intentos.
		byte errores = 0; // Contador de errores.
		String[] palabras = { "cenec", "boni", "rodolfo", "pandas", "java", "pelona", "examen", "alicia" };
		String palabraAleatoria = palabras[r.nextInt(palabras.length)]; // Palabra aleatoria del array palabras.
		char[] letrasPalabra = new char[palabraAleatoria.length()]; // Letras que contiene la palabra.
		char letraRespuesta = ' '; // Letra que introducimos por teclado.
		boolean palabraAcertada = false;

	 /* Inicializamos el array letrasPalabra con guiones que representan las letras no adivinadas. */
		for (byte i = 0; i < letrasPalabra.length; i++) {
			letrasPalabra[i] = '-';
		}

	 /* Mostramos un mensaje de bienvenida. */
		JOptionPane.showMessageDialog(null, "¡Bienvenid@ al juego del ahorcado! Debes adivinar la palabra secreta.",
				"Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);

		do {
			String respuesta; 
			boolean esLetra = false; 

			while (!esLetra) {
			 /* Le pedimos al jugador que introduzca una letra. Su respuesta se almacena en la variable 
			    respuesta. */
				respuesta = JOptionPane.showInputDialog("Palabra secreta: " + new String(letrasPalabra)
						+ "\nIntentos restantes: " + (intentos - errores) + ".\n" + "\nIntroduce una letra:");

			 /* Si el jugador pulsa en Cancelar, se muestra un mensaje y el programa se cierra. */
				if (respuesta == null) {
					JOptionPane.showMessageDialog(null, "Has decidido abandonar el juego.", "Juego cancelado",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0); // Para terminar la ejecución del juego.
				}

				respuesta = respuesta.trim().toLowerCase();
			 /* Usamos trim para eliminar espacios en blanco y toLowerCase para solucionar el problema de 
			    mayúsculas y minúsculas. */
				
			 /* Verificamos si la respuesta tiene longitud 1 y si es una letra. Si es así, salimos del bucle. */
				if (respuesta.length() == 1) {
					letraRespuesta = respuesta.charAt(0);
					
					if (Character.isLetter(letraRespuesta)) {
						esLetra = true;
					}
				}
				
			 /* Si la respuesta no es válida, se muestra un mensaje de advertencia. */
				if (!esLetra) {
					JOptionPane.showMessageDialog(null, "Debes introducir una única letra válida.",
							"Entrada no válida", JOptionPane.WARNING_MESSAGE);
				}
			}

		 /* Si la palabra secreta contiene la letra introducida por teclado, recorremos el array letrasRespuesta y 
		    sustituimos los guiones por dicha letra donde corresponda. */
			if (palabraAleatoria.contains("" + letraRespuesta)) {
				for (byte i = 0; i < letrasPalabra.length; i++) {
					if (letraRespuesta == palabraAleatoria.charAt(i)) {
						letrasPalabra[i] = letraRespuesta;
					}
				}
			} else {
			 /* Si la letra no está en la palabra secreta, incrementamos el contador de errores y mostramos un 
			    mensaje junto con una representación gráfica del ahorcado. */
				errores++;

				JOptionPane.showMessageDialog(null, "La palabra no contiene esa letra.\n" 
						+ Funciones.dibujarAhorcado(errores), "¡Has fallado!", JOptionPane.ERROR_MESSAGE);
			}

		 /* Usando copyValueOf, convertimos el array letrasPalabra en un String para poder compararlo con la 
		    palabra secreta. */
			String lp = String.copyValueOf(letrasPalabra); 

			if (lp.equals(palabraAleatoria)) {
				palabraAcertada = true;
			}

		} while (errores < intentos && !palabraAcertada);

		if (palabraAcertada) {
		 /* Si el jugador adivina la palabra secreta, se muestra un mensaje de victoria. */
			JOptionPane.showMessageDialog(null, "¡Has ganado!\n" + "La palabra era: " + palabraAleatoria + ".",
					"¡Victoria!", JOptionPane.INFORMATION_MESSAGE);
		} else {
		 /* Si el jugador se queda sin intentos, se muestra un mensaje de derrota. */
			JOptionPane.showMessageDialog(null, "¡Has perdido!\n" + "La palabra era: " + palabraAleatoria + ".",
					"GAME OVER", JOptionPane.INFORMATION_MESSAGE);
		}

		sc.close();
	}
}