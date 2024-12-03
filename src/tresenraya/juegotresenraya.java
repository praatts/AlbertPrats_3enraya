package tresenraya;
import java.util.Scanner;
import java.util.Random;
public class juegotresenraya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Variables para determinar el carácter que usará cada jugador
		char j1 = 'O';
		char j2 = 'X';
		String jugadorInicial;
		String segundoJugador;
		int fila = 0;
		int columna = 0;
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("Bienvenido al 3 en raya \nJugador 1: 'O' \nJugador 2: 'X' \nCasilla vacía: '-' \n");
		
		//Pide a los jugadores sus nombres
		
		System.out.println("Jugador 1, introduzca su nombre:");
		String jugador1 = s.nextLine();
		
		System.out.println("Jugador 2, introduzca su nombre:");
		String jugador2 = s.nextLine();
		
		//Random que simula una moneda.
		int moneda = r.nextInt(2) + 1;
		
		
		//Pide a los jugadores que cara de la moneda quieren.
		System.out.println(jugador1 + ", cara o cruz?");
		String eleccionj1 = s.nextLine().toLowerCase();
		
		System.out.println(jugador2 + ", cara o cruz?");
		String eleccionj2 = s.nextLine().toLowerCase();
		
		
		//Bucle que comprueba que la eleccion de ambos jugadores no es igual para poder avanzar.
		int elecionIgual = 1;
		
		while (elecionIgual == 1) {
			
			if (eleccionj2.equals(eleccionj1)) {
				System.out.println("Opción inválida, ya ha sido seleccionada por " + jugador1 + " introduzca la otra opción");
				eleccionj2 = s.nextLine().toLowerCase();
				elecionIgual = 1;
			} else {
				elecionIgual = 0;
			}
		
		}
		
		moneda = 1;
		
		//Switch-case que determina quien es el jugador inicial comparando la elección introducida con la generada por la 'moneda'
		
		System.out.println("Se ha lanzado la moneda!");
		
		
		switch (moneda) {
		
		case 1:
			System.out.println("Ha salido cara!");
			if (eleccionj1.equals("cara")) {
				System.out.println("Empieza " + jugador1);
				jugadorInicial = jugador1;
				segundoJugador = jugador2;
				
			} else {
				System.out.println("Empieza " + jugador2);
				jugadorInicial = jugador2;
				segundoJugador = jugador1;
			}
			
			//Muestra el tablero
			
			char[][] tablero = {{'-','-','-'},
								{'-','-','-'},
								{'-','-','-'}};
			
			System.out.println("Tablero inicial");
			
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					System.out.print(tablero[i][j] + " ");
				}
				
				System.out.println();
			}
			
			
			System.out.println(jugadorInicial + " donde quieres situar tu ficha?");
			System.out.println("Fila (1-3): ");
			fila = s.nextInt() - 1;
			System.out.println("Columna (1-3): ");
			columna = s.nextInt() - 1;
			
			if (tablero[fila][columna] == '-') {
				tablero[fila][columna] = 'X';
			}
			
			System.out.println("Tablero actualizado");
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					System.out.print(tablero[i][j] + " ");
				}
				
				System.out.println();
			}
			
			break;
		
		case 2:
			System.out.println("Ha salido cruz!");
			if (eleccionj1.equals("cruz")) {
				System.out.println("Empieza " + jugador1);
				jugadorInicial = jugador1;
				segundoJugador = jugador2;
			} else {
				System.out.println("Empieza " + jugador2);
				jugadorInicial = jugador2;
				
			}
			break;
		} 
		
		
		
		
		
		
	}

}
