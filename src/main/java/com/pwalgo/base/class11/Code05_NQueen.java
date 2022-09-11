package com.pwalgo.base.class11;

public class Code05_NQueen {
    public static void main(String[] args) {
        //System.out.println(nQueen(8));
        for (int i = 1; i < 25; i++) {
            System.out.println(nQueen(i));
        }
    }
    public static int nQueen(int N){
        return N<=32?nQueen2((1<<N) -1,0,0,0):-1;
    }


    public static int nQueen1(int i,int N,int [] record){
        if(i == N){
            return 1;
        }
        int res = 0;
        for (int j = 0;j < N;j++){
            if(isValid(i,j,record)){
                record[i] = j;
                res += nQueen1(i+1,N,record);
                //record[i] = 0;
            }
        }
        return res;
    }
    public static boolean isValid(int i,int j,int [] record){
//       int identity = 1;
//       while(i-identity >= 0){
//           if(record[i-identity] == j-identity || record[i-identity] == j + identity || record[i-identity] == j){
//               return false;
//           }
//           identity++;
//       }
        for (int k = 0; k < i; k++) {
            if(record[k] == j || Math.abs(record[k]-j) == Math.abs(k-i)){
                return false;
            }
        }
        return true;
    }
    public static int nQueen2(int x,int collimit,int leftlimit,int rightlimit){
        if(collimit == x){
            return 1;
        }
        int res = 0;

        int limit = collimit|leftlimit|rightlimit;
        int col = x &(~limit);
        int pos = 0;

        while(col != 0){
            pos = col&(~col +1);
            res+=nQueen2(x,collimit|pos,leftlimit<<1|pos<<1,rightlimit>>1|pos>>1);
            col ^= pos;
        }
        return res;
    }
}
