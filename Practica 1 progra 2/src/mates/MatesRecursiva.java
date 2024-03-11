/*Copyright [2024] [Pablo de la Cruz Rodríguez, Santiago Battat Bevilacqua y Enrique Manuel Muñoz Sáiz] Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
*/

package mates;

import java.util.concurrent.ThreadLocalRandom;

public class MatesRecursiva {

    /**
     * Genera una aproximación al número pi mediante el método de Montecarlo de
     * forma recursiva.
     *
     * @param n el número de pasos para realizar la aproximación.
     * @return una aproximación al número pi.
     */
    public static double generarPiRecursivo(double n) {
        return generarPiRecursivoAux(n, 0, 0);
    }

    /**
     * Función auxiliar para generar una aproximación al número pi de forma recursiva.
     *
     * @param n          el número de pasos para realizar la aproximación.
     * @param dentroCirculo  el número de puntos dentro del círculo.
     * @param totalPuntos    el número total de puntos generados.
     * @return una aproximación al número pi.
     */
    private static double generarPiRecursivoAux(double n, long dentroCirculo, long totalPuntos) {
        if (totalPuntos == n) {
            return 4.0 * dentroCirculo / n;
        } else {
            double x = ThreadLocalRandom.current().nextDouble() * 2 - 1;
            double y = ThreadLocalRandom.current().nextDouble() * 2 - 1;

            if (x * x + y * y <= 1) {
                return generarPiRecursivoAux(n, dentroCirculo + 1, totalPuntos + 1);
            } else {
                return generarPiRecursivoAux(n, dentroCirculo, totalPuntos + 1);
            }
        }
    }
}

