1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        Arrays.sort(happiness);
4        int count = 0;
5        long res = 0;
6        for(int i=happiness.length-1;i>=happiness.length-k;i--)
7        {
8            if(happiness[i]+count>0)
9            {
10                res+=(long)(happiness[i]+count);
11            }
12            count--;
13        }
14        return res;
15    }
16}