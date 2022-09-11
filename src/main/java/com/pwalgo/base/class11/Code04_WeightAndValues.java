package com.pwalgo.base.class11;

import java.util.HashSet;

public class Code04_WeightAndValues {
    public static void main(String[] args) {

    }
    public static int getMaxValues(int [] weight, int [] values, int bag, int index, int nowWeight, int nowValues, HashSet<Integer> have){
        if(index == weight.length){
            return nowValues;
        }
        int max = nowValues;
        if(nowWeight + weight[index] > bag){
            for (Integer integer : have) {
                if(nowWeight - weight[integer] +weight[index] <= bag && values[index] > values[integer]){
                    have.remove(integer);
                    have.add(index);
                    nowValues = Math.max(nowValues,nowValues + values[index] - values[integer]);
                    nowWeight = nowWeight - weight[integer] +weight[index];
                    max = Math.max(max,getMaxValues(weight,values,bag,index+1,nowWeight,nowValues,have));
                    have.add(integer);
                    have.remove(index);
                }
            }
        }else {
            nowValues = nowValues + values[index];
            nowWeight = nowWeight + weight[index];
        }
        return Math.max(max,getMaxValues(weight,values,bag,index+1,nowWeight,nowValues,have));
    }
}
