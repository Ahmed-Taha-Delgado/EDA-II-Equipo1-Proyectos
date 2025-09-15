import java.util.ArrayList;
import java.util.Arrays;

public class Principal{

    public static void main(String[] args) {
        
        int[] elementos = {50, 100, 500, 800, 1000, 2000, 5000, 10000};
        int[] operaciones = new int[10];
        ArrayList<int[]> miListaDeArreglos = new ArrayList<>();
        for (int k = 0; k < 10; k++) {
            miListaDeArreglos.add(new int[0]);
        }

        System.out.println("Se llenara 8 veces una lista usando tamaños predefinidos de numeros aleatorios");
        
        for(int j=0; j<8; j++){   
            
            int numero = elementos[j];
            
            for(int i=0; i<5; i++){

                int[] arreglo = new int[numero];
                Utilerias.crearArregloAleatorio(arreglo, numero);
                miListaDeArreglos.set(0,arreglo);
                for(int k=1; k<10; k++){
                    miListaDeArreglos.set(k,Arrays.copyOf(arreglo, arreglo.length));
                }

                Ordenamientos.insertionSort(miListaDeArreglos.get(0), operaciones);
                Ordenamientos.selectionSort(miListaDeArreglos.get(1), operaciones);
                Ordenamientos.bubbleSort(miListaDeArreglos.get(2), operaciones);
                Ordenamientos.bubbleSortMejorado(miListaDeArreglos.get(3), operaciones);
                Ordenamientos.heapSort(miListaDeArreglos.get(4), operaciones);
                Ordenamientos.quickSort(miListaDeArreglos.get(5),0,numero-1, operaciones);
                Ordenamientos.mergeSort(miListaDeArreglos.get(6),0,numero-1, operaciones);
                Ordenamientos.countingSort(miListaDeArreglos.get(7), operaciones);
                Ordenamientos.radixSort(miListaDeArreglos.get(8), operaciones);




            }
        }
        for(int i=0; i<8; i++){
            operaciones[i]=operaciones[i]/5;
        }
        System.out.println("Lista de operaciones");
        Utilerias.imprimirArreglo(operaciones);

        

    }


}
