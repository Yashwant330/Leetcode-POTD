1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        if(k<=1) return 0;
4        Arrays.sort(nums);
5        int ans=Integer.MAX_VALUE;
6
7        for(int i=0;i+k-1<nums.length;i++)
8        {
9            ans=Math.min(ans,nums[i+k-1]-nums[i]);
10        }
11        return ans;
12    }
13}