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
     * Construye un min-heap a partir de una lista de elementos
     * @param heap Lista de elementos de tipo PileCard
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void buildHeap(List<Ordenamientos.PileCard> heap, int[] operaciones) {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(heap, i, operaciones);
        }
    }

    /**
     * Extrae el elemento mínimo del heap (la raíz)
     * @param heap Lista que representa el min-heap
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     * @return El PileCard con el valor mínimo
     */
    public static Ordenamientos.PileCard extractMin(List<Ordenamientos.PileCard> heap, int[] operaciones) {
        Ordenamientos.PileCard min = heap.get(0);
        Ordenamientos.PileCard last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(heap, 0, operaciones);
        }
        return min;
    }

    /**
     * Inserta un nuevo elemento en el heap y lo reordena para mantener la propiedad de min-heap
     * @param heap Lista que representa el min-heap
     * @param card El elemento PileCard a insertar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void insertHeap(List<Ordenamientos.PileCard> heap, Ordenamientos.PileCard card, int[] operaciones) {
        heap.add(card);
        heapifyUp(heap, heap.size() - 1, operaciones);
    }

    /**
     * Reordena el heap hacia arriba después de insertar un elemento
     * @param heap Lista que representa el min-heap
     * @param i Índice del elemento que se está ajustando
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    private static void heapifyUp(List<Ordenamientos.PileCard> heap, int i, int[] operaciones) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            operaciones[7]++;
            if (heap.get(i).valor < heap.get(parent).valor) {
                Ordenamientos.PileCard tmp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, tmp);
                i = parent;
            } else {
                break;
            }
        }
    }

    /**
     * Reordena el heap hacia abajo después de extraer el mínimo
     * @param heap Lista que representa el min-heap
     * @param i Índice del elemento que se está ajustando
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    private static void heapifyDown(List<Ordenamientos.PileCard> heap, int i, int[] operaciones) {
        int size = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left).valor < heap.get(smallest).valor) {
                smallest = left;
                operaciones[7]++;
            }
            if (right < size && heap.get(right).valor < heap.get(smallest).valor) {
                smallest = right;
                operaciones[7]++;
            }
            if (smallest != i) {
                Ordenamientos.PileCard tmp = heap.get(i);
                heap.set(i, heap.get(smallest));
                heap.set(smallest, tmp);
                i = smallest;
            } else {
                break;
            }
        }
    }
}
