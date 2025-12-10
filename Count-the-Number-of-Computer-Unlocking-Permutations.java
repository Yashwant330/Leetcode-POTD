1class Solution {
2    public int countPermutations(int[] complexity) {
3        int mod=1000000007;
4        long ans=1;
5        for(int i=1;i<complexity.length;i++)
6        {
7            if(complexity[i]<=complexity[0]) return 0;
8            else ans =(ans * i)  % mod;
9        }
10        return(int) ans;
11    }
12}