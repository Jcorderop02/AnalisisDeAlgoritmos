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
 * Es la clase principal de la aplicación que se encarga de iniciar la aplicación.
 *
 * @author Juan Cordero
 * @version 1.0 21/04/2022
 */
package com.jcorderop.analisisdealgoritmos.aplicacion;

import com.jcorderop.analisisdealgoritmos.algoritmos.Algoritmos;
import com.jcorderop.analisisdealgoritmos.modelo.Grafico;

/**
 * Clase principal de la aplicación.
 *
 * @author Juan Cordero
 * @version 1.0 22/04/22
 */
public class Principal {
    /**
     * Método principal de la aplicación que ejecuta métodos de otras clases.
     *
     * @param args Argumentos de la aplicación.
     */
    public static void main(String[] args) {
        Algoritmos.Algoritmos();
        Grafico.Grafico();
    }
}
