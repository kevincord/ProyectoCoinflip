import java.util.Random;

public class CoinFlipSimulation {
    private static final int NUM_FLIPS = 100;

    public static void main(String[] args) {
        int[] resultados = new int[NUM_FLIPS];
        Random random = new Random();

        for (int i = 0; i < NUM_FLIPS; i++) {
            resultados[i] = lanzarMoneda(random);
        }

        calcularEstadisticas(resultados);
        graficarDistribucion(resultados);
    }

    private static int lanzarMoneda(Random random) {
        return random.nextInt(2);
    }

    private static void calcularEstadisticas(int[] resultados) {
        double media = calcularMedia(resultados);
        double varianza = calcularVarianza(resultados, media);

        System.out.printf("Media: %.2f%n", media);
        System.out.printf("Varianza: %.2f%n", varianza);
    }

    private static double calcularMedia(int[] resultados) {
        double suma = 0;
        for (int resultado : resultados) {
            suma += resultado;
        }
        return suma / resultados.length;
    }

    private static double calcularVarianza(int[] resultados, double media) {
        double suma = 0;
        for (int resultado : resultados) {
            suma += Math.pow(resultado - media, 2);
        }
        return suma / resultados.length;
    }

    private static void graficarDistribucion(int[] resultados) {
        int[] frecuencia = new int[2];
        for (int resultado : resultados) {
            frecuencia[resultado]++;
        }

        System.out.println("Distribución de Resultados:");
        System.out.printf("Cruz: %d%n", frecuencia[0]);
        System.out.printf("Cara: %d%n", frecuencia[1]);
    }
}
