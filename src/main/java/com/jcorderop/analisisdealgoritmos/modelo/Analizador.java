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
 * Clase que se encarga de analizar los algoritmos de ordenamiento y coger los valores de tiempo en nanosegundos.
 *
 * @author Juan Cordero
 * @version 1.0 17/04/2022
 */

package com.jcorderop.analisisdealgoritmos.modelo;

import java.io.PrintWriter;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Analizador {
    /**
     * @param data: Dato de prueba para correr el análisis
     * @param F: función a analizar
     * @param out: fichero de salida para el tiempo de ejecución
     * @return resultado de la función a analizar
     */

    public static long[] analiza(long[] data, Function<long[], long[]> F, PrintWriter out) {
        long[] aux = data.clone();
        long inicio = System.nanoTime();
        F.apply(aux);
        long duracion = System.nanoTime() - inicio;
        out.print(duracion + "\t");
        return aux;
    }

    public static long analizaBusqueda(long[] data, long e, BiFunction<long[], Long, Long> F, PrintWriter out) {
        long inicio = System.nanoTime();
        long p = F.apply(data, e);
        long duracion = System.nanoTime() - inicio;
        out.print(duracion + "\t");
        return p;
    }
}
