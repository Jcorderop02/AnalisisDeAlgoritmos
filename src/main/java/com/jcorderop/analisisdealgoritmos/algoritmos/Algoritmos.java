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
 * Clase que implementa todos los algoritmos de ordenación y su prueba con arrays y distintos tamaños y orden.
 *
 * @author Juan Cordero
 * @version 1.0 14/04/22
 */
package com.jcorderop.analisisdealgoritmos.algoritmos;

import com.jcorderop.analisisdealgoritmos.modelo.Analizador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Clase que contiene los algoritmos de ordenamiento
 */
public class Algoritmos {

    public static void desordena(long[] L) {
        Random random = new Random(L.length);
        for (int i = 0; i < L.length; i++) {
            int p = random.nextInt(L.length);
            long aux = L[i];
            L[i] = L[p];
            L[p] = aux;
        }
    }

    public static long[] quicksort(long[] A, int izq, int der) {

        long pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        long aux;

        while (i < j) {                          // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while (A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux = A[i];                      // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1)
            quicksort(A, izq, j - 1);          // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(A, j + 1, der);          // ordenamos subarray derecho
        return A;
    }

    public static long[] mergesort(long[] A, int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            merge(A, izq, m, der);
        }
        return A;
    }

    public static long[] merge(long[] A, int izq, int m, int der) {
        int i, j, k;
        long[] B = new long[A.length]; //array auxiliar
        for (i = izq; i <= der; i++)      //copia ambas mitades en el array auxiliar
            B[i] = A[i];

        i = izq;
        j = m + 1;
        k = izq;

        while (i <= m && j <= der) //copia el siguiente elemento más grande
            if (B[i] <= B[j])
                A[k++] = B[i++];
            else
                A[k++] = B[j++];

        while (i <= m)         //copia los elementos que quedan de la primera mitad (si los hay)
            A[k++] = B[i++];
        return A;
    }

    /**
     * Método que contiene todos los algoritmos de ordenamiento y ejecuta las pruebas para los distintos tamaños de
     * arrays dependiendo si está ordenado, inverso o aleatorio.
     */
    public static void Algoritmos() {
        Function<long[], long[]> BubbleSort = L -> {
            for (int i = 1; i < L.length; i++)
                for (int j = L.length - 1; j >= i; j--)
                    if (L[j - 1] > L[j]) {
                        long Aux = L[j];
                        L[j] = L[j - 1];
                        L[j - 1] = Aux;
                    }
            return L;
        };

        Function<long[], long[]> SelectSort = L -> {
            for (int i = 0; i < L.length - 1; i++) {
                int pmin = i; //Es la posicion del elemento mínima entre i y length -1
                for (int j = i + 1; j < L.length; j++)
                    if (L[j] < L[pmin]) {
                        pmin = j;
                    }
                long aux = L[pmin];
                L[pmin] = L[i];
                L[i] = aux;
            }
            return L;
        };

        Function<long[], long[]> InserccionDirecta = L -> {
            for (int i = 1; i < L.length; i++) {
                long carta = L[i];
                int j = i - 1;
                while (j >= 0 && L[j] > carta) {
                    L[j + 1] = L[j];
                    j = j - 1;
                }
                L[j + 1] = carta;
            }
            return L;
        };

        BiFunction<long[], Long, Long> BusquedaLineal = (x, y) -> {
            int i = 0;
            while (i < x.length && x[i] != y) {
                i++;
            }
            return Long.valueOf(i < x.length && x[i] == y ? i : -1);
        };

        BiFunction<long[], Long, Long> BusquedaBinaria = (L, e) -> {
            int izquierda = 0;
            int derecha = L.length - 1;

            while (izquierda <= derecha) {
                int central = ((izquierda + derecha) / 2);
                if (L[central] > e) {
                    derecha = central - 1;
                } else if (L[central] < e) {
                    izquierda = central + 1;
                } else {
                    return Long.valueOf(central);
                }
            }
            return Long.valueOf(-1);
        };

        Function<long[], long[]> MergeSort = L ->
                mergesort(L, 0, L.length - 1);

        Function<long[], long[]> QuickSort = L ->
                quicksort(L, 0, L.length - 1);


        long[][] JuegoPruebasAleatorio = new long[6][];
        long[][] JuegoPruebasOrdenado = new long[6][];
        long[][] JuegoPruebasInverso = new long[6][];
        long tam = 100;

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            JuegoPruebasAleatorio[i] = random.longs().map(Math::abs).limit(tam).toArray();
            JuegoPruebasOrdenado[i] = Stream.iterate((long) 0, x -> x + 1).limit(tam).mapToLong(x -> x).toArray();
            JuegoPruebasInverso[i] = Stream.iterate(tam, x -> x - 1).limit(tam).mapToLong(x -> x).toArray();
            tam *= 10;
        }

        try {
            tam = 100;
            FileWriter fichero = new FileWriter("tiempos.txt");
            PrintWriter out = new PrintWriter(fichero);
            long[] resultado;
            out.println("BubbleSort");
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                resultado = Analizador.analiza(JuegoPruebasAleatorio[i], BubbleSort, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasOrdenado[i], BubbleSort, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasInverso[i], BubbleSort, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.println("SelectSort");
            tam = 100;
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                resultado = Analizador.analiza(JuegoPruebasAleatorio[i], SelectSort, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasOrdenado[i], SelectSort, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasInverso[i], SelectSort, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.println("InsercciónDirecta");
            tam = 100;
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                resultado = Analizador.analiza(JuegoPruebasAleatorio[i], InserccionDirecta, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasOrdenado[i], InserccionDirecta, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasInverso[i], InserccionDirecta, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.println("MergeSort");
            tam = 100;
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                resultado = Analizador.analiza(JuegoPruebasAleatorio[i], MergeSort, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasOrdenado[i], MergeSort, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasInverso[i], MergeSort, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.println("QuickSort");
            tam = 100;
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                resultado = Analizador.analiza(JuegoPruebasAleatorio[i], QuickSort, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasOrdenado[i], QuickSort, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                resultado = Analizador.analiza(JuegoPruebasInverso[i], QuickSort, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.println("BusquedaLineal");
            tam = 100;
            long presultado;
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                presultado = Analizador.analizaBusqueda(JuegoPruebasAleatorio[i], random.nextInt(JuegoPruebasAleatorio.length), BusquedaLineal, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                presultado = Analizador.analizaBusqueda(JuegoPruebasOrdenado[i], random.nextInt(JuegoPruebasAleatorio.length), BusquedaLineal, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                presultado = Analizador.analizaBusqueda(JuegoPruebasInverso[i], random.nextInt(JuegoPruebasAleatorio.length), BusquedaLineal, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.println("BusquedaBinaria");
            tam = 100;
            long presultado2;
            for (int i = 0; i < 3; i++) {
                out.print(tam + "\t");
                //System.out.println("tamaño: " + tam);
                presultado2 = Analizador.analizaBusqueda(JuegoPruebasAleatorio[i], random.nextInt(JuegoPruebasAleatorio.length), BusquedaBinaria, out);
                //System.out.println("aleatorio: " + Arrays.toString(JuegoPruebasAleatorio[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                presultado2 = Analizador.analizaBusqueda(JuegoPruebasOrdenado[i], random.nextInt(JuegoPruebasAleatorio.length), BusquedaBinaria, out);
                //System.out.println("ya ordenado: " + Arrays.toString(JuegoPruebasOrdenado[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));

                presultado2 = Analizador.analizaBusqueda(JuegoPruebasInverso[i], random.nextInt(JuegoPruebasAleatorio.length), BusquedaBinaria, out);
                //System.out.println("inverso: " + Arrays.toString(JuegoPruebasInverso[i]));
                //System.out.println("ordenado: " + Arrays.toString(resultado));
                out.println();
                tam *= 10;
            }
            out.close();

        } catch (Exception e) {
            System.out.println("error en fichero");
        }
        System.out.println("Se ha ejecutado correctamente todos los algoritmos.");
    }
}
