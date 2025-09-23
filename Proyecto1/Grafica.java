import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Clase que nos va a ayudar a crear la interfaz gráfica para poder visualizar las gráficas comparativas
 */
public class Grafica extends JFrame {
    JButton botonIneficientes, botonEficientes, botonRaritos, botonExternos;
    
     /**
     * Constructor de la clase Grafica
     * Va a inicializar la ventana principal y los botones para mostrar las diferentes gráficas
     * @param elementos Un arreglo con los tamaños de los conjuntos de datos utilizados (eje X)
     * @param operaciones Un ArrayList de arreglos con los conteos de operaciones para cada algoritmo (eje Y)
     */
    public Grafica(int[] elementos, ArrayList<int[]> operaciones){

        ArrayList<int[]> valores = new ArrayList<>();
        for(int i=0; i<4; i++){
            valores.add(new int[20]);
        }
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("", "", "", ""));

        setTitle("Graficas de algoritmos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        JLabel etiqueta = new JLabel("Elige las graficas de los algoritmos que quieres ver C:");
        etiqueta.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(20));
        add(etiqueta);
        add(Box.createVerticalStrut(20));

        botonIneficientes = new JButton("Graficas algoritmos ineficientes");
        botonIneficientes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                nombres.set(0, "InsertionSort");
                nombres.set(1, "SelectionSort");
                nombres.set(2, "BubbleSort Mejorado");
                nombres.set(3, "GnomeSort");

                for(int j=0; j<4; j++){    
                    for(int i=0; i<20; i++){
                        valores.get(j)[i] = operaciones.get(i)[j];
                    }
                }
                for (int[] arr : valores) {
                    System.out.println(Arrays.toString(arr));
                }   
                Graf(elementos, nombres, valores, 4);
            }
        });
        botonIneficientes.setAlignmentX(CENTER_ALIGNMENT);
        add(botonIneficientes);
        add(Box.createVerticalStrut(10));

        botonEficientes = new JButton("Graficas algoritmos Eficientes");
        botonEficientes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                nombres.set(0, "QuickSort");
                nombres.set(1, "HeapSort");
                nombres.set(2, "MergeSort");
                nombres.set(3, "TimSort");
                for(int j=0; j<4; j++){    
                    for(int i=0; i<20; i++){
                        valores.get(j)[i] = operaciones.get(i)[j+4];
                    }
                }
                for (int[] arr : valores) {
                    System.out.println(Arrays.toString(arr));
                }   
                Graf(elementos, nombres, valores, 4);
            }
        });
        botonEficientes.setAlignmentX(CENTER_ALIGNMENT);
        add(botonEficientes);
        add(Box.createVerticalStrut(10));

        botonRaritos = new JButton("Graficas algoritmos Raritos");
        botonRaritos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                nombres.set(0, "CountingSort");
                nombres.set(1, "RadixSort");
                for(int j=0; j<2; j++){    
                    for(int i=0; i<20; i++){
                        valores.get(j)[i] = operaciones.get(i)[j+8];
                    }
                }
                for(int j=0; j<2; j++){    
                    for(int i=0; i<20; i++){
                        valores.get(j+2)[i] = 0;
                    }
                }
                for (int[] arr : valores) {
                    System.out.println(Arrays.toString(arr));
                }   
                Graf(elementos, nombres, valores, 2);
            }
        });
        botonRaritos.setAlignmentX(CENTER_ALIGNMENT);
        add(botonRaritos);
        add(Box.createVerticalStrut(10));

        botonExternos = new JButton("Graficas algoritmos Externos");
        botonExternos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                nombres.set(0, "Polifase");
                nombres.set(1, "Mezcla Directa");
                nombres.set(2, "Mezcla Equilibrada");
                for(int j=0; j<3; j++){    
                    for(int i=0; i<20; i++){
                        valores.get(j)[i] = operaciones.get(i)[j+10];
                    }
                }
                for(int j=0; j<1; j++){    
                    for(int i=0; i<20; i++){
                        valores.get(j+3)[i] = 0;
                    }
                }
                for (int[] arr : valores) {
                    System.out.println(Arrays.toString(arr));
                }   
                Graf(elementos, nombres, valores, 3);
                
                
            }
        });        
        botonExternos.setAlignmentX(CENTER_ALIGNMENT);
        add(botonExternos);
        add(Box.createVerticalGlue());

    }
    /**
     * Crea y muestra una nueva ventana que contiene el panel con la gráfica
     * Dibuja los ejes, leyendas y las líneas de datos que comparan los algoritmos
     * @param elementos Los valores para el eje X (tamaño del arreglo)
     * @param nombres Los nombres de los algoritmos a graficar
     * @param valores Los datos de operaciones para el eje Y
     * @param tamaño El número de algoritmos a graficar en esta ventana
     */

    //Comentamos esecificamente esta clase, porque hacer graficas en java era algo relativamente nuevo, sabiamos hacer interfaz grafica pero no como hacer graficas
    public static void Graf(int[] elementos, ArrayList<String> nombres, ArrayList<int[]> valores, int tamaño){
        
        //Declaramos la ventana emergente, su titulo, tamaño, la forma en la que se cerrara y su posicion
        JFrame ventana = new JFrame("Comparación de Algoritmos");
        ventana.setSize(1000, 700);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        //Hacemos un objeto de tipo "JPanel", permite crear botones, etiquetas, texto, etc. (Interfaz Grafica)
        JPanel panel = new JPanel(){
            //Sobrescribir los metodos de paintComponent para dibujar en el panel
            @Override
            protected void paintComponent(Graphics grafica){
                
                //Se castea el objeto grafica a tipo "Graphics2D", permite utilizar metodos que no estan en Graphics
                //Usamos esa version para hacer un antialiasing
                super.paintComponent(grafica);
                Graphics2D grafica2 = (Graphics2D) grafica;
                //Se definen las lineas de tamaño 2 pixeles
                //El antialiasing suaviza los pixeles de las lineas (se ve mas bonito)
                grafica2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                grafica2.setStroke(new BasicStroke(2));

                //Usamos variables para el tamaño de la ventana por si se quiere redefinir el tamaño dentro de la ejecucion
                int ancho = getWidth();
                int alto = getHeight();

                //Declaramos los colores que queremos para las lineas con la clase Color
                Color[] Colores = {
                    new Color(52, 152, 219),
                    new Color(231, 76, 60),
                    new Color(46, 204, 113),
                    new Color(155, 89, 182)
                };

                //Calculamos el valor maximo de los arreglos ingresados para saber el valor maximo de cada grafica
                int max = 0;
                for(int[] valor : valores){
                    for(int val : valor){ 
                        max = Math.max(max, val);
                    }
                }

                //Dibujamos las lineas del eje "y" junto con sus valores
                grafica2.setColor(Color.lightGray);
                for(int i=0; i<=20; i++){
                    int y = alto - 80 - i * (alto - 160) / 20;
                    grafica2.drawLine(80, y, ancho - 80, y);
                    grafica2.setColor(Color.black);
                    int valorY = (int) Math.round((double) max * i / 20);
                    grafica2.drawString(String.valueOf(valorY), 15, y + 5);
                    grafica2.setColor(Color.lightGray);
                }

                //Dibujamos las lineas del eje "x"
                for(int i = 0; i < elementos.length; i++){
                    int x = 80 + i * (ancho - 2 * 80) / (elementos.length - 1);
                    grafica2.drawLine(x, alto - 80, x, 80);
                }

                //Dibujamos los ejes
                grafica2.setColor(Color.black);
                grafica2.drawLine(80, alto - 80, ancho - 80, alto - 80);
                grafica2.drawLine(80, alto - 80, 80, 80);

                //Se muestran los nombres de los algoritmos mostrados
                for(int i = 0; i < tamaño; i++){
                    int fila = i/4;
                    grafica2.setColor(Colores[i]);
                    grafica2.fillRect(80 + i * 200, 20 + fila * 20, 15, 15);
                    grafica2.setColor(Color.black);
                    grafica2.drawString(nombres.get(i), 80 + i * 200 + 20, 32 + fila * 20);
                }

                //Dibujamos las lineas de los algoritmos con un leve desplazamiento para que no se encimen
                for(int k = 0; k < tamaño; k++){
                    int[] datos = valores.get(k);
                    grafica2.setColor(Colores[k]);

                    int desplazamiento = k*3;
                    int X = 80;
                    int Y = alto - 80 - (int) Math.round((double) datos[0] / max * (alto - 160)) - desplazamiento;
                    grafica2.fillOval(X - 3, Y - 3, 6, 6);

                    for(int i = 1; i < elementos.length; i++){
                        int x = 80 + i * (ancho - 160) / (elementos.length - 1);
                        int y = alto - 80 - (int) Math.round((double) datos[i] / max * (alto - 160)) - desplazamiento;
                        grafica2.drawLine(X, Y, x, y);
                        grafica2.fillOval(x - 3, y - 3, 6, 6);
                        X = x;
                        Y = y;
                    }
                }

                //Valores del eje "x"
                grafica2.setColor(Color.black);
                for(int i = 0; i < elementos.length; i++){
                    int x = 80 + i * (ancho - 2 * 80) / (elementos.length - 1);
                    grafica2.drawString(String.valueOf(elementos[i]), x - 10, alto - 80 + 25);
                }

                //Etiquetas de los ejes 
                grafica2.drawString("Número de elementos", ancho / 2 - 50, alto - 20);
                grafica2.drawString("Número de operaciones", 8, 65);
            }
        };

        ventana.add(panel);
        ventana.setVisible(true);


    }
}
