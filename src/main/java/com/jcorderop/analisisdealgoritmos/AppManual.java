/*Copyright [2021] [Juan Cordero]
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

/**
 * Esta clase se encarga de crear las gráficas
 *
 * @author Juan Cordero
 * @version 1.0 18/04/22
 */
package com.jcorderop.analisisdealgoritmos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

public class AppManual {
    public static void main(String[] args) {
        try {
            /*
             * Grafica para algoritmos aleatorios
             */
            DefaultXYDataset algortimosAleatorio = new DefaultXYDataset();
            algortimosAleatorio.addSeries("BubleSort", new double[][]{{100, 1000, 10000}, {228810.0, 6527582.0, 211561570.0}});
            algortimosAleatorio.addSeries("SelectSort", new double[][]{{100, 1000, 10000}, {105502, 3324109, 57787017}});
            algortimosAleatorio.addSeries("InsercciónDirecta", new double[][]{{100, 1000, 10000}, {65900, 3186809, 66758029}});
            algortimosAleatorio.addSeries("MergeSort", new double[][]{{100, 1000, 10000}, {238481, 6079345, 110331885}});
            algortimosAleatorio.addSeries("QuickSort", new double[][]{{100, 1000, 10000}, {37970, 110279, 1394835}});
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.ORANGE);
            renderer.setSeriesPaint(1, Color.BLUE);
            renderer.setSeriesPaint(2, Color.GREEN);
            renderer.setSeriesPaint(3, Color.RED);
            renderer.setSeriesPaint(4, Color.YELLOW);
            renderer.setSeriesPaint(5, Color.CYAN);
            renderer.setSeriesPaint(6, Color.MAGENTA);
            renderer.setSeriesStroke(0, new BasicStroke(2));
            renderer.setSeriesStroke(1, new BasicStroke(2));
            renderer.setSeriesStroke(2, new BasicStroke(2));
            renderer.setSeriesStroke(3, new BasicStroke(2));
            renderer.setSeriesStroke(4, new BasicStroke(2));
            renderer.setSeriesStroke(5, new BasicStroke(2));
            renderer.setSeriesStroke(6, new BasicStroke(2));

            JFreeChart chart = ChartFactory.createXYLineChart("Prueba Aleatorio", "Tamaño", "Tiempos-de-ejecución", algortimosAleatorio);
            chart.getXYPlot().getRangeAxis();
            ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#"));
            chart.getXYPlot().setRenderer(renderer);

            BufferedImage image = chart.createBufferedImage(600, 400);
            ImageIO.write(image, "png", new File("graficos/algoritmos-aleatorio.png"));


            /*
             * Grafica para algoritmos ordenados
             */
            DefaultXYDataset algortimosOrdenado = new DefaultXYDataset();
            algortimosOrdenado.addSeries("BubleSort", new double[][]{{100, 1000, 10000}, {116141, 8648309, 310524148}});
            algortimosOrdenado.addSeries("SelectSort", new double[][]{{100, 1000, 10000}, {115128, 1036646, 34495788}});
            algortimosOrdenado.addSeries("InsercciónDirecta", new double[][]{{100, 1000, 10000}, {4576, 22870, 17924}});
            algortimosOrdenado.addSeries("MergeSort", new double[][]{{100, 1000, 10000}, {183676, 4242569, 77909334}});
            algortimosOrdenado.addSeries("QuickSort", new double[][]{{100, 1000, 10000}, {86404, 1564537, 45632647}});
            XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
            renderer1.setSeriesPaint(0, Color.ORANGE);
            renderer1.setSeriesPaint(1, Color.BLUE);
            renderer1.setSeriesPaint(2, Color.GREEN);
            renderer1.setSeriesPaint(3, Color.RED);
            renderer1.setSeriesPaint(4, Color.YELLOW);
            renderer1.setSeriesPaint(5, Color.CYAN);
            renderer1.setSeriesPaint(6, Color.MAGENTA);
            renderer1.setSeriesStroke(0, new BasicStroke(2));
            renderer1.setSeriesStroke(1, new BasicStroke(2));
            renderer1.setSeriesStroke(2, new BasicStroke(2));
            renderer1.setSeriesStroke(3, new BasicStroke(2));
            renderer1.setSeriesStroke(4, new BasicStroke(2));
            renderer1.setSeriesStroke(5, new BasicStroke(2));
            renderer1.setSeriesStroke(6, new BasicStroke(2));

            JFreeChart chart1 = ChartFactory.createXYLineChart("Prueba Ordenado", "Tamaño", "Tiempos-de-ejecución", algortimosOrdenado);
            chart1.getXYPlot().getRangeAxis();
            ((NumberAxis) chart1.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#"));
            chart1.getXYPlot().setRenderer(renderer1);

            BufferedImage image1 = chart1.createBufferedImage(600, 400);
            ImageIO.write(image1, "png", new File("graficos/algoritmos-ordenado.png"));



            /*
             * Grafica para algoritmos inversos
             */
            DefaultXYDataset algortimosInverso = new DefaultXYDataset();
            algortimosInverso.addSeries("BubleSort", new double[][]{{100, 1000, 10000}, {312467, 4393179, 46653487}});
            algortimosInverso.addSeries("SelectSort", new double[][]{{100, 1000, 10000}, {118417, 2270467, 50334303}});
            algortimosInverso.addSeries("InsercciónDirecta", new double[][]{{100, 1000, 10000}, {246022, 4696191, 29611095}});
            algortimosInverso.addSeries("MergeSort", new double[][]{{100, 1000, 10000}, {101082, 4218819, 54439622}});
            algortimosInverso.addSeries("QuickSort", new double[][]{{100, 1000, 10000}, {78093, 1737216, 38867862}});
            XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
            renderer2.setSeriesPaint(0, Color.ORANGE);
            renderer2.setSeriesPaint(1, Color.BLUE);
            renderer2.setSeriesPaint(2, Color.GREEN);
            renderer2.setSeriesPaint(3, Color.RED);
            renderer2.setSeriesPaint(4, Color.YELLOW);
            renderer2.setSeriesPaint(5, Color.CYAN);
            renderer2.setSeriesPaint(6, Color.MAGENTA);
            renderer2.setSeriesStroke(0, new BasicStroke(2));
            renderer2.setSeriesStroke(1, new BasicStroke(2));
            renderer2.setSeriesStroke(2, new BasicStroke(2));
            renderer2.setSeriesStroke(3, new BasicStroke(2));
            renderer2.setSeriesStroke(4, new BasicStroke(2));
            renderer2.setSeriesStroke(5, new BasicStroke(2));
            renderer2.setSeriesStroke(6, new BasicStroke(2));

            JFreeChart chart2 = ChartFactory.createXYLineChart("Prueba Inverso", "Tamaño", "Tiempos-de-ejecución", algortimosInverso);
            chart2.getXYPlot().getRangeAxis();
            ((NumberAxis) chart2.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#"));
            chart2.getXYPlot().setRenderer(renderer2);

            BufferedImage image2 = chart2.createBufferedImage(600, 400);
            ImageIO.write(image2, "png", new File("graficos/algoritmos-inverso.png"));



            /*
             * Grafica para algoritmos binarios aleatorios
             */
            DefaultXYDataset algoritmosBinariosAleatorios = new DefaultXYDataset();
            algoritmosBinariosAleatorios.addSeries("BusquedaLineal", new double[][]{{100, 1000, 10000}, {33544, 63926, 497048}});
            algoritmosBinariosAleatorios.addSeries("BusquedaBinaria", new double[][]{{100, 1000, 10000}, {14600, 2376, 3000}});
            XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer();
            renderer3.setSeriesPaint(0, Color.ORANGE);
            renderer3.setSeriesPaint(1, Color.BLUE);
            renderer3.setSeriesStroke(0, new BasicStroke(2));
            renderer3.setSeriesStroke(1, new BasicStroke(2));

            JFreeChart chart3 = ChartFactory.createXYLineChart("Prueba Binario Aleatorio", "Tamaño", "Tiempos-de-ejecución", algoritmosBinariosAleatorios);
            chart3.getXYPlot().getRangeAxis();
            ((NumberAxis) chart3.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#"));
            chart3.getXYPlot().setRenderer(renderer3);

            BufferedImage image3 = chart3.createBufferedImage(600, 400);
            ImageIO.write(image3, "png", new File("graficos/algoritmos-binario-aleatorio.png"));



            /*
             * Grafica para algoritmos binarios ordenados
             */
            DefaultXYDataset algoritmosBinariosOrdenado = new DefaultXYDataset();
            algoritmosBinariosOrdenado.addSeries("BusquedaLineal", new double[][]{{100, 1000, 10000}, {2656, 1644, 4250}});
            algoritmosBinariosOrdenado.addSeries("BusquedaBinaria", new double[][]{{100, 1000, 10000}, {1920, 4403, 5822}});
            XYLineAndShapeRenderer renderer4 = new XYLineAndShapeRenderer();
            renderer4.setSeriesPaint(0, Color.ORANGE);
            renderer4.setSeriesPaint(1, Color.BLUE);
            renderer4.setSeriesStroke(0, new BasicStroke(2));
            renderer4.setSeriesStroke(1, new BasicStroke(2));

            JFreeChart chart4 = ChartFactory.createXYLineChart("Prueba Binario Ordenado", "Tamaño", "Tiempos-de-ejecución", algoritmosBinariosOrdenado);
            chart4.getXYPlot().getRangeAxis();
            ((NumberAxis) chart4.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#"));
            chart4.getXYPlot().setRenderer(renderer4);

            BufferedImage image4 = chart4.createBufferedImage(600, 400);
            ImageIO.write(image4, "png", new File("graficos/algoritmos-binario-ordenado.png"));



            /*
             * Grafica para algoritmos binarios inversos
             */
            DefaultXYDataset algoritmosBinariosInverso = new DefaultXYDataset();
            algoritmosBinariosInverso.addSeries("BusquedaLineal", new double[][]{{100, 1000, 10000}, {6317, 43975, 402318}});
            algoritmosBinariosInverso.addSeries("BusquedaBinaria", new double[][]{{100, 1000, 10000}, {2106, 3718, 4474}});
            XYLineAndShapeRenderer renderer5 = new XYLineAndShapeRenderer();
            renderer5.setSeriesPaint(0, Color.ORANGE);
            renderer5.setSeriesPaint(1, Color.BLUE);
            renderer5.setSeriesStroke(0, new BasicStroke(2));
            renderer5.setSeriesStroke(1, new BasicStroke(2));

            JFreeChart chart5 = ChartFactory.createXYLineChart("Prueba Binario Inverso", "Tamaño", "Tiempos-de-ejecución", algoritmosBinariosInverso);
            chart5.getXYPlot().getRangeAxis();
            ((NumberAxis) chart5.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#"));
            chart5.getXYPlot().setRenderer(renderer5);

            BufferedImage image5 = chart5.createBufferedImage(600, 400);
            ImageIO.write(image5, "png", new File("graficos/algoritmos-binario-inverso.png"));
        } catch (Exception e) {

        }
    }
}
