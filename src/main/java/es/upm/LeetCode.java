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


    //53.MaximumSubArray
    public int maxSubArray(int[] nums) {
        return maxSubArrayAux(nums, 0, nums.length-1);
    }
    public int maxSubArrayAux(int[] nums,int i0,int iN){
        if(i0 == iN){return nums[i0];}
        else{
            int k = (i0+iN)/2;
            int izq = maxSubArrayAux(nums, i0, k);
            int der = maxSubArrayAux(nums,k+1, iN);
            int mid = maxSubArrayMid(nums, i0, k, iN);
            return Math.max(izq, Math.max(der,mid));
        }

    }
    public int maxSubArrayMid(int[] nums, int i0, int k , int iN){
        int i = k;
        int sumIzq = 0;
        int maxIzq = Integer.MIN_VALUE;

        while(i >= i0){
            sumIzq += nums[i];
            if(sumIzq > maxIzq) { maxIzq = sumIzq; }
            i--;
        }
        int j = k + 1;
        int sumDer = 0;
        int maxDer = Integer.MIN_VALUE;
        while(j <= iN){
            sumDer += nums[j];
            if(sumDer > maxDer) { maxDer = sumDer; }
            j++;
        }
        return maxIzq + maxDer;
    }
}

