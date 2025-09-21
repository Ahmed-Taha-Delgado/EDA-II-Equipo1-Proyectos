import java.util.*;

/**
 * Clase que contiene implementaciones estáticas de todos los algoritmos de ordenamiento que analizaremos en el proyecto
 */
public class Ordenamientos {
    
    /**
     * Ordena un arreglo utilizando Insertion Sort
     * @param arreglo El arreglo de enteros que se va a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void insertionSort(int[] arreglo, int[] operaciones) {
        for(int i=1; i<arreglo.length; i++){
            int indice = arreglo[i];
            int j = i;
            while(j>0 && arreglo[j-1]>indice){
                operaciones[0]++;
                arreglo[j] = arreglo[j-1];
                j--;
                operaciones[0]++;
            }
            arreglo[j] = indice;
            operaciones[0]++;
        }

    }

    /**
     * Ordena un arreglo utilizando Selection Sort
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void selectionSort(int[] arreglo, int[] operaciones) {
        for(int i=0; i<arreglo.length; i++){
            int indiceMenor = i;
            for(int j=i+1; j<arreglo.length; j++){
                operaciones[1]++;
                if(arreglo[j]<arreglo[indiceMenor]){
                    indiceMenor = j;
                    operaciones[1]++;
                }
                if(i!=indiceMenor){
                    Utilerias.intercambiar(arreglo, i, indiceMenor);
                    operaciones[1]++;
                    
                    
                }
                
            }
        } 

    }

    /**
     * Ordena un arreglo utilizando una versión mejorada de Bubble Sort,
     * implementa la bandera , que hará que se detienga el algoritmo si no se realizan intercambios en una pasada
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void bubbleSortMejorado(int[] arreglo, int[] operaciones) {
        for(int i=arreglo.length-1; i>0; i--){
            int actualizacion=0;
            for(int j=0; j<i; j++){
                operaciones[2]++;
                if(arreglo[j]>arreglo[j+1]){
                    Utilerias.intercambiar(arreglo, j, j+1);
                    actualizacion=1;
                    operaciones[2]++;
                }
            }
            if(actualizacion==0){
                break;
            }
        }
    }

    /**
     * Ordena un arreglo utilizando Gnome Sort.
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void gnomeSort(int arreglo[], int[] operaciones) {
        int index = 0;

        while (index < arreglo.length) {
            if (index == 0)
                index++;
            if (arreglo[index] >= arreglo[index - 1])
                index++;
            else {
                Utilerias.intercambiar(arreglo, index, index-1);
                index--;
            }
            operaciones[3]++;
        }
    }

    /**
     * Ordena un arreglo utilizando Heap Sort
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void heapSort(int[] arreglo, int[] operaciones) {
        int heapSize = buildHeap(arreglo, operaciones);
        for(int i=arreglo.length-1; i>0; i--){
            Utilerias.intercambiar(arreglo, 0, heapSize);
            heapSize--;
            operaciones[4]++;
            heapify(arreglo,0,heapSize, operaciones);
        }
        

    }

    /**
     * Función auxiliar para heapSort. Va a ayudar a mantener el heap.
     * @param arreglo El arreglo que representa el heap
     * @param i El índice de la raíz
     * @param heapSize El tamaño del heap
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void heapify(int[] arreglo, int i, int heapSize, int[] operaciones) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        if(l<=heapSize && arreglo[l]>arreglo[i]){
            largest = l;
            operaciones[4]++;
        }else{
            largest = i;
            operaciones[4]++;
        }
        if(r<=heapSize && arreglo[r]>arreglo[largest]){
            largest = r;
            operaciones[4]++;
        }
        if(largest!=i){
            Utilerias.intercambiar(arreglo, i, largest);
            operaciones[4]++;
            heapify(arreglo, largest, heapSize, operaciones);
        }
            
    }

    /**
     * Construye el max-heap a partir de un arreglo
     * @param arreglo El arreglo a convertir en heap
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     * @return El tamaño del heap
     */
    public static int buildHeap(int[] arreglo, int[] operaciones) {
        int heapSize = arreglo.length - 1;
        for(int i=(arreglo.length-1)/2; i>=0; i--){
            operaciones[4]++;
            heapify(arreglo, i, heapSize, operaciones);
        }
        return heapSize;
    }

    /**
     * Función auxiliar para quickSort. Va a dividir el arreglo tomando en cuenta un pivote
     * @param arreglo El arreglo a dividir
     * @param inicio El índice de inicio
     * @param fin El índice final
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     * @return El índice del pivote después de la división del arreglo
     */
    public static int partition(int[] arreglo, int inicio, int fin, int[] operaciones) {
        int pivote = arreglo[fin];
        int i = inicio - 1;
        for(int j=inicio; j<=fin-1; j++){
            operaciones[5]++;
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

    /**
     * Ordena un arreglo utilizando Quick Sort de forma recursiva.
     * @param arreglo El arreglo de enteros a ordenar
     * @param inicio El índice de inicio del subarreglo a ordenar
     * @param fin El índice final del subarreglo a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void quickSort(int[] arreglo, int inicio, int fin, int[] operaciones) {
        if(inicio<fin){
            operaciones[5]++;
            int pivote = partition(arreglo, inicio, fin,operaciones);
            quickSort(arreglo, inicio, pivote-1, operaciones);
            quickSort(arreglo, pivote+1, fin, operaciones);
        }
    }

    /**
     * Función auxiliar para mergeSort. Va a fusionar los dos subarreglos ordenados
     * @param arreglo El arreglo principal
     * @param izq Índice de inicio del primer subarreglo
     * @param mid Índice final del primer subarreglo
     * @param der Índice final del segundo subarreglo
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void merge(int arreglo[], int izq, int mid, int der, int[] operaciones) {
        int n1 = mid - izq + 1;
        int n2 = der - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; ++i){
            L[i] = arreglo[izq + i];
            operaciones[6]++;
        }
        for (int j=0; j<n2; ++j){
            R[j] = arreglo[mid + 1 + j];
            operaciones[6]++;
        }

        int i = 0, j = 0;
        int k = izq;
        while(i<n1 && j<n2){
            
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
                operaciones[6]++;
            } else {
                arreglo[k] = R[j];
                j++;
                operaciones[6]++;
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

    /**
     * Ordena un arreglo utilizando Merge Sort de forma recursiva
     * @param arreglo El arreglo de enteros a ordenar
     * @param izq El índice de inicio del subarreglo a ordenar
     * @param der El índice final del subarreglo a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void mergeSort(int arreglo[], int izq, int der, int[] operaciones) {
        if(izq < der){
            operaciones[6]++;
            int mid = (izq + der) / 2;
            mergeSort(arreglo, izq, mid, operaciones);
            mergeSort(arreglo, mid + 1, der, operaciones);
            merge(arreglo, izq, mid, der, operaciones);
        }
    }

    /**
     * Ordena un arreglo utilizando Patience Sort.
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void patienceSort(int[] arreglo, int[] operaciones) {
        List<Stack<Integer>> pilas = new ArrayList<>();

        for (int num : arreglo) {
            operaciones[7]++;
            int indice = findPile(pilas, num, operaciones);
            if (indice == pilas.size()) {
                Stack<Integer> pilaNueva = new Stack<>();
                pilaNueva.push(num);
                pilas.add(pilaNueva);
                operaciones[7]++;
            } else {
                pilas.get(indice).push(num);
                operaciones[7]++;
            }
        }

        List<PileCard> heap = new ArrayList<>();
        for (Stack<Integer> pila : pilas) {
            heap.add(new PileCard(pila.pop(), pila));
            operaciones[7]++;
        }

        MetodosExternos.buildHeap(heap, operaciones);

        int i = 0;
        while (!heap.isEmpty()) {
            PileCard min = MetodosExternos.extractMin(heap, operaciones);
            arreglo[i++] = min.valor;
            operaciones[7]++;
            if (!min.pila.isEmpty()) {
                MetodosExternos.insertHeap(heap, new PileCard(min.pila.pop(), min.pila), operaciones);
                operaciones[7]++;
            }
        }
    }

    /**
     * Encuentra la pila correcta para colocar un número en Patience Sort
     * @param pilas La lista de pilas
     * @param key El número a colocar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     * @return El índice de la pila donde se debe colocar el número
     */
    private static int findPile(List<Stack<Integer>> pilas, int key, int[] operaciones) {
        int left = 0, right = pilas.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            operaciones[7]++;
            if (pilas.get(mid).peek() >= key) {
                right = mid - 1;
                operaciones[7]++;
            } else {
                left = mid + 1;
                operaciones[7]++;
            }
        }
        return left;
    }

    /**
     * Clase auxiliar para representar una carta dentro de una pila en
     * la implementación de Patience Sort.
     */
    public static class PileCard {
        int valor;
        Stack<Integer> pila;

        /**
        * Constructor de un objeto PileCard
        * @param valor Valor entero de la carta
        * @param pila Referencia a la pila de la que proviene la carta
        */
        public PileCard(int valor, Stack<Integer> pila) {
            this.valor = valor;
            this.pila = pila;
        }
    }
    
    /**
     * Ordena un arreglo utilizando Counting Sort.
     * Este algoritmo es eficiente para enteros dentro de un rango específico
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void countingSort(int[] arreglo, int[] operaciones) {
        int maximo = Arrays.stream(arreglo).max().getAsInt();
        int minimo = Arrays.stream(arreglo).min().getAsInt();
        int rango = maximo - minimo + 1;

        int[] arregloAuxiliar = new int[rango];
		int[] arregloOrdenado = new int[arreglo.length];

		for(int i=0;i<arregloAuxiliar.length;i++){
			arregloAuxiliar[i]=0;
            operaciones[8]++;
		}

		for(int i=0;i<arreglo.length;i++){
			arregloAuxiliar[arreglo[i] - minimo]++;
            operaciones[8] += 2;
		}

		for(int i=1;i<arregloAuxiliar.length;i++){
			arregloAuxiliar[i]+=arregloAuxiliar[i-1];
            operaciones[8] += 2;
		}	

		for(int i=arreglo.length-1;i>=0;i--){
			int valor2 = arreglo[i];
            arregloOrdenado[arregloAuxiliar[valor2 - minimo]-1] = valor2;
            arregloAuxiliar[valor2 - minimo]--;
            operaciones[8] += 3;
		}

    }
    /**
     * Ordena un arreglo utilizando Radix Sort
     * @param arreglo El arreglo de enteros a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void radixSort(int[] arreglo, int[] operaciones) {
        LinkedList<Queue<Integer>> miListaDeColas = new LinkedList<>();

        int maximo = Arrays.stream(arreglo).max().getAsInt();
        int digitos = String.valueOf(maximo).length();

		for(int i=0; i<10; i++){
			Queue<Integer> miCola = new LinkedList<>();
			miListaDeColas.add(miCola);
		}
		int posicion = 1;
		for(int i=0; i<digitos; i++){
				
			for(int j=0; j<arreglo.length; j++){
				int cola = (arreglo[j]/posicion)%10;
				miListaDeColas.get(cola).add(arreglo[j]);
                operaciones[9] += 3;
			}
			posicion = posicion * 10;
			
			int aux = 0;
			for(int k=0; k<miListaDeColas.size(); k++){
				while(!miListaDeColas.get(k).isEmpty()){
					arreglo[aux] = miListaDeColas.get(k).poll(); 
					aux++;
                    operaciones[9] += 2;
				}
			}
		}
        
    }

    /**
     * Implementa el algoritmo de ordenamiento externo Polifase
     * Utiliza colas para simular archivos auxiliares y fusiona bloques de datos
     * @param f0 La cola inicial que contiene el arreglo completo a ordenar
     * @param n El tamaño de los bloques iniciales a dividir
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void polifase(Queue<int[]> f0, int n, int[] operaciones) {
        Queue<int[]> f1 = new LinkedList<>();
        Queue<int[]> f2 = new LinkedList<>();
        Queue<int[]> f3 = new LinkedList<>();

        
        int[] bloque = f0.poll();
        int inicio = 0;
        while(bloque.length > inicio){

            int tamaño = Math.min(n,bloque.length - inicio);
            int[] aux = new int[tamaño];

            for(int i=0; i<tamaño; i++){
                aux[i] = bloque[inicio + i];
                operaciones[10]++;
            }
            
            if((inicio/n)%2==0){
                f1.add(aux);
            }else{
                f2.add(aux);
            }
            
            inicio += tamaño;
        }   
        
        
        int indice = 0;
            
        while(f0.size() + f1.size() + f2.size() + f3.size() > 1){
            
            while(f1.size()!=0 || f2.size()!=0){

                int[] aux1 = f1.size()==0 ? new int[0] : f1.poll();
                int[] aux2 = f2.size()==0 ? new int[0] : f2.poll();

                if(aux1.length==0 && aux2.length==0)
                    break;

                int[] aux3 = new int[aux1.length + aux2.length];

                for(int i=0; i<aux1.length; i++){
                    aux3[i] = aux1[i];
                    operaciones[10]++;
                }
                for(int i=0; i<aux2.length; i++){
                    aux3[i+aux1.length] = aux2[i];
                    operaciones[10]++;
                }
                MetodosExternos.mergeSort(aux3,0,aux3.length-1);
                
                if(indice%2 == 0){
                    f0.add(aux3);
                }else{
                    f3.add(aux3);
                }
                indice++;
            }

            indice = 0;
            while(f0.size()!=0 || f3.size()!=0){

                int[] aux1 = f0.size()==0 ? new int[0] : f0.poll();
                int[] aux2 = f3.size()==0 ? new int[0] : f3.poll();

                if(aux1.length==0 && aux2.length==0)
                    break;

                int[] aux3 = new int[aux1.length + aux2.length];

                for(int i=0; i<aux1.length; i++){
                    aux3[i] = aux1[i];
                    operaciones[10]++;
                }
                for(int i=0; i<aux2.length; i++){
                    aux3[i+aux1.length] = aux2[i];
                    operaciones[10]++;
                }
                MetodosExternos.mergeSort(aux3,0,aux3.length-1);
                
                if(indice%2 == 0){
                    f1.add(aux3);
                }else{
                    f2.add(aux3);
                }
                indice++;
            }

        }
        int[] resultado = null;

        if (f0.size()!=0) 
            resultado = f0.peek();
        else if (f1.size()!=0) 
            resultado = f1.peek();
        else if (f2.size()!=0) 
            resultado = f2.peek();
        else if (f3.size()!=0) 
            resultado = f3.peek();

        f0.clear();     
        f0.add(resultado); 
        
        //System.out.println(Arrays.toString(f0.peek()));
            
    }

    /**
     * Implementa el algoritmo de ordenamiento externo de Mezcla Directa
     * @param f0 La cola inicial que contiene el arreglo a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void mezclaDirecta(Queue<int[]> f0, int[] operaciones) {
        Queue<int[]> f1 = new LinkedList<>();
        Queue<int[]> f2 = new LinkedList<>();

        int indice = 0;
        int[] aux = f0.poll();

        while(indice!=aux.length){
            int[] aux1 = new int[1];
            aux1[0] = aux[indice];
            operaciones[11]++;
            if(indice%2 == 0){
                f1.add(aux1);
                
            }else{
                f2.add(aux1);
                
            }
            indice++;
        }

        indice = 0;
        while(f0.size() + f1.size() + f2.size() > 1){
            
            while(f1.size()!=0 || f2.size()!=0){

                int[] aux1 = f1.size()==0 ? new int[0] : f1.poll();
                int[] aux2 = f2.size()==0 ? new int[0] : f2.poll();

                if(aux1.length==0 && aux2.length==0)
                    break;

                int[] aux3 = new int[aux1.length + aux2.length];

                for(int i=0; i<aux1.length; i++){
                    aux3[i] = aux1[i];
                    operaciones[11]++;
                }
                for(int i=0; i<aux2.length; i++){
                    aux3[i+aux1.length] = aux2[i];
                    operaciones[11]++;
                }
                MetodosExternos.mergeSort(aux3,0,aux3.length-1);

                f0.add(aux3);
            }

            while(f0.size()!=0){

                int[] aux4 = f0.poll();

                if(indice%2 == 0){
                    f1.add(aux4);
                }else{
                    f2.add(aux4);
                    
                }
                indice++;
            }

        }
        int[] resultado = null;

        if (f0.size()!=0) 
            resultado = f0.peek();
        else if (f1.size()!=0) 
            resultado = f1.peek();
        else if (f2.size()!=0) 
            resultado = f2.peek();

        f0.clear();     
        f0.add(resultado); 
        
        //System.out.println(Arrays.toString(f0.peek()));
    }

    /**
     * Implementa el algoritmo de ordenamiento externo de Mezcla Equilibrada
     * @param f0 La cola inicial que contiene el arreglo a ordenar
     * @param operaciones Un arreglo auxiliar que utilizaremos para llevar el conteo de operaciones
     */
    public static void mezclaEquilibrada(Queue<int[]> f0, int[] operaciones) {
        Queue<int[]> f1 = new LinkedList<>();
        Queue<int[]> f2 = new LinkedList<>();

        int indice = 0;
        int indice2 = 0;
        int indice3 = 0;
        int[] aux = f0.poll();

        while(indice < aux.length){
            
            int tamaño = 1;
            while(indice2 < aux.length-1 && aux[indice2]<aux[indice2+1]){
                tamaño++;   
                indice2++;
                operaciones[12]++;
            }
            
            int[] aux1 = new int[tamaño];
            for(int i=0; i<tamaño && indice3<aux.length; i++){
                aux1[i] = aux[indice3];
                indice3++;
                operaciones[12]++;
            }

            if(indice%2 == 0){
                f1.add(aux1);
                
            }else{
                f2.add(aux1);
                
            }
            indice++;

        }

        indice = 0;
        while(f0.size() + f1.size() + f2.size() > 1){
            
            while(f1.size()!=0 || f2.size()!=0){

                int[] aux1 = f1.size()==0 ? new int[0] : f1.poll();
                int[] aux2 = f2.size()==0 ? new int[0] : f2.poll();

                if(aux1.length==0 && aux2.length==0)
                    break;

                int[] aux3 = new int[aux1.length + aux2.length];

                for(int i=0; i<aux1.length; i++){
                    aux3[i] = aux1[i];
                    operaciones[12]++;
                }
                for(int i=0; i<aux2.length; i++){
                    aux3[i+aux1.length] = aux2[i];
                    operaciones[12]++;
                }
                MetodosExternos.mergeSort(aux3,0,aux3.length-1);

                f0.add(aux3);
            }

            while(f0.size()!=0){

                int[] aux4 = f0.poll();

                if(indice%2 == 0){
                    f1.add(aux4);
                }else{
                    f2.add(aux4);
                    
                }
                indice++;
            }

        }
        int[] resultado = null;

        if (f0.size()!=0) 
            resultado = f0.peek();
        else if (f1.size()!=0) 
            resultado = f1.peek();
        else if (f2.size()!=0) 
            resultado = f2.peek();

        f0.clear();     
        f0.add(resultado); 
    
    }
}