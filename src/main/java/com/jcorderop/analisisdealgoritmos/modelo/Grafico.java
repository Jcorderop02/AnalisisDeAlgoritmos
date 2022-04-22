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
 * Clase que se encarga de crear las gráficas de los algoritmos de ordenamiento
 *
 * @author Juan Cordero
 * @version 1.0 18/04/2022
 */
package com.jcorderop.analisisdealgoritmos.modelo;

import com.jcorderop.analisisdealgoritmos.readFile.ReadFile;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static java.lang.System.out;

/**
 * Clase que se encarga de crear las gráficas de los algoritmos de ordenamiento
 */
public class Grafico {

    /**
     * Método encargado de crear los gráficos con los parámetros adecuado, cogiendo los valores de tiempo del archivo "tiempos.txt"
     */
    public static void Grafico() {
        List<List<Double>> tiempos = ReadFile.readFile();

        try {
            /*
             * Gráfica para algoritmos aleatorios
             */
            DefaultXYDataset algortimosAleatorio = new DefaultXYDataset();
            algortimosAleatorio.addSeries("BubleSort", new double[][]{{100, 1000, 10000}, {tiempos.get(0).get(0), tiempos.get(3).get(0), tiempos.get(6).get(0)}});
            algortimosAleatorio.addSeries("SelectSort", new double[][]{{100, 1000, 10000}, {tiempos.get(9).get(0), tiempos.get(12).get(0), tiempos.get(15).get(0)}});
            algortimosAleatorio.addSeries("InsercciónDirecta", new double[][]{{100, 1000, 10000}, {tiempos.get(18).get(0), tiempos.get(21).get(0), tiempos.get(24).get(0)}});
            algortimosAleatorio.addSeries("MergeSort", new double[][]{{100, 1000, 10000}, {tiempos.get(27).get(0), tiempos.get(30).get(0), tiempos.get(33).get(0)}});
            algortimosAleatorio.addSeries("QuickSort", new double[][]{{100, 1000, 10000}, {tiempos.get(36).get(0), tiempos.get(39).get(0), tiempos.get(42).get(0)}});
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
            ImageIO.write(image, "png", new File("graficos/algoritmos-aleatorio1.png"));


            /*
             * Gráfica para algoritmos ordenados
             */
            DefaultXYDataset algortimosOrdenado = new DefaultXYDataset();
            algortimosOrdenado.addSeries("BubleSort", new double[][]{{100, 1000, 10000}, {tiempos.get(1).get(0), tiempos.get(4).get(0), tiempos.get(7).get(0)}});
            algortimosOrdenado.addSeries("SelectSort", new double[][]{{100, 1000, 10000}, {tiempos.get(10).get(0), tiempos.get(13).get(0), tiempos.get(16).get(0)}});
            algortimosOrdenado.addSeries("InsercciónDirecta", new double[][]{{100, 1000, 10000}, {tiempos.get(19).get(0), tiempos.get(22).get(0), tiempos.get(25).get(0)}});
            algortimosOrdenado.addSeries("MergeSort", new double[][]{{100, 1000, 10000}, {tiempos.get(28).get(0), tiempos.get(31).get(0), tiempos.get(34).get(0)}});
            algortimosOrdenado.addSeries("QuickSort", new double[][]{{100, 1000, 10000}, {tiempos.get(37).get(0), tiempos.get(40).get(0), tiempos.get(43).get(0)}});
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
             * Gráfica para algoritmos inversos
             */
            DefaultXYDataset algortimosInverso = new DefaultXYDataset();
            algortimosInverso.addSeries("BubleSort", new double[][]{{100, 1000, 10000}, {tiempos.get(2).get(0), tiempos.get(5).get(0), tiempos.get(8).get(0)}});
            algortimosInverso.addSeries("SelectSort", new double[][]{{100, 1000, 10000}, {tiempos.get(11).get(0), tiempos.get(14).get(0), tiempos.get(17).get(0)}});
            algortimosInverso.addSeries("InsercciónDirecta", new double[][]{{100, 1000, 10000}, {tiempos.get(20).get(0), tiempos.get(23).get(0), tiempos.get(26).get(0)}});
            algortimosInverso.addSeries("MergeSort", new double[][]{{100, 1000, 10000}, {tiempos.get(29).get(0), tiempos.get(32).get(0), tiempos.get(35).get(0)}});
            algortimosInverso.addSeries("QuickSort", new double[][]{{100, 1000, 10000}, {tiempos.get(38).get(0), tiempos.get(41).get(0), tiempos.get(44).get(0)}});
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
             * Gráfica para algoritmos binarios aleatorios
             */
            DefaultXYDataset algoritmosBinariosAleatorios = new DefaultXYDataset();
            algoritmosBinariosAleatorios.addSeries("BusquedaLineal", new double[][]{{100, 1000, 10000}, {tiempos.get(45).get(0), tiempos.get(48).get(0), tiempos.get(51).get(0)}});
            algoritmosBinariosAleatorios.addSeries("BusquedaBinaria", new double[][]{{100, 1000, 10000}, {tiempos.get(54).get(0), tiempos.get(57).get(0), tiempos.get(60).get(0)}});
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
             * Gráfica para algoritmos binarios ordenados
             */
            DefaultXYDataset algoritmosBinariosOrdenado = new DefaultXYDataset();
            algoritmosBinariosOrdenado.addSeries("BusquedaLineal", new double[][]{{100, 1000, 10000}, {tiempos.get(46).get(0), tiempos.get(49).get(0), tiempos.get(52).get(0)}});
            algoritmosBinariosOrdenado.addSeries("BusquedaBinaria", new double[][]{{100, 1000, 10000}, {tiempos.get(55).get(0), tiempos.get(58).get(0), tiempos.get(61).get(0)}});
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
             * Gráfica para algoritmos binarios inversos
             */
            DefaultXYDataset algoritmosBinariosInverso = new DefaultXYDataset();
            algoritmosBinariosInverso.addSeries("BusquedaLineal", new double[][]{{100, 1000, 10000}, {tiempos.get(47).get(0), tiempos.get(50).get(0), tiempos.get(53).get(0)}});
            algoritmosBinariosInverso.addSeries("BusquedaBinaria", new double[][]{{100, 1000, 10000}, {tiempos.get(56).get(0), tiempos.get(59).get(0), tiempos.get(62).get(0)}});
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

            out.println("Se han generado los graficos.");
        } catch (IOException e) {
            out.println("No se pudo crear los graficos.");
        }
    }
}
