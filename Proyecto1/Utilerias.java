import java.util.Random;

/**
 * Clase que va a contener que métodos son utilizados a lo largo del proyecto para tareas comunes como
 * imprimir arreglos, intercambiar elementos y generar arreglos con números aleatorios
 */
public class Utilerias {
    
    /**
     * Imprime en la consola los elementos de un arreglo de enteros
     * @param arreglo El arreglo a imprimir
     */
    public static void imprimirArreglo(int[] arreglo) {
        for(int i:arreglo){  
            System.out.print(i+" ");  
        }
        System.out.println(" ");
    }

    /**
     * Intercambia dos elementos dentro de un arreglo
     * @param arr El arreglo en el que se realizará el intercambio
     * @param x El índice del primer elemento
     * @param y El índice del segundo elemento
     */
    public static void intercambiar(int[] arr, int x, int y) {
        int temp = arr[x];   
        arr[x] = arr[y];  
        arr[y] = temp;
    }

    /**
     * Rellena un arreglo con números enteros aleatorios
     * Los números generados están en el rango de 1 a 1000
     * @param arreglo El arreglo a rellenar
     * @param numero La logitud que va a tener el arreglo
     */
    public static void crearArregloAleatorio(int[] arreglo, int numero) {
        Random aleatorio = new Random();

        for (int i=0;i<numero;i++) {
            arreglo[i] = aleatorio.nextInt(1000) + 1;
        }

    }

    /**
     * Imprime en la consola una parte específica de un arreglo.
     * @param subarreglo El arreglo del cual se imprimirá una sección
     * @param inicio El índice de inicio
     * @param fin El índice final
     */
    public static void verSubarreglo(int[] subarreglo, int inicio, int fin) {
        System.out.print("Subarreglo: ");
    for (int i=inicio;i<=fin;i++)
       System.out.print(subarreglo[i]+" ");
    System.out.println();

    }

}
