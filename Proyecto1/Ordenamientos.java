
public class Ordenamientos {
    
    public static void insertionSort(int[] arreglo, int[] operaciones){

        for(int i=1; i<arreglo.length; i++){
            int indice = arreglo[i];
            int j = i;
            while(j>0 && arreglo[j-1]>indice){
                arreglo[j] = arreglo[j-1];
                j--;
                operaciones[0]++;
            }
            arreglo[j] = indice;
            operaciones[0]++;
        }

    }

    public static void selectionSort(int[] arreglo, int[] operaciones){

        for(int i=0; i<arreglo.length; i++){
            int indiceMenor = i;
            for(int j=i+1; j<arreglo.length; j++){
                operaciones[1]++;
                if(arreglo[j]<arreglo[indiceMenor]){
                    indiceMenor = j;
                }
                if(i!=indiceMenor){
                    Utilerias.intercambiar(arreglo, i, indiceMenor);
                    
                    
                }
                
            }
        } 

    }

    public static void bubbleSort(int[] arreglo, int[] operaciones){

        for(int i=arreglo.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(arreglo[j]>arreglo[j+1]){
                    Utilerias.intercambiar(arreglo, j, j+1);
                    operaciones[2]++;
                }
            }
        }
    }

    public static void bubbleSortMejorado(int[] arreglo, int[] operaciones){

        for(int i=arreglo.length-1; i>0; i--){
            int actualizacion=0;
            for(int j=0; j<i; j++){
                if(arreglo[j]>arreglo[j+1]){
                    Utilerias.intercambiar(arreglo, j, j+1);
                    actualizacion=1;
                    operaciones[3]++;
                }
            }
            if(actualizacion==0){
                break;
            }
        }
    }

    public static void heapSort(int[] arreglo, int[] operaciones){

        int heapSize = buildHeap(arreglo, operaciones);
        for(int i=arreglo.length-1; i>0; i--){
            Utilerias.intercambiar(arreglo, 0, heapSize);
            heapSize--;
            operaciones[4]++;
            heapify(arreglo,0,heapSize, operaciones);
        }
        

    }

    public static void heapify(int[] arreglo, int i, int heapSize, int[] operaciones){

        operaciones[4]++;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        if(l<=heapSize && arreglo[l]>arreglo[i])
            largest = l;
        else
            largest = i;
        if(r<=heapSize && arreglo[r]>arreglo[largest])
            largest = r;
        if(largest!=i){
            Utilerias.intercambiar(arreglo, i, largest);
            heapify(arreglo, largest, heapSize, operaciones);
        }
            
    }

    public static int buildHeap(int[] arreglo, int[] operaciones){

        int heapSize = arreglo.length - 1;
        for(int i=(arreglo.length-1)/2; i>=0; i--){
            operaciones[4]++;
            heapify(arreglo, i, heapSize, operaciones);
        }
        return heapSize;
    }

    public static int partition(int[] arreglo, int inicio, int fin, int[] operaciones){

        int pivote = arreglo[fin];
        int i = inicio - 1;
        for(int j=inicio; j<=fin-1; j++){
            if(arreglo[j]<=pivote){
                i++;
                Utilerias.intercambiar(arreglo, i, j);
                operaciones[5]++;
            }       
        }
        Utilerias.intercambiar(arreglo, i+1, fin);
        operaciones[5]++;
        return (i+1);

    }

    public static void quickSort(int[] arreglo, int inicio, int fin, int[] operaciones){

        if(inicio<fin){
            operaciones[5]++;
            int pivote = partition(arreglo, inicio, fin,operaciones);
            quickSort(arreglo, inicio, pivote-1, operaciones);
            quickSort(arreglo, pivote+1, fin, operaciones);
        }
    }

    static void merge(int arreglo[], int izq, int mid, int der, int[] operaciones){
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; ++i)
            L[i] = arreglo[izq + i];
        for (int j=0; j<n2; ++j)
            R[j] = arreglo[mid + 1 + j];

        int i = 0, j = 0;
        int k = izq;
        while(i<n1 && j<n2){
            operaciones[6]++;
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
            operaciones[6]++;
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            operaciones[6]++;
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arreglo[], int izq, int der, int[] operaciones){
        if(izq < der){
            operaciones[6]++;
            int mid = (izq + der) / 2;
            mergeSort(arreglo, izq, mid, operaciones);
            mergeSort(arreglo, mid + 1, der, operaciones);
            merge(arreglo, izq, mid, der, operaciones);
        }
    }


}
