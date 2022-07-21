package com.pwalgo.skill01;

public class EvenTimesOddTimes {
    public static void main(String[] args) {
        int [] arr = new int[]{3,2,1,1};
        int[] ints = oddTimesValues(arr);
        System.out.println(ints[0]+":"+arr[1]);
    }
    public static int evenTimesValue(int [] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }
    public static int [] oddTimesValues(int [] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int eorA = eor^(~eor);
        int eorB = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i]^eorA) !=0){
                eorB ^= arr[i];
            }
        }
        return new int[]{eorB,eorB^eor};
    }
}
