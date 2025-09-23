import java.util.*;

/**
 * Clase que contiene los métodos necesarios para ordenamiento de arreglos y manejo de heaps
 * Va a tener implementación de Merge Sort
 */
public class MetodosExternos {

    /**
     * Fusiona dos subarreglos ordenados en un único subarreglo ordenado
     * @param arreglo El arreglo principal que contiene los subarreglos
     * @param izq El índice de inicio del primer subarreglo
     * @param mid El índice final del primer subarreglo
     * @param der El índice final del segundo subarreglo
     */
    public static void merge(int arreglo[], int izq, int mid, int der) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; ++i){
            L[i] = arreglo[izq + i];
        }
        for (int j=0; j<n2; ++j){
            R[j] = arreglo[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = izq;
        while(i<n1 && j<n2){
            
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Ordena un arreglo de forma recursiva utilizando Merge Sort
     * @param arreglo El arreglo de enteros a ordenar
     * @param izq El índice de inicio del subarreglo a ordenar
     * @param der El índice final del subarreglo a ordenar
     */
    public static void mergeSort(int arreglo[], int izq, int der) {
        if(izq < der){
            int mid = (izq + der) / 2;
            mergeSort(arreglo, izq, mid);
            mergeSort(arreglo, mid + 1, der);
            merge(arreglo, izq, mid, der);
        }
    }

    /**
     * Ordena un subarreglo usando Insertion Sort.
     * @param arr El arreglo a ordenar
     * @param left Índice de inicio
     * @param right Índice final
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void insertionSort(int[] arr, int left, int right, int[] operaciones) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            operaciones[7]++;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
                operaciones[7]++;
            }
            arr[j + 1] = temp;
            operaciones[7]++;
        }
    }

    /**
     * Fusiona dos subarreglos ordenados en uno solo
     * @param arreglo El arreglo original
     * @param izq Índice inicial del primer subarreglo
     * @param mid Fin del primer subarreglo
     * @param der Fin del segundo subarreglo
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void mergeT(int[] arreglo, int izq, int mid, int der, int[] operaciones) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; ++i){
            L[i] = arreglo[izq + i];
            operaciones[7]++;
        }
        for (int j=0; j<n2; ++j){
            R[j] = arreglo[mid + 1 + j];
            operaciones[7]++;
        }

        int i = 0, j = 0;
        int k = izq;
        while(i<n1 && j<n2){
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
                operaciones[7]++;
            } else {
                arreglo[k] = R[j];
                j++;
                operaciones[7]++;
            }
            k++;
        }

        while(i<n1){
            operaciones[7]++;
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            operaciones[7]++;
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }
}