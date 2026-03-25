/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a2bingo;

/**
 *
 * @author Antonio
 */
/*
 * Clase Bingo
 *
 * Estructura de datos
 * - TreeSet<Integer> bolasSalidas: única estructura necesaria.
 *   Almacena las bolas ya extraídas, ordenadas según el orden natural de Integer.
 *   - contains() permite comprobar eficientemente si una bola ya salió,
 *     tanto en obtenerBola() como en comprobarLineaBingo().
 *   - Al estar ordenado, mostrarBolas() no requiere ningún paso adicional de ordenación.
 *
 * No es necesario almacenar las bolas disponibles explícitamente. En su lugar, obtenerBola()
 * genera números aleatorios entre 1 y 90 hasta encontrar uno que no esté en bolasSalidas.
 * Con pocas bolas extraídas el coste es mínimo; solo aumenta al final de la partida,
 * cuando quedan muy pocas bolas, pero sigue siendo aceptable para 90 bolas en total.
 * Además en condiciones normales de juego no se llegan a agotar las bolas pues termina al haber un ganador
 */

import java.util.Random;
import java.util.TreeSet;

public class Bingo {

    private TreeSet<Integer> bolasSalidas;
    private Random random;

    public Bingo() {
        random = new Random();
        iniciarJuego();
    }

    // 1. Iniciar juego: resetea el estado
    public void iniciarJuego() {
        bolasSalidas = new TreeSet<>();
    }

    // 2. Extrae una bola aleatoria que no haya salido todavía
    public int obtenerBola() {
        if (bolasSalidas.size() == 90) return -1;
        int bola;
        do {
            bola = random.nextInt(90) + 1;
        } while (bolasSalidas.contains(bola));
        bolasSalidas.add(bola);
        return bola;
    }

    // 3. Comprueba si todos los números del String han salido
    public boolean comprobarLineaBingo(String numeros) {
        String[] partes = numeros.split(",");
        for (String parte : partes) {
            int num = Integer.parseInt(parte.trim());
            if (!bolasSalidas.contains(num)) return false;
        }
        return true;
    }

    // 4. Devuelve las bolas salidas ordenadas como String
    public String mostrarBolas() {
        return bolasSalidas.toString();
    }
}