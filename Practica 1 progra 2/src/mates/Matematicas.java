/*Copyright [2024] [Pablo de la Cruz Rodríguez y Santiago Battat Bevilacqua] Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
*/

package mates;

import java.util.concurrent.ThreadLocalRandom;

/**
 * La clase Matematicas proporciona métodos matemáticos útiles.
 */
public class Matematicas {

    /**
     * Aproxima el valor de π utilizando el método de Montecarlo.
     *
     * @param n El número de puntos aleatorios a generar para la aproximación.
     * @return Una aproximación del valor de π.
     * @throws IllegalArgumentException Si el valor de n es menor o igual a cero.
     */
    public static double generarNumeroPi(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El número de puntos (n) debe ser mayor que cero.");
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Generar dos números aleatorios entre -1 y 1.
            double x = ThreadLocalRandom.current().nextDouble() * 2 - 1;
            double y = ThreadLocalRandom.current().nextDouble() * 2 - 1;

            // Aplicar teorema de Pitágoras.
            double h = x * x + y * y;

            // Verificar si el tiro cayó dentro del círculo.
            if (h <= 1) {
                sum++;
            }
        }

        // Calcular la aproximación de π.
        return 4 * ((double) sum / n);
    }
}
