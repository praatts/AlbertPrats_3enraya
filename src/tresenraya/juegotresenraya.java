package tresenraya;

import java.util.Scanner;
import java.util.Random;

public class juegotresenraya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables para determinar el carácter que usará cada jugador
		int contadorJugadas = 0;
		String jugadorInicial;
		String segundoJugador;
		int fila = 0;
		int columna = 0;
		boolean partidaFinalizada = false;
		boolean quererRevancha = false;
		boolean juegoTerminado = false;
		String ganador = "";
		String revanchaJI = "";
		String revanchaSJ;
		Scanner s = new Scanner(System.in);
		Scanner e = new Scanner(System.in);
		Random r = new Random();

		System.out.println("Bienvenido al 3 en raya \nJugador 1: 'O' \nJugador 2: 'X' \nCasilla vacía: '-' \n");

		// Pide a los jugadores sus nombres

		System.out.println("Jugador 1, introduzca su nombre:");
		String jugador1 = s.nextLine();

		System.out.println("Jugador 2, introduzca su nombre:");
		String jugador2 = s.nextLine();

		// Random que simula una moneda.
		int moneda = r.nextInt(2) + 1;

		// Pide a los jugadores que cara de la moneda quieren.
		System.out.println(jugador1 + ", cara o cruz?");
		String eleccionj1 = s.nextLine().toLowerCase();

		System.out.println(jugador2 + ", cara o cruz?");
		String eleccionj2 = s.nextLine().toLowerCase();

		// Bucle que comprueba que la eleccion de ambos jugadores no es igual para poder
		// avanzar.
		int elecionIgual = 1;

		while (elecionIgual == 1) {

			if (eleccionj2.equals(eleccionj1)) {
				System.out.println(
						"Opción inválida, ya ha sido seleccionada por " + jugador1 + " introduzca la otra opción");
				eleccionj2 = s.nextLine().toLowerCase();
				elecionIgual = 1;
			} else {
				elecionIgual = 0;
			}

		}
		
		moneda = 2;


		// Switch-case que determina quien es el jugador inicial comparando la elección
		// introducida con la generada por la 'moneda'

		System.out.println("Se ha lanzado la moneda!");

		switch (moneda) {

		case 1:
			
			//Indica lo que ha salido en la moneda e indica que jugador empieza.

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

			// Muestra el tablero
			char[][] tablero1 = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
			while (!quererRevancha) {
				if (!partidaFinalizada) {
					System.out.println("Tablero inicial");

					for (int i = 0; i < tablero1.length; i++) {
						for (int j = 0; j < tablero1[i].length; j++) {
							System.out.print(tablero1[i][j] + " ");
						}
						System.out.println();
					}

				}
				
				//Bucle que inicia la partida


				while (!partidaFinalizada) {

					//Pregunta ficha al jugador inicial
					
					System.out.println(jugadorInicial + " donde quieres situar tu ficha?");
					System.out.println("Fila (1-3): ");
					fila = s.nextInt() - 1;
					System.out.println("Columna (1-3): ");
					columna = s.nextInt() - 1;

					if (tablero1[fila][columna] == '-') {
						tablero1[fila][columna] = 'O';
					} else {
						System.out.println("La posición introducida ya está ocupada, vuelva a seleccionar la posición");
						System.out.println("Fila (1-3): ");
						fila = s.nextInt() - 1;
						System.out.println("Columna (1-3): ");
						columna = s.nextInt() - 1;
						
					}
					
					//Actualiza el tablero

					System.out.println("Tablero actualizado");
					for (int i = 0; i < tablero1.length; i++) {
						for (int j = 0; j < tablero1[i].length; j++) {
							System.out.print(tablero1[i][j] + " ");
						}

						System.out.println();
					}
					
					//Condicional con las posibles formas de ganar del jugador inicial

					if (tablero1[0][0] == 'O' && tablero1[0][1] == 'O' && tablero1[0][2] == 'O'
							|| tablero1[1][0] == 'O' && tablero1[1][1] == 'O' && tablero1[1][2] == 'O'
							|| tablero1[2][0] == 'O' && tablero1[2][1] == 'O' && tablero1[2][2] == 'O'
							|| tablero1[0][0] == 'O' && tablero1[1][0] == 'O' && tablero1[2][0] == 'O'
							|| tablero1[0][1] == 'O' && tablero1[1][1] == 'O' && tablero1[2][1] == 'O'
							|| tablero1[0][2] == 'O' && tablero1[1][2] == 'O' && tablero1[2][2] == 'O'
							|| tablero1[0][0] == 'O' && tablero1[1][1] == 'O' && tablero1[2][2] == 'O'
							|| tablero1[2][0] == 'O' && tablero1[1][1] == 'O' && tablero1[0][2] == 'O') {

						System.out.println(jugadorInicial + " ha ganado!");
						partidaFinalizada = true;
						ganador = jugadorInicial;
					} else {

						contadorJugadas++;
						//Muestra mensaje de empate en caso de rellenar el tablero y finaliza la partida
						if (contadorJugadas == 9) {
							System.out.println("Habéis empatado!");
							partidaFinalizada = true;

						} else {
							//Pregunta ficha al segundo jugador si no finaliza en empate.
							System.out.println(segundoJugador + " donde quieres situar tu ficha?");
							System.out.println("Fila (1-3): ");
							fila = s.nextInt() - 1;
							System.out.println("Columna (1-3): ");
							columna = s.nextInt() - 1;

							if (tablero1[fila][columna] == '-') {
								tablero1[fila][columna] = 'X';
							} else {
								System.out.println(
										"La posición introducida ya está ocupada, vuelva a seleccionar la posición");
								System.out.println("Fila (1-3): ");
								fila = s.nextInt() - 1;
								System.out.println("Columna (1-3): ");
								columna = s.nextInt() - 1;

							}

							//Actualiza el tablero
							System.out.println("Tablero actualizado");
							for (int i = 0; i < tablero1.length; i++) {
								for (int j = 0; j < tablero1[i].length; j++) {
									System.out.print(tablero1[i][j] + " ");
								}

								System.out.println();
							}
							
							//Condicional con todas las posibles formas de ganar del segundo jugador

							if (tablero1[0][0] == 'X' && tablero1[0][1] == 'X' && tablero1[0][2] == 'X'
									|| tablero1[1][0] == 'X' && tablero1[1][1] == 'X' && tablero1[1][2] == 'X'
									|| tablero1[2][0] == 'X' && tablero1[2][1] == 'X' && tablero1[2][2] == 'X'
									|| tablero1[0][0] == 'X' && tablero1[1][0] == 'X' && tablero1[2][0] == 'X'
									|| tablero1[0][1] == 'X' && tablero1[1][1] == 'X' && tablero1[2][1] == 'X'
									|| tablero1[0][2] == 'X' && tablero1[1][2] == 'X' && tablero1[2][2] == 'X'
									|| tablero1[0][0] == 'X' && tablero1[1][1] == 'X' && tablero1[2][2] == 'X'
									|| tablero1[2][0] == 'X' && tablero1[1][1] == 'X' && tablero1[0][2] == 'X') {

								System.out.println(segundoJugador + " ha ganado!");
								partidaFinalizada = true;
								ganador = segundoJugador;
							}

							contadorJugadas++;

						}

					}
					
					//Condicional que pregunta a ambos jugadores si quieren revancha

					if (!ganador.equals("") || contadorJugadas == 9) {

						System.out.println(jugadorInicial + " ,quieres revancha? (Si / No)");
						revanchaJI = e.nextLine().toLowerCase();

						if (revanchaJI.equals("no")) {
							
							juegoTerminado = true;
						} else if (revanchaJI.equals("si")) {
							System.out.println(segundoJugador + " ,quieres revancha? (Si / No)");
							revanchaSJ = e.nextLine().toLowerCase();
							if (revanchaSJ.equals("si")) {
								partidaFinalizada = false;
								contadorJugadas = 0;
								ganador = "";
								tablero1 = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
								juegoTerminado = false;
							} else {
								partidaFinalizada = true;
								quererRevancha = false;
								juegoTerminado = true;
							}
						}
					}
				}	
				
				//Finaliza el juego
				
				if (juegoTerminado) {
					System.out.println("Habéis salido del juego, gracias por jugar!");
					juegoTerminado = false;
					partidaFinalizada = true;
					quererRevancha = false;
					break;
				}
			}
			
			break;
			

		case 2:
			
			//Indica lo que ha salido en la moneda e indica que jugador empieza.
			System.out.println("Ha salido cruz!");
			if (eleccionj1.equals("cruz")) {
				System.out.println("Empieza " + jugador1);
				jugadorInicial = jugador1;
				segundoJugador = jugador2;

			} else {
				System.out.println("Empieza " + jugador2);
				jugadorInicial = jugador2;
				segundoJugador = jugador1;
			}

			// Muestra el tablero
			char[][] tablero2 = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
			while (!quererRevancha) {
				if (!partidaFinalizada) {
					System.out.println("Tablero inicial");

					for (int i = 0; i < tablero2.length; i++) {
						for (int j = 0; j < tablero2[i].length; j++) {
							System.out.print(tablero2[i][j] + " ");
						}
						System.out.println();
					}

				}

				//Bucle que inicia la partida
				
				while (!partidaFinalizada) {
					
					//Pide al jugador introducir la ficha.

					System.out.println(jugadorInicial + " donde quieres situar tu ficha?");
					System.out.println("Fila (1-3): ");
					fila = s.nextInt() - 1;
					System.out.println("Columna (1-3): ");
					columna = s.nextInt() - 1;

					if (tablero2[fila][columna] == '-') {
						tablero2[fila][columna] = 'O';
					} else {
						System.out.println("La posición introducida ya está ocupada, vuelva a seleccionar la posición");
						System.out.println("Fila (1-3): ");
						fila = s.nextInt() - 1;
						System.out.println("Columna (1-3): ");
						columna = s.nextInt() - 1;
						
					}
					
					//Actualiza el tablero,

					System.out.println("Tablero actualizado");
					for (int i = 0; i < tablero2.length; i++) {
						for (int j = 0; j < tablero2[i].length; j++) {
							System.out.print(tablero2[i][j] + " ");
						}

						System.out.println();
					}

					//Comprueba opciones posibles para que gane el jugador inicial.
					
					if (tablero2[0][0] == 'O' && tablero2[0][1] == 'O' && tablero2[0][2] == 'O'
							|| tablero2[1][0] == 'O' && tablero2[1][1] == 'O' && tablero2[1][2] == 'O'
							|| tablero2[2][0] == 'O' && tablero2[2][1] == 'O' && tablero2[2][2] == 'O'
							|| tablero2[0][0] == 'O' && tablero2[1][0] == 'O' && tablero2[2][0] == 'O'
							|| tablero2[0][1] == 'O' && tablero2[1][1] == 'O' && tablero2[2][1] == 'O'
							|| tablero2[0][2] == 'O' && tablero2[1][2] == 'O' && tablero2[2][2] == 'O'
							|| tablero2[0][0] == 'O' && tablero2[1][1] == 'O' && tablero2[2][2] == 'O'
							|| tablero2[2][0] == 'O' && tablero2[1][1] == 'O' && tablero2[0][2] == 'O') {

						System.out.println(jugadorInicial + " ha ganado!");
						partidaFinalizada = true;
						ganador = jugadorInicial;
					} else {

						contadorJugadas++;

						//Finaliza la partida si el contador de fichas puestas es 9, mostrando mensaje de empate.
						
						if (contadorJugadas == 9) {
							System.out.println("Habéis empatado!");
							partidaFinalizada = true;

						//Si no se rellena el tablero, pregunta al segundo jugador donde poner la ficha.	
							
						} else {

							System.out.println(segundoJugador + " donde quieres situar tu ficha?");
							System.out.println("Fila (1-3): ");
							fila = s.nextInt() - 1;
							System.out.println("Columna (1-3): ");
							columna = s.nextInt() - 1;

							if (tablero2[fila][columna] == '-') {
								tablero2[fila][columna] = 'X';
							} else {
								System.out.println(
										"La posición introducida ya está ocupada, vuelva a seleccionar la posición");
								System.out.println("Fila (1-3): ");
								fila = s.nextInt() - 1;
								System.out.println("Columna (1-3): ");
								columna = s.nextInt() - 1;

							}

							//Actualiza el tablero después de introducir una ficha
							System.out.println("Tablero actualizado");
							for (int i = 0; i < tablero2.length; i++) {
								for (int j = 0; j < tablero2[i].length; j++) {
									System.out.print(tablero2[i][j] + " ");
								}

								System.out.println();
							}
							
							//Comprueba todas las posibles opciones para ganar y asigna ganador al segundo jugador

							if (tablero2[0][0] == 'X' && tablero2[0][1] == 'X' && tablero2[0][2] == 'X'
									|| tablero2[1][0] == 'X' && tablero2[1][1] == 'X' && tablero2[1][2] == 'X'
									|| tablero2[2][0] == 'X' && tablero2[2][1] == 'X' && tablero2[2][2] == 'X'
									|| tablero2[0][0] == 'X' && tablero2[1][0] == 'X' && tablero2[2][0] == 'X'
									|| tablero2[0][1] == 'X' && tablero2[1][1] == 'X' && tablero2[2][1] == 'X'
									|| tablero2[0][2] == 'X' && tablero2[1][2] == 'X' && tablero2[2][2] == 'X'
									|| tablero2[0][0] == 'X' && tablero2[1][1] == 'X' && tablero2[2][2] == 'X'
									|| tablero2[2][0] == 'X' && tablero2[1][1] == 'X' && tablero2[0][2] == 'X') {

								System.out.println(segundoJugador + " ha ganado!");
								partidaFinalizada = true;
								ganador = segundoJugador;
							}

							contadorJugadas++;

						}

					}

					//Condicional que pregunta a ambos jugadores si quieren revancha
					
					if (!ganador.equals("") || contadorJugadas == 9) {

						System.out.println(jugadorInicial + " ,quieres revancha? (Si / No)");
						revanchaJI = e.nextLine().toLowerCase();

						if (revanchaJI.equals("no")) {
							
							juegoTerminado = true;
						} else if (revanchaJI.equals("si")) {
							System.out.println(segundoJugador + " ,quieres revancha? (Si / No)");
							revanchaSJ = e.nextLine().toLowerCase();
							if (revanchaSJ.equals("si")) {
								partidaFinalizada = false;
								contadorJugadas = 0;
								ganador = "";
								tablero1 = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
								juegoTerminado = false;
							} else {
								partidaFinalizada = true;
								quererRevancha = false;
								juegoTerminado = true;
							}
						}
					}
				}	
				
				//Finaliza el juego
				
				if (juegoTerminado) {
					System.out.println("Habéis salido del juego, gracias por jugar!");
					juegoTerminado = false;
					partidaFinalizada = true;
					quererRevancha = false;
					
					break;
				}
			}
			
			break;
		}

	}

}
