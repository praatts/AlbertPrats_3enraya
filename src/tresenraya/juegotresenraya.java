package tresenraya;
import java.util.Scanner;
import java.util.Random;
public class juegotresenraya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		char j1 = 'O';
		char j2 = 'X';
		char vacio = '-';
		
		System.out.println("Bienvenido al 3 en raya \nJugador 1: 'O' \nJugador 2: 'X' \nCasilla vacía: '-' \n");
		
		String jugadorInicial;
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("Jugador 1, introduzca su nombre:");
		String jugador1 = s.nextLine();
		
		System.out.println("Jugador 2, introduzca su nombre:");
		String jugador2 = s.nextLine();
		
		
		int moneda = r.nextInt(2) + 1;
		
		System.out.println(jugador1 + ", cara o cruz?");
		String eleccionj1 = s.nextLine().toLowerCase();
		
		System.out.println(jugador2 + ", cara o cruz?");
		String eleccionj2 = s.nextLine().toLowerCase();
		
		
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
		
		System.out.println("Se ha lanzado la moneda!");
		
		String caracruz = Integer.toString(moneda);
		
		switch (caracruz) {
		
		case "1":
			System.out.println("Ha salido cara!");
			if (eleccionj1.equals("cara")) {
				System.out.println("Empieza " + jugador1);
				jugadorInicial = jugador1;
			} else {
				System.out.println("Empieza " + jugador2);
				jugadorInicial = jugador2;
			}
			break;
		
		case "2":
			System.out.println("Ha salido cruz!");
			if (eleccionj1.equals("cruz")) {
				System.out.println("Empieza " + jugador1);
				jugadorInicial = jugador1;
			} else {
				System.out.println("Empieza " + jugador2);
				jugadorInicial = jugador2;
			}
			break;
		} 
		
		
		
		
		
	}

}
