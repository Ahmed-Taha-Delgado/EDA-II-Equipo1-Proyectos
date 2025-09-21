import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase principal en la que se va a implementar la ejecución y comparación de los algoritmos de ordenamiento
 * Va a generar arreglos de distintos tamaños con números aleatorios, ejecuta 13 algoritmos de ordenamiento diferentes,
 * cuenta el número de operaciones de cada uno, promedia los resultados y finalmente va a mostrar una
 * interfaz gráfica para visualizar la eficiencia de los algoritmos
 */
public class Principal {

    /**
     * Define los tamaños de los arreglos a ordenar, ejecuta los algoritmos 5 veces para cada tamaño
     * para obtener un promedio de operaciones, y luego inicializa la ventana de la gráfica
     * con los resultados
     */
    public static void main(String[] args) {
        
        int[] elementos = {50, 100, 500, 800, 1000, 2000, 5000, 10000};
        ArrayList<int[]> miListaDeOperaciones = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            miListaDeOperaciones.add(new int[13]);
        }
        Queue<int[]> miCola = new LinkedList<>();
        Queue<int[]> miCola2 = new LinkedList<>();
        Queue<int[]> miCola3 = new LinkedList<>();

        System.out.println("Se llenara 8 veces una lista usando tamaños predefinidos de numeros aleatorios");
        
        for (int j = 0; j < 8; j++) {
            
            int numero = elementos[j];

            for (int i = 0; i < 5; i++) {

                int[] arreglo = new int[numero];
                Utilerias.crearArregloAleatorio(arreglo, numero);

                ArrayList<int[]> miListaDeArreglos = new ArrayList<>();
                miListaDeArreglos.add(arreglo);
                for (int k = 0; k < 13; k++) {
                    miListaDeArreglos.add(Arrays.copyOf(arreglo, arreglo.length));
                }
                miCola.add(miListaDeArreglos.get(10));
                miCola2.add(miListaDeArreglos.get(11));
                miCola3.add(miListaDeArreglos.get(12));

                int[] operaciones = new int[13];
                Ordenamientos.insertionSort(miListaDeArreglos.get(0), operaciones);
                Ordenamientos.selectionSort(miListaDeArreglos.get(1), operaciones);
                Ordenamientos.bubbleSortMejorado(miListaDeArreglos.get(2), operaciones);
                Ordenamientos.gnomeSort(miListaDeArreglos.get(3), operaciones);
                Ordenamientos.heapSort(miListaDeArreglos.get(4), operaciones);
                Ordenamientos.quickSort(miListaDeArreglos.get(5), 0, numero - 1, operaciones);
                Ordenamientos.mergeSort(miListaDeArreglos.get(6), 0, numero - 1, operaciones);
                Ordenamientos.patienceSort(miListaDeArreglos.get(7), operaciones);
                Ordenamientos.countingSort(miListaDeArreglos.get(8), operaciones);
                Ordenamientos.radixSort(miListaDeArreglos.get(9), operaciones);
                Ordenamientos.polifase(miCola, numero / 25, operaciones);
                Ordenamientos.mezclaDirecta(miCola2, operaciones);
                Ordenamientos.mezclaEquilibrada(miCola3, operaciones);

                int[] operacionesAux = miListaDeOperaciones.get(j);
                for (int k = 0; k < 13; k++) {
                    operacionesAux[k] += operaciones[k];
                }
            }
            int[] operacionesAux = miListaDeOperaciones.get(j);
            for (int k = 0; k < 13; k++) {
                operacionesAux[k] /= 5;
            }
        }
        
        System.out.println("Lista de operaciones");
        for (int j = 0; j < 8; j++) {
            System.out.println("Tamaño " + elementos[j] + ": " + Arrays.toString(miListaDeOperaciones.get(j)));
        }

        Grafica verGraficas = new Grafica(elementos, miListaDeOperaciones);
        verGraficas.setVisible(true);
    }
}