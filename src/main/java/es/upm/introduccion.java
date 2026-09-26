package es.upm;

public class introduccion {



    public static int ejercicio1(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    public static boolean ejercicio2(int[] array, int elemento) {
        if (array == null) return false;
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (array[medio] == elemento) {
                return true;
            } else if (array[medio] < elemento) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return false;
    }

    public static int[][] ejercicio3(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            return new int[0][0];
        }
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

}
