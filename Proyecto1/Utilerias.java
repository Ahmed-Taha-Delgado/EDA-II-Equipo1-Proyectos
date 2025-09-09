
import java.util.Random;

public class Utilerias {
    
    public static void imprimirArreglo(int[] arreglo){
        for(int i:arreglo){  
            System.out.print(i+" ");  
        }
        System.out.println(" ");
    }

    public static void intercambiar(int[] arr, int x, int y) {
        int temp = arr[x];   
        arr[x] = arr[y];  
        arr[y] = temp;
    }

    public static void crearArregloAleatorio(int[] arreglo, int numero){

        Random aleatorio = new Random();

        for(int i=0;i<numero;i++){
            int valor = aleatorio.nextInt(1000);
            arreglo[i]=valor;
        }

    }

    public static void verSubarreglo(int[] subarreglo, int inicio, int fin){

    System.out.print("Subarreglo: ");
    for (int i=inicio;i<=fin;i++)
       System.out.print(subarreglo[i]+" ");
    System.out.println();

    }

    
}
