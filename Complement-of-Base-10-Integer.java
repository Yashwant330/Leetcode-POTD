1class Solution {
2    public int bitwiseComplement(int n) {
3        if(n==0) return 1;
4
5        int bits =(int )(Math.log(n)/Math.log(2))+1;
6        int mask=(1<<bits)-1;
7
8        return n^mask;
9    }
10}