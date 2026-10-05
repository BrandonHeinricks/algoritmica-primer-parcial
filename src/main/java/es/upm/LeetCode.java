package es.upm;

public class LeetCode {

    //169.MajorityElement
    class Solution {
        public int majorityElement(int[] nums) {
            return majorityElementAux(nums, 0, nums.length-1);
        }
        public int majorityElementAux(int[] array, int i0, int iN){
            if(i0==iN){return array[iN];}
            int k = (i0+iN)/2;
            int izq = majorityElementAux(array,i0,k);
            int der = majorityElementAux(array,k+1,iN);
            if(der == izq) {return izq;
            }else{
                int appearancesDer = countAppearances(array,izq,i0,iN);
                int appearancesIzq = countAppearances(array,der,i0,iN);
                if(appearancesDer > appearancesIzq){
                    return der;
                }else{return izq;}
            }
        }
        public int countAppearances(int[] array, int num, int i0, int iN){
            int n = 0;
            for(int i = i0; i<= iN; i++){
                if(array[i] == num){
                    n++;
                }
            }
            return n;
        }
    }




}
