package es.upm;
import java.util.Arrays;
public class PracticaOrdenacion {

    public static void main(String[] args) {
         int[] datos = {7, 3, -2, 1, -21, 8, 12};
         System.out.println("Array original: " + Arrays.toString(datos));
         ordenarPorSeleccion(datos);
         System.out.println("Array ordenado: " + Arrays.toString(datos));
         ordenarPorInsercion(datos);
         System.out.println("Array ordenado: " + Arrays.toString(datos));
         ordenarPorBurbuja(datos);
         System.out.println("Array ordenado: " + Arrays.toString(datos));


        System.out.println("\n\n\n\n\nprueba");
        String[] arr = {"A", "B", "C"};
        int index = Arrays.asList(arr).indexOf("B"); // Returns 1
        System.out.println(index);

    }

    public static void ordenarPorSeleccion(int[] datos){
        for(int i = 0; i < datos.length; i++){
            int k = i;
            for(int j = i+1; j < datos.length; j++){
                if(datos[k] > datos[j]){
                    k = j;
                }
            }
            int aux = datos[i];
            datos[i] = datos[k];
            datos[k] = aux;
        }
        System.out.println("SELECCION");
    }

    public static void ordenarPorInsercion(int[] datos){
        for (int i = 1; i <= datos.length-1; i++){
            int k = i;
            int aux = datos[i];
            while(k > 0 && datos[k-1] > aux){
                datos[k] = datos[k-1];
                k--;
            }
            datos[k] = aux;
        }
        System.out.println("INSERCION");
    }

    public static void ordenarPorBurbuja(int[] datos){
        boolean movimientoFlag;
        for(int i = datos.length-1 ; i >= 0; i--) {
            movimientoFlag = false;
            for(int j = 0; j<i; j++){
                if(datos[j] >= datos[j+1]){
                    int aux = datos[j+1];
                    datos[j+1] = datos[j];
                    datos[j] = aux;
                    movimientoFlag = true;
                }
            }
            if(!movimientoFlag) break;
        }
        System.out.println("BURBUJA");
    }
}
