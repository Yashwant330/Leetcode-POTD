1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int sum=0;
4        for(int num:nums)
5        {
6            sum +=num;
7        }
8        return sum%k;
9    }
10}