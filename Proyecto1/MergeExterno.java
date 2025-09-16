public class Ordenamientos2{

     public static void merge(int arreglo[], int izq, int mid, int der){
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

    public static void mergeSort(int arreglo[], int izq, int der){
        if(izq < der){
            int mid = (izq + der) / 2;
            mergeSort(arreglo, izq, mid);
            mergeSort(arreglo, mid + 1, der);
            merge(arreglo, izq, mid, der);
        }
    }




}