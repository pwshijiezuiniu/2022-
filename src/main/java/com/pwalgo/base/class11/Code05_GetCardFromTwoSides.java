package com.pwalgo.base.class11;

public class Code05_GetCardFromTwoSides {
    public static void main(String[] args) {
        int [] arr = new int[]{1,100,2,9,3,29,20,7,1};
        System.out.println(f(arr,0, arr.length-1)+","+l(arr,0,arr.length-1));
        System.out.println(getMax(arr));
    }
    public static int f(int [] arr,int left,int right){
        if(right == left){
            return arr[left];
        }
        return Math.max(
                arr[left]+l(arr,left+1,right),
                arr[right]+l(arr,left,right - 1)
        );
    }
    public static int l(int [] arr,int left,int right){
        if(right == left){
            return 0;
        }
        return Math.min(
          f(arr,left+1,right),
          f(arr,left,right -1)
        );
    }
    public static int getMax(int [] arr){
        int [][] dpf = new int[arr.length][arr.length];
        int [][] dpl = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dpf[i][i] =arr[i];
            dpl[i][i] = 0;
        }

        for (int j = 1; j <= arr.length-1 ; j++) {
            for (int i = 0; i < arr.length -j; i++) {
                dpf[i][i+j] = Math.max(arr[i]+dpl[i+1][i+j],arr[i+j]+dpl[i][i+j-1]);
                dpl[i][i+j] = Math.min(dpf[i+1][i+j],dpf[i][i+j-1]);
            }
        }

        return Math.max(dpf[0][arr.length-1],dpl[0][arr.length-1]);
    }
}
