package es.upm;
import java.util.Arrays;
import java.util.ArrayList;
public class DivideVenceras {
    public static void main(String[] args) {

        int[] arrayDesordenado = {-2, 12, 3, 4, -21, 8, 10, 5, -6, 1};
        pares(arrayDesordenado);
        System.out.println(Arrays.toString(arrayDesordenado));
    }

    //25JUNIO-2025
    /*
    Dado un vector de números enteros, se desea encontrar el
    elemento mayoritario. Se define elemento mayoritario como aquel que aparece en el
    vector al menos ⌊n/2⌋ + 1 veces. Importante: Se asume que siempre existe el elemento
    mayoritario.
    MAXIMO COMPLEJIDAD: O(N^2)
    */

    public static int elementoMayoritario(int[] v){
        int m = (v.length/2) +1;
        return elementoMayoritarioAux(v,0,v.length-1);
    }
    public static int elementoMayoritarioAux(int[] vector, int i0, int iN) {
        if (i0 == iN) {
            return vector[i0];
        }
        int k = (i0 + iN) / 2;
        int izq = elementoMayoritarioAux(vector, i0, k);
        int der = elementoMayoritarioAux(vector, k + 1, iN);
        if(der == izq){return der;}
        else {
            if (contarApariciones(vector, izq) >= contarApariciones(vector, der)) {
                return izq;
            } else {
                return der;
            }
        }
    }

    public static int contarApariciones(int[] vector, int num) {
        return contarAparicionesAux(vector, 0, vector.length-1, num);
    }
    public static int contarAparicionesAux(int[] vector, int i0,int iN, int num){
        if(i0 == iN){
            if(vector[iN] == num) {
                return 1;
            }
            else return 0;
        }
        else{
            int k = (i0 +iN)/2;
            int izq = contarAparicionesAux(vector, 0,k, num);
            int der = contarAparicionesAux(vector, k+1,iN, num);
            return der+izq;
        }
    }



    /*1) Problema. Diseñar un algoritmo que, dado v un array de enteros ordenados, y
    num, un entero, nos devuelva el índice más pequeño donde se encuentra num. En
    caso de que no exista num en el array, el algoritmo devolverá -1
    */
    //SE HA CONSIDERADO Q EL ARRAY SE ENCUENTRA SIEMPRE ORDENADO

    public static int primerIndex(int[] vector, int num){
        /*comprobaciones q mejoran la complejidad en el caso de q el array proporcionado sea el mejor caso:
        (tiene el valor q buscamos en la primera posicion )*/
        if(vector == null || vector.length == 0){return -1;}
        if(vector[0] == num){
            return 0;
        }
        return primerIndexAux(vector, 0, vector.length-1,num);
    }
    public static int primerIndexAux(int[] vector, int i0,int iN,int num) {
        if (i0 == iN) {
            if (vector[i0] == num) {
                return i0;
            } else {
                return -1;
            }
        } else {
            int k = (i0 + iN) / 2;
            if (vector[k] >= num) { // buscar izq
                return primerIndexAux(vector, i0, k, num);
            } else {// buscar derecha
                return primerIndexAux(vector, k + 1, iN, num);
            }
        }
    }


    /*
    Dado un array de números enteros positivos y negativos, se desea
    encontrar la suma máxima de cualquiera de sus subarrays1 formado sólo por
    números positivos
    */

    public static int maxSubArrayPositivos(int[] array){
        if(array != null && array.length != 0) {
            return maxSubArrayPositivosAux(array, 0, array.length - 1);
        }
        else return -1;
    }
    public static int maxSubArrayPositivosAux(int[] array, int i0, int iN){
        if(i0 == iN){
            if(array[iN] > 0){
                return array[iN];
            }else return 0;
        }
        else{
            int k = (i0+iN) / 2;
            int maxIzq =maxSubArrayPositivosAux(array,i0,k);
            int maxDer =maxSubArrayPositivosAux(array,k+1, iN);
            int maxCentral = maxSubArrayCentral(array,i0,k,iN);
            return Math.max(maxIzq,Math.max(maxDer,maxCentral));
        }
    }
    public static int maxSubArrayCentral(int[] array, int i0, int k , int iN){
        int m = 0;
        if(array[k] < 0){return 0;
        }else {
            int i = k;
            while (i>i0 && array[i] > 0) {
                m = m+array[i];
                i--;
            }
            i = k+1;
            while(i< iN && array[i]>0){
                m = m+array[i];
                i++;
            }
        }
        return m;
    }

    /*
    Decimos que un array, v, de N enteros está polarizado si todos sus
    elementos son distintos de 0, todos los elementos negativos ocupan posiciones
    consecutivas bajas del vector y todos los elementos positivos ocupan posiciones
    consecutivas altas del vector.

    Diseñar un algoritmo basado en Divide y Vencerás con complejidad en el caso
    peor1 de O(log N) (donde N es el tamaño del vector) que, dado un vector polarizado,
    devuelva la posición más baja que ocupa un elemento positivo
     */

    public static int primerPositivoPolarizado(int[] vector){
        if(vector[0] >0){return 0;}
        else if(vector[vector.length-1] < 0){return -1;} // no hay positivos en TODO el array
        return primerPositivoPolarizadoAux(vector, 0, vector.length -1);
    }

    public static int primerPositivoPolarizadoAux(int[] array, int i0, int iN) {
        if(i0 == iN){
            if(array[i0] > 0){return i0;}
            else{return -1;}
        } else{
            int k = (i0 +iN) / 2;
            if(array[k]<0) {
                return primerPositivoPolarizadoAux(array, k + 1, iN);
            }else {
                return primerPositivoPolarizadoAux(array, i0, k);
            }
        }
    }


    /*
    Sea un vector de N elementos enteros positivos y ordenados empezando
    siempre por un elemento par. El vector tiene los elementos colocados siguiendo la
    secuencia par-impar-par-impar-..., excepto por un único elemento que se salta la
    secuencia y que nunca será el primero del vector.

    Diseñar el algoritmo basado en Divide y Vencerás con complejidad en el caso
    peor1 de O(log N) (donde N es el tamaño del vector) que devuelva un número
    entero que corresponde a la posición del elemento que se salta la secuencia.
     */


    public static int parImpar(int[] array){
        return parImparAux(array, 0, array.length-1);
    }
    public static int parImparAux(int[] array, int i0, int iN){
         if(i0 == iN){
             return i0;
         }else{
             int k = (i0+iN) / 2;
             if(esPar(k) && esPar(array[k]) || !esPar(k) && !esPar(array[k])){
                 return parImparAux(array, k+1,iN);
             } else{
                 return parImparAux(array, i0,k);
             }
         }
    }
    public static boolean esPar(int n){
        return n%2 ==0;
    }

    /*
    Dado un array de números enteros, encontrar la longitud del
    subarray1 ordenado más largo

    Diseñar un algoritmo basado en Divide y Vencerás2 con complejidad O(N·log N)
    en el caso peor3 (donde N es el tamaño del array) que devuelva la longitud del
    subarray pedido.
     */


    public static int longMaxSubarrayOrdenado(int[] array){
        if(array != null && array.length != 0) {
            return longMaxSubarrayOrdenadoAux(array, 0, array.length - 1);
        }
        else return 0;
    }
    public static int longMaxSubarrayOrdenadoAux(int[] array, int i0, int iN){
        if(i0 == iN){
            return i0;
        }else{
            int k = (i0+ iN)/2;
            int izq = longMaxSubarrayOrdenadoAux(array,i0, k );
            int der = longMaxSubarrayOrdenadoAux(array,k+1,iN);
            int med = longMaxSubarrayOrdenadoJuntos(array,i0, iN, k);
            return Math.max(med, Math.max(izq,der));
        }

    }
    public static int longMaxSubarrayOrdenadoJuntos(int[] array, int i0 ,int iN, int k){
        // si esto no esta ordenado no existe ningun caso de subArray en el medio q sea mayor a las mitades
        if (array[k] > array[k + 1]) {
            return 0;
        }

        int i = i0;
        while(i<iN && array[i0] >= array[i0+1]){
            i++;
        }
        int j = k+1;
        while(j<iN && array[j] <= array[j+1]){
            j++;
        }
        return i+j;
    }

    /*
    Sean A y B dos vectores de N elementos enteros, ordenados circularmente
    y que pueden contener números repetidos. Ambos vectores comparten exactamente
    los mismos elementos hasta una posición determinada ‘k’, a partir de la cual todos
    sus elementos serán diferentes. Se pide implementar un algoritmo, que dado los
    vectores A y B determine esa posición ‘k’. En el caso de que los dos vectores sean
    idénticos el procedimiento devolverá -1 (indicando de esa forma que tal posición no
    existe).

    Diseñar el procedimiento basado en Divide y Vencerás con complejidad O(log
    N) en el caso peor1 (donde N es el tamaño del vector) que devuelva un número
    entero que corresponde a la posición del primer elemento diferente entre
    ambos vectores
     */
    public static int posDiferente (int[] vector1, int[] vector2){
        if(vector1 != null && vector2 != null && vector1.length !=0 && vector2.length !=0){
            return posDiferenteAux(vector1, vector2, 0, vector1.length-1);}
        else return -1;
    }
    public static int posDiferenteAux(int[] array1, int[] array2, int i0, int iN){
        if(i0 == iN){
            return i0;
        }
        else{
            int k = (i0 + iN)/2;
            if(array1[k] == array2[k]){
                return posDiferenteAux(array1, array2, k+1, iN);
            }
            return posDiferenteAux(array1, array2, i0, k);
        }
    }



    /*
    Se dice que un array, v, es de tipo colina si existe un índice n tal que:
    para todo i<n se cumple que v[i]<v[i+1]; y para todo i>n se cumple que v[i-1]>v[i].
    Dado un array de tipo colina, queremos encontrar su máximo.

    Diseñar un algoritmo basado en Divide y Vencerás con complejidad O(log N) en el
    caso peor1 (donde N es el tamaño del vector) que devuelva el máximo de un array
    de tipo colina.
     */

    public static int maxArrayColina(int[] array){
        if(array != null && array.length != 0) {
            return maxArrayColinaAux(array, 0, array.length - 1);
        }
        else return -1;
    }
    public static int maxArrayColinaAux(int[] array, int i0, int iN){
        if(i0 == iN){
            return array[i0];
        }// segundo caso ase ESTRICTAMENTE necesario para evitar IndexOutOfBoundsException cuando se quiera hacer array[k-1]
        else if(i0 == iN+1){
            return Math.max(array[i0], array[iN]);
        }
        else{
            int k = (i0 +iN) / 2;
            if(array[k] < array[k+1]){
                return maxArrayColinaAux(array, k+1, iN);
            }// en este instante se agotan la llamadas recursivas donde k > k+1
            else if(array[k-1] < array[k]){
                return array[k];
            } else{
                return maxArrayColinaAux(array, i0, k);
            }
        }
    }

    /*
    considerando tener como entrada un array de elementos doblemente repetidos: [1,1,4,4,5,8,8,12,12] --> 5
     */

    public static int buscarNoDoble(int[] array){
        return buscarNoDobleAux(array, 0, array.length-1);
    }
    public static int buscarNoDobleAux(int[] array, int i0, int iN){
        if(i0 == iN){
            return i0;
        }else{
            int k = (i0+iN)/2;
            if (array[k] == array[k-1]) {
                if ((iN - (k + 1) + 1) % 2 == 0) {
                    return buscarNoDobleAux(array, i0, k - 2);
                }else{
                    return buscarNoDobleAux(array, k+1, iN);
                }
            }else if(array[k] == array[k+1]){
                if((k-1-i0+1)%2 == 0){
                    return buscarNoDobleAux(array,k+2,iN);
                }else{
                    return buscarNoDobleAux(array,i0,k-1);
                }
            }else{
                return array[k];
            }
        }
    }

    /*
    usando D&C , retornar el numero de tamaño del subaarray mas largo de unos en un array de elmentos binarios
     */

    public static int cadenaUnos(int[] array){
        return cadenaUnosAux(array, 0, array.length-1);
    }
    public static int cadenaUnosAux(int[] array, int i0, int iN){
        if(i0 == iN){
            return array[i0];
        }else {
            int k = (i0 +iN) / 2;
            int der = cadenaUnosAux(array,k+1, iN);
            int izq = cadenaUnosAux(array, i0, k);
            int mid = cadenaUnosMid(array, i0, iN, k);
            return Math.max(mid, Math.max(der,izq));
        }
    }
    public static int cadenaUnosMid(int[] array, int i0, int iN, int k){
        if(array[k] == 1){
            int n = 1;
            int i = k-1;
            while(i>=i0 && array[i] == 1 ){
                n++;
                i--;
            }
            int j = k+1;
            while(j<=iN && array[j] == 1){
                n ++;
                j ++;
            }
            return n;
        }else{return -1;}
    }


      /*Dado un array de números enteros se quiere reordenar para que
    todos los números pares queden a la izquierda.
    Implementar un algoritmo en Java, basado en el esquema de Divide y
    Vencerás con complejidad en el peor caso O(NlogN)1 que ofrezca esta funcionalidad sin
    usar estructuras auxiliares del tamaño de array.
    */

    /*
    public static void pares(int[] array) {
        if(array != null && array.length != 0){
            paresAux(array, 0, array.length-1);
        }
    }
    public static void paresAux(int[] array, int i0, int iN){
        if(i0 == iN){return;}
        if(i0+1 == iN) {
            if(array[iN]%2==0 && array[i0]%2 !=0){
                int aux = array[i0];
                array[i0]= array[iN];
                array[iN]= aux;
            }
        }
        else{
            int k = (i0 + iN) /2;
            paresAux(array, i0, k);
            paresAux(array, k+1, iN);
            int paresIzq = contadorPares(array, i0, k);
            int paresDer = contadorPares(array,k+1,iN);
            sustituirXIndex(array,paresIzq, paresDer, k);
        }
    }
    public static int contadorPares(int[] array, int inicio, int fin) {
        int contador = 0;
        for(int i=inicio; i<= fin; i++){
            if(array[i] % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }
    public static void sustituirXIndex(int[] array, int paresIzq, int paresDer, int k){
        for(int i = paresIzq; i <= k; i++){
            int aux = array[i];
            array[i] = array[paresDer];
            array[paresDer] = aux;
            paresDer++;
        }
    }
    */

    public static void pares(int[] array){
        paresAux(array, 0, array.length-1);
    }
    public static void paresAux(int [] array, int i0, int iN){
        if(i0 == iN){return;
        }else{
            int k = (i0+iN)/2;
            paresAux(array,i0, k);
            paresAux(array, k+1, iN);
            merge(array, i0, k, iN);
        }
    }

    public static void merge(int[] array, int i0, int k, int iN) {
        int l=i0;
        int r=iN;
        // posicionamos l en el primer elemento impar de la mitad izquierda
        while ((l<=k) && (array[l]%2==0)) l++;
        // posicionamos r en el último elemento par de la mitad derecha
        while ((r>k) && (array[r]%2!=0)) r--;
        // mientras haya elementos en la mitad izquierda (que nos hemos asegurado de quesean impares) y en la mitad derecha (que nos hemos asegurado de que sean pares), los vamos intercambiando, incrementamos l y decrementamos r.
        while ((l<=k) && (r>k)){
            int aux= array[l];
            array[l]=array[r];
            array[r]=aux;
            l++; r--;
        }
    }


    /*
    2019-NOVIEMBRE
    Decimos que un array, v, de N enteros está ordenado circularmente si, o
    bien el vector está ordenado, o bien v[N-1] ≤ v[0] y $k con 0<k<N tal que "i≠k v[i] ≤
    v[i+1] (esto es, está ordenado imaginando que fuera un array circular).
    Sea un array ordenado circularmente en el que todos los números se encuentran
    repetidos 2 veces salvo uno que aparece solo una vez. Se desea encontrar el elemento
    que aparece sólo una vez.

    Diseñar un algoritmo basado en Divide y Vencerás con complejidad O(log N) en el
    caso peor1 (donde N es el tamaño del vector) que devuelva el elemento que aparece
    una sola vez.
     */


    public static int elementoEspecial(int[] vector){
        if (vector.length==1) return vector[0];
        else {
            int i0, iN;
            if (vector[0] == vector[vector.length-1]) { i0 = 1; iN = vector.length-2; }
            else { i0 = 0; iN = vector.length - 1; }
            return elementoEspecialAux(vector,i0,iN);
        }
    }
    public static int elementoEspecialAux(int[] vector, int i0, int iN) {
        if (i0 == iN) return vector[i0];
        else {
            int k = (i0 + iN) / 2;
            if (vector[k] == vector[k + 1]) {
                if ((k - 1 - i0 + 1) % 2 == 1) return elementoEspecialAux(vector, i0, k - 1);
                else return elementoEspecialAux(vector, k + 2, iN);
            } else if (vector[k - 1] == vector[k]) {
                if ((k - 2 - i0 + 1) % 2 == 1) return elementoEspecialAux(vector, i0, k - 2);
                else return elementoEspecialAux(vector, k + 1, iN);
            } else return vector[k];
        }
    }
}