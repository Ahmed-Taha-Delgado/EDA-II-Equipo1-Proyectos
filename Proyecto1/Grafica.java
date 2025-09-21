import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
            valores.add(new int[8]);
        }
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("", "", "", ""));
        int[] aux;

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
                    for(int i=0; i<8; i++){
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
                nombres.set(3, "PatienceSort");
                for(int j=0; j<4; j++){    
                    for(int i=0; i<8; i++){
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
                    for(int i=0; i<8; i++){
                        valores.get(j)[i] = operaciones.get(i)[j+8];
                    }
                }
                for(int j=0; j<2; j++){    
                    for(int i=0; i<8; i++){
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
                    for(int i=0; i<8; i++){
                        valores.get(j)[i] = operaciones.get(i)[j+10];
                    }
                }
                for(int j=0; j<1; j++){    
                    for(int i=0; i<8; i++){
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
    public static void Graf(int[] elementos, ArrayList<String> nombres, ArrayList<int[]> valores, int tamaño){
        JFrame ventana = new JFrame("Comparación de Algoritmos");
        ventana.setSize(1000, 700);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setStroke(new BasicStroke(2)); // solo línea sólida

                int width = getWidth();
                int height = getHeight();
                int margin = 80;

                // Generar colores distintos para cada algoritmo
                Color[] colores = new Color[tamaño];
                for (int i = 0; i < tamaño; i++) {
                    float hue = i / (float) tamaño;
                    colores[i] = Color.getHSBColor(hue, 0.8f, 0.8f);
                }

                // Calcular valor máximo
                int max = 0;
                for (int[] vals : valores) {
                    for (int val : vals) max = Math.max(max, val);
                }

                // Dibujar líneas horizontales de referencia
                g2.setColor(Color.LIGHT_GRAY);
                int steps = 20;
                for (int i = 0; i <= steps; i++) {
                    int y = height - margin - i * (height - 2 * margin) / steps;
                    g2.drawLine(margin, y, width - margin, y);
                    g2.setColor(Color.BLACK);
                    int yValue = (int) Math.round((double) max * i / steps);
                    g2.drawString(String.valueOf(yValue), margin - 75, y + 5);
                    g2.setColor(Color.LIGHT_GRAY);
                }

                // Dibujar líneas verticales
                for (int i = 0; i < elementos.length; i++) {
                    int x = margin + i * (width - 2 * margin) / (elementos.length - 1);
                    g2.drawLine(x, height - margin, x, margin);
                }

                // Dibujar ejes
                g2.setColor(Color.BLACK);
                g2.drawLine(margin, height - margin, width - margin, height - margin);
                g2.drawLine(margin, height - margin, margin, margin);

                // Dibujar leyenda en varias filas si es necesario
                int itemsPerRow = 4;
                for (int k = 0; k < tamaño; k++) {
                    int row = k / itemsPerRow;
                    int col = k % itemsPerRow;
                    g2.setColor(colores[k]);
                    g2.fillRect(margin + col * 200, 20 + row * 20, 15, 15);
                    g2.setColor(Color.BLACK);
                    g2.drawString(nombres.get(k), margin + col * 200 + 20, 32 + row * 20);
                }

                // Dibujar líneas de datos con desplazamiento leve
                for (int k = 0; k < tamaño; k++) {
                    int[] datos = valores.get(k);
                    g2.setColor(colores[k]);

                    int offset = k * 3; // pequeño desplazamiento vertical
                    int prevX = margin;
                    int prevY = height - margin - (int) Math.round((double) datos[0] / max * (height - 2 * margin)) - offset;
                    g2.fillOval(prevX - 3, prevY - 3, 6, 6);

                    for (int i = 1; i < elementos.length; i++) {
                        int x = margin + i * (width - 2 * margin) / (elementos.length - 1);
                        int y = height - margin - (int) Math.round((double) datos[i] / max * (height - 2 * margin)) - offset;
                        g2.drawLine(prevX, prevY, x, y);
                        g2.fillOval(x - 3, y - 3, 6, 6);
                        prevX = x;
                        prevY = y;
                    }
                }

                // Etiquetas del eje X
                g2.setColor(Color.BLACK);
                for (int i = 0; i < elementos.length; i++) {
                    int x = margin + i * (width - 2 * margin) / (elementos.length - 1);
                    g2.drawString(String.valueOf(elementos[i]), x - 10, height - margin + 25);
                }

                g2.drawString("Número de elementos", width / 2 - 50, height - 20);
                g2.drawString("Número de operaciones", 20, margin - 10);
            }
        };

        ventana.add(panel);
        ventana.setVisible(true);


    }
}
