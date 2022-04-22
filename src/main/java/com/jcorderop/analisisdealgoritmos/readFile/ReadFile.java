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
 * Clase encargada de leer el fichero "tiempo.txt" donde se encuentran los tiempos de ejecución de los algoritmos,
 * eliminar los tabuladores del fichero y meter cada tiempo uno a uno en un array para su posterior uso.
 *
 * @author Juan Cordero
 * @version 1.0 19/04/2022
 */
package com.jcorderop.analisisdealgoritmos.readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que lee un archivo y lo guarda en una lista
 */
public class ReadFile {
    /**
     * Método que lee un archivo línea por línea, eliminando los tabuladores y despues metiendo cada valor de tiempo en una lista para despues poder acceder a ella desde un get.
     *
     * @return Una arraylist con los valores de tiempo unitarios.
     */
    public static ArrayList<List<Double>> readFile() {

        ArrayList<List<Double>> tiempos = new ArrayList<>();

        File file = new File("tiempos.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split("\t");

                try {
                    List<Double> primerNumero = new ArrayList<>();
                    List<Double> segundoNumero = new ArrayList<>();
                    List<Double> tercerNumero = new ArrayList<>();
                    for (int i = 1; i < numbers.length - 2; i++) {
                        primerNumero.add(Double.valueOf(numbers[i]));
                    }
                    tiempos.add(primerNumero);
                    for (int i = 2; i < numbers.length - 1; i++) {
                        segundoNumero.add(Double.valueOf(numbers[i]));
                    }
                    tiempos.add(segundoNumero);
                    for (int i = 3; i < numbers.length; i++) {
                        tercerNumero.add(Double.valueOf(numbers[i]));
                    }
                    tiempos.add(tercerNumero);
                } catch (NumberFormatException e) {

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        }
        tiempos.removeIf(linea -> linea.isEmpty());
        return tiempos;
    }
}

