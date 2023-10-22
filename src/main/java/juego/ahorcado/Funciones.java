package juego.ahorcado;

public class Funciones {
 /* Función que devuelve un String y que usaremos para dibujar al ahorcado. */
	public static String dibujarAhorcado(byte i) {
		String dibujo = "";
		
		switch(i) {
		case 1:
			dibujo += ("_____   \n"); 
			dibujo += ("|   |   \n");
			dibujo += ("|   ☹️  \n");
			dibujo += ("|       \n");
			dibujo += ("|       \n");
			dibujo += ("|_______");
			break;
		case 2:
			dibujo += ("_____   \n");
			dibujo += ("|   |   \n");
			dibujo += ("|  \\☹️  \n");
			dibujo += ("|       \n");
			dibujo += ("|       \n");
			dibujo += ("|_______");
			break;
		case 3:
			dibujo += ("_____   \n"); 
			dibujo += ("|   |   \n");
			dibujo += ("|  \\☹️/ \n");
			dibujo += ("|       \n");
			dibujo += ("|       \n");
			dibujo += ("|_______");
			break;
		case 4:
			dibujo += ("_____   \n");
			dibujo += ("|   |   \n");
			dibujo += ("|  \\☹️/ \n");
			dibujo += ("|   |   \n");
			dibujo += ("|       \n");
			dibujo += ("|_______");
			break;
		case 5:
			dibujo += ("_____   \n");
			dibujo += ("|   |   \n");
			dibujo += ("|  \\☹️/ \n");
			dibujo += ("|   |   \n");
			dibujo +=("|  /    \n");
			dibujo +=("|_______");
			break;
		case 6:
			dibujo += ("_____   \n");
			dibujo += ("|   |   \n");
			dibujo += ("|  \\☹️/ \n");
			dibujo += ("|   |   \n");
			dibujo += ("|  / \\  \n");
			dibujo += ("|_______");
			break;
		}
		
		return dibujo;
	}
}