/**
 * Clase de utilidad que es utilizada como un método auxiliar por los
 * algoritmos de ordenamiento externo en la clase {@link Ordenamientos}.
 */
public class MergeExterno {

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
}