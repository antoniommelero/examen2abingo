/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package a2bingo;

import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class A2Bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        Scanner teclado = new Scanner(System.in);
        boolean jugar = true;
        System.out.println("BINGO IES Juan Bosco");
        final String MENSAJE = "[0-Salir  1-Siguiente bola  2-Comprobar linea/bingo  3-Nueva partida]";

        while (jugar) {
            int bola = bingo.obtenerBola();

            if (bola == -1) {
                System.out.println("¡Se han agotado todas las bolas!");
                break;
            }

            System.out.println("Bola: " + bola);
            System.out.println("Bolas salidas: " + bingo.mostrarBolas());
            System.out.println(MENSAJE);

            int opcion = -1;
            try {
                opcion = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                //System.out.println("Opcion no valida, continua el juego...");
                opcion = -1;
            }

            switch (opcion) {
                case 0:
                    jugar = false;
                    System.out.println("Fin del juego.");
                    break;
                case 1:
                    // Continúa el bucle, se extrae la siguiente bola
                    break;
                case 2:
                    System.out.print("Introduce los numeros a comprobar (ej: 5,17,34,52,71): ");
                    String linea = teclado.nextLine().trim();
                    try {
                        boolean resultado = bingo.comprobarLineaBingo(linea);
                        System.out.println(resultado ? "¡Línea/Bingo correcto!" : "Alguno de los numeros no es correcto.");
                    } catch (NumberFormatException e) {
                        System.out.println("Formato incorrecto. Solo numeros separados por comas.");
                    }
                    // Vuelve a pedir opción sin extraer nueva bola
                    System.out.println(MENSAJE);
                    try {
                        opcion = Integer.parseInt(teclado.nextLine().trim());
                        if (opcion == 0) {
                            jugar = false;
                        } else if (opcion == 3) {
                            bingo.iniciarJuego();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Opcion no válida, continuando...");
                    }
                    break;
                case 3:
                    bingo.iniciarJuego();
                    System.out.println("¡Nueva partida iniciada!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        teclado.close();
    }
}
