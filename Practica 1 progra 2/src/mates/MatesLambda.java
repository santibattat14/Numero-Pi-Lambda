/*Copyright [2024] [Pablo de la Cruz Rodríguez, Santiago Battat Bevilacqua y Enrique Manuel Muñoz Sáiz] Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
*/
package mates;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleSupplier;

public class MatesLambda {
    public static double generarPiLambda(long n) {
        double dentroCirculo = contarPuntosDentroCirculo(n);
        return 4.0 * dentroCirculo / n;
    }

    private static long contarPuntosDentroCirculo(long n) {
        DoubleSupplier randomSupplier = () -> ThreadLocalRandom.current().nextDouble() * 2 - 1;
        return java.util.stream.DoubleStream.generate(randomSupplier)
                .limit(n)
                .filter(x -> {
                    double y = randomSupplier.getAsDouble();
                    return x * x + y * y <= 1;
                })
                .count();
    }
}
