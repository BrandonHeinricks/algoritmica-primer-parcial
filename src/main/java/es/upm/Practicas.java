package es.upm;
import static es.upm.DivideVenceras.esPar;

public class Practicas {

    public static int oneSubArray(int[] array){
        return oneSubArrayAux(array, 0, array.length-1);
    }
    public static int oneSubArrayAux(int[] array, int i0, int iN){
        if(i0 == iN){return array[i0];}
        else{
            int k = (i0 + iN)/2;
            int izq = oneSubArrayAux(array, i0, k);
            int der = oneSubArrayAux(array, k+1, iN);
            int mid = maxSubArrayMid(array, i0, k, iN);
            return(Math.max(izq, Math.max(der, mid)));
        }
    }
    public static int maxSubArrayMid(int[] array, int i0, int k, int iN){
        if(array[k] == 1){
            int n = 1;
            int i = k-1;
            int j = k+1;
            while(i>= i0 && array[i] == 1)  {n++; i--;}
            while(j<= iN && array[j] == 1)  {n++; j++;}
            return n;
        }else return -1;
    }


    /*
    Dado un array de números ordenados en los que todos ellos aparecen dos
    veces salvo uno, se desea buscar el único elemento que aparece sólo una vez.
    EJ:   int[] vector = {1, 1, 4, 5, 5, 7, 7, 8, 8, 9, 9};   -----> solucion = 4

    complejidad O(log N)
    */
    public static int noDoble(int[] array){
        return noDobleAux(array, 0, array.length-1);
    }
    public static int noDobleAux(int[] array, int i0, int iN){
        if(i0 == iN){return array[iN];
        }else{
            int k = (i0+ iN)/2;
            if(esPar(k)){
                if(array[k] == array[k+1]){
                     return noDobleAux(array, k+2, iN);
                }else{
                    return noDobleAux(array,i0 , k);
                }
            }else{
                if(array[k] == array[k-1]){
                    return noDobleAux(array, k+1, iN);
                }else{
                    return noDobleAux(array, i0, k-1);
                }
            }
        }
    }

}
