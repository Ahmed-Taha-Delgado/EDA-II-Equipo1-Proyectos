import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Principal{

    public static void main(String[] args) {
        
        int[] elementos = {50, 100, 500, 800, 1000, 2000, 5000, 10000};
        ArrayList<int[]> miListaDeOperaciones = new ArrayList<>();
        for(int i=0; i<8; i++){
            miListaDeOperaciones.add(new int[13]);
        }
        Queue<int[]> miCola = new LinkedList<>();

        System.out.println("Se llenara 8 veces una lista usando tamaños predefinidos de numeros aleatorios");
        
        for(int j=0; j<8; j++){   
            
            int numero = elementos[j];

            for(int i=0; i<5; i++){

                int[] arreglo = new int[numero];
                Utilerias.crearArregloAleatorio(arreglo, numero);

                ArrayList<int[]> miListaDeArreglos = new ArrayList<>();
                miListaDeArreglos.add(arreglo);
                for(int k=0; k<13; k++){
                    miListaDeArreglos.add(Arrays.copyOf(arreglo, arreglo.length));
                }
                miCola.add(arreglo);

                int[] operaciones = new int[13];
                Ordenamientos.insertionSort(miListaDeArreglos.get(0), operaciones);
                Ordenamientos.selectionSort(miListaDeArreglos.get(1), operaciones);
                Ordenamientos.bubbleSortMejorado(miListaDeArreglos.get(2),operaciones);
                Ordenamientos.gnomeSort(miListaDeArreglos.get(3), operaciones);
                Ordenamientos.heapSort(miListaDeArreglos.get(4), operaciones);
                Ordenamientos.quickSort(miListaDeArreglos.get(5),0,numero-1, operaciones);
                Ordenamientos.mergeSort(miListaDeArreglos.get(6),0,numero-1, operaciones);
                //Ordenamientos.relaxionSort(miListaDeArreglos.get(7), operaciones);
                Ordenamientos.countingSort(miListaDeArreglos.get(8), operaciones);
                Ordenamientos.radixSort(miListaDeArreglos.get(9), operaciones);
                Ordenamientos.polifase(miCola, numero/25, operaciones);
                //Ordenamientos.mezclaDirecta(arreglo, numero, operaciones);
                //Ordenamientos.mezclaEquilibrada();

                int[] operacionesAux = miListaDeOperaciones.get(j);
                for(int k=0; k<13; k++){
                    operacionesAux[k] += operaciones[k];
                }
            }
            int[] operacionesAux = miListaDeOperaciones.get(j);
            for(int k=0; k<13; k++){
                operacionesAux[k] /= 5;
            }
        }
        
        System.out.println("Lista de operaciones");
        for(int j=0; j<8; j++){
            System.out.println("Tamaño " + elementos[j] + ": " + Arrays.toString(miListaDeOperaciones.get(j)));
        }

        Grafica verGraficas = new Grafica(elementos, miListaDeOperaciones);
        verGraficas.setVisible(true);

    }


}
