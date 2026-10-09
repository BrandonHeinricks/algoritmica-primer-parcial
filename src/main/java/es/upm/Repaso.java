package es.upm;

public class Repaso {

    //8-noviembre-2019
    /*
    Decimos que un array, v, de N enteros está ordenado circularmente si, o
    bien el vector está ordenado, o bien v[N-1] ≤ v[0] y $k con 0<k<N tal que "i≠k v[i] ≤
    v[i+1] (esto es, está ordenado imaginando que fuera un array circular).
    Sea un array ordenado circularmente en el que todos los números se encuentran
    repetidos 2 veces salvo uno que aparece solo una vez. Se desea encontrar el elemento
    que aparece sólo una vez.
     */

    public int elementoEspecial(int[] nums){
        return elementoEspecialAux(nums, 0, nums.length-1);
    }
    public int elementoEspecialAux(int[] nums, int i0, int iN) {
        if (i0 == iN) {
            return nums[i0];
        } else {
            int k = (i0+iN)/2;
            if(k%2 == 0){
                if(nums[k] == nums[k+1]){
                    return elementoEspecialAux(nums,i0,k-1);
                }else{
                    return elementoEspecialAux(nums,k+1,iN);
                }
            }
            else{
                if(nums[k] == nums[k+1]){
                    return elementoEspecialAux(nums,k+1,iN);
                }else{
                    return elementoEspecialAux(nums,i0,k);
                }
            }

        }
    }


    /*
    Sean A y B dos vectores de N elementos enteros, ordenados circularmente
    y que pueden contener números repetidos. Ambos vectores comparten exactamente
    los mismos elementos hasta una posición determinada ‘k’, a partir de la cual todos
    sus elementos serán diferentes. Se pide implementar un algoritmo, que dado los
    vectores A y B determine esa posición ‘k’. En el caso de que los dos vectores sean
    idénticos el procedimiento devolverá -1 (indicando de esa forma que tal posición no
    existe).
     */

    public int posDiferente(int[] v1, int[] v2 ){ // considerando entradas perfectas(no nulo ni vectores de distinto tamaño)
        return posDiferenteAux(v1, v2, 0,v1.length-1);
    }
    public int posDiferenteAux(int[] v1, int[] v2, int i0, int iN){
        if(i0 == iN){return i0;
        }else{
            int k = (i0+iN)/2;
            if(v1[k] == v2[k]){
                return posDiferenteAux(v1,v2,k+1,iN);
            }else{
                return posDiferenteAux(v1,v2,i0,k);
            }
        }
    }

    /*
    justificando complejidad: tenemos un bloque condicional, q indica cual llamada recursiva se da cada ciclo, eso indica q cada ciclo
    solo se llama una vez la recursivida, lo q divide la complejidad del algoritmo a ser (logN).
    */


    /*

    Dado un array de números enteros se quiere reordenar para que
    todos los números pares queden a la izquierda

    Implementar un algoritmo en Java, basado en el esquema de Divide y
    Vencerás con complejidad en el peor caso O(NlogN)1 que ofrezca esta funcionalidad sin
    usar estructuras auxiliares del tamaño de array.
     */

    public void pares(int[] array){
        paresAux(array, 0, array.length-1);
    }
    public void paresAux(int[] array, int i0, int iN){
        if(i0 == iN){
            return;
        }else{
            int k = (i0 + iN)/2;
            paresAux(array,i0,k);
            paresAux(array,k+1,iN);
            paresSwap(array,i0,k,iN);
        }
    }
    public void paresSwap(int[] array, int i0, int k, int iN){
        int i = i0;
        int j = k+1;
        while(i <= k && array[i] % 2 == 0) {
            i++;
        }
        while(j <= iN && array[j] % 2 == 0){
            j++;
        }
        j--;
        while (i <= k && j >= k + 1) {
            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
            i++;
            j--;
        }
    }


    /*

    Dado un vector de números enteros, se desea encontrar el
    elemento mayoritario. Se define elemento mayoritario como aquel que aparece en el
    vector al menos ⌊n/2⌋ + 1 veces. Importante: Se asume que siempre existe el elemento
    mayoritario.

    Diseña e implementa en Java un algoritmo basado en la estrategia de
    Divide y Vencerás con complejidad en el caso peor1 de O(N²) (donde N es el tamaño
    del vector) que compute el problema anterior.
    */


    public int elementoMayoritario(int[] array){
        return elementoMayoritarioAux(array,0, array.length-1);
    }
    public int elementoMayoritarioAux(int[] array, int i0, int iN){
        if(i0 == iN){
            return array[i0];
        }else{
            int k = (i0+iN)/2;
            int izq = elementoMayoritarioAux(array,i0,k);
            int der = elementoMayoritarioAux(array,k+1,iN);
            int mid = elementoMayoritarioMid(array,i0,k,iN);
            return Math.max(izq,Math.max(der,mid));
        }
    }
    public int elementoMayoritarioMid(int[] array, int i0, int k, int iN){
        int maxApariciones = 0;
        int i = i0;
        while(i <= k && maxApariciones < (i0+iN/2){
            int j = i0;
            int num = array[i];
            while(array[j] == num && j<= iN){
                maxApariciones++;
                j++;
            }
        }
        return i;
    }


















}
