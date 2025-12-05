1class Solution {
2    public int countPartitions(int[] nums) {
3        int n = nums.length;
4        int ts = 0;
5        for(int i : nums) ts += i;
6        int cs = 0;
7        int count = 0;
8        for(int i = 0;i<n-1;i++){
9            cs += nums[i];
10            ts -= nums[i];
11            if((ts-cs)%2==0) count++;
12        }
13        return count;
14    }
15}