public class Principal{

    public static void main(String[] args) {
        
        int[] elementos = {50, 100, 500, 800, 1000, 2000, 5000, 10000};
        int[] operaciones = new int[10];

        System.out.println("Se llenara 8 veces una lista usando tamaños predefinidos de numeros aleatorios");
        
        for(int j=0; j<8; j++){    
            
            for(int i=0; i<5; i++){

                int numero = elementos[j];
                int[] copia1 = new int[numero];
                int[] copia2 = new int[numero]; 
                int[] copia3 = new int[numero]; 
                int[] copia4 = new int[numero]; 
                int[] copia5 = new int[numero]; 
                int[] copia6 = new int[numero]; 
                int[] copia7 = new int[numero]; 
                int[] copia8 = new int[numero]; 
                int[] copia9 = new int[numero];
                int[] arreglo = new int[numero];
                Utilerias.crearArregloAleatorio(arreglo, numero);
                Utilerias.imprimirArreglo(arreglo);

                for(int k=0; k<numero; k++){
                    copia1[k]=arreglo[k];
                    copia2[k]=arreglo[k];
                    copia3[k]=arreglo[k];
                    copia4[k]=arreglo[k];
                    copia5[k]=arreglo[k];
                    copia6[k]=arreglo[k];
                    copia7[k]=arreglo[k];
                    copia8[k]=arreglo[k];
                    copia9[k]=arreglo[k];
                }

                Ordenamientos.insertionSort(copia1, operaciones);
                Ordenamientos.selectionSort(copia2, operaciones);
                Ordenamientos.bubbleSort(copia3, operaciones);
                Ordenamientos.bubbleSortMejorado(copia4, operaciones);
                Ordenamientos.heapSort(copia5, operaciones);
                Ordenamientos.quickSort(copia6,0,numero-1, operaciones);
                Ordenamientos.mergeSort(copia7,0,numero-1, operaciones);
                //Ordenamientos.bubbleSort(copia3, operaciones);




            }
        }
        for(int i=0; i<8; i++){
            operaciones[i]=operaciones[i]/5;
        }
        System.out.println("Lista de operaciones");
        Utilerias.imprimirArreglo(operaciones);

        

    }


}