/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a2bingo;

/**
 * Clase Bingo alternativa con array de booleanos
 * 
 * Estructura de datos:
 * - boolean[] bolasDisponibles: índice 1-90, true = bola no extraída, false = bola que ya ha salido
 * - int bolasRestantes: contador para verificcomprobar inmediatamente si quedan bolas
 * 
 * Direrencias frente a TreeSet:
 * - Acceso rapido para comprobar si una bola ya salió (se accede al elemento del array en tiempo constante)
 * - No es necesario ordenar pues el array ya tiene sus indices ordenados
 * 
 * @author Antonio
 */
import java.util.Random;

public class BingoArray {

    private boolean[] bolasDisponibles; // true = disponible, false = ya ha salido
    private int bolasRestantes;          // bolas que restan por salir
    private Random random;

    public BingoArray() {
        random = new Random();
        iniciarJuego();
    }

    // Inicializa o reinicia el estado del juego con todas las bolas disponibles   
    public void iniciarJuego() {
        bolasDisponibles = new boolean[91]; // truco para no tener que restar cada vez
        // la bola de indice cero no la usamos para nada, por eso disponemos una más
        for (int i = 1; i <= 90; i++) {
            bolasDisponibles[i] = true; // todas las bolas disponibles al empezar
        }
        bolasRestantes = 90;
    }

    // Extrae una bola aleatoria que no haya salido todavía
    public int obtenerBola() {
        if (bolasRestantes == 0) {
            return -1;
        }
        // se itera hasta encontrar una bola que todavía no ha salido
        int bola;
        do {
            bola = random.nextInt(90) + 1;
        } while (!bolasDisponibles[bola]); // mientras ya haya salido
        
        bolasDisponibles[bola] = false; // marcar como extraída
        bolasRestantes--;
        return bola;
    }

    // Comprueba si todos los números indicados han sido extraídos
   
    public boolean comprobarLineaBingo(String numeros) {
        String[] partes = numeros.split(",");
        for (String parte : partes) {
            int num = Integer.parseInt(parte.trim()); // por si hay espacios junto a la coma
            // Si es true la bola no ha salido todavía
            if (bolasDisponibles[num]) {
                return false;
            }
        }
        return true;
    }

    // Devuelve una cadena con las bolas ya extraídas, ordenadas ascendentemente
    // en este caso se complica respecto a la clase de Set donde solo es sacar las bolas ordenadas
    public String mostrarBolas() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean primera = true;
        
        // Recorremos el array en orden natural
        for (int i = 1; i <= 90; i++) {
            if (!bolasDisponibles[i]) { // en bolas ya salidas es false
                if (!primera) { // para que no ponga una coma delante de la primera bola
                    sb.append(", ");
                }
                sb.append(i);
                primera = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
