1class Solution {
2    public int minimumCost(int[] nums) {
3        int first = nums[0];
4
5        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
6
7        for (int i = 1; i < nums.length; i++) {
8            if (nums[i] < num1) {
9                num2 = num1;
10                num1 = nums[i];
11            } else if (nums[i] < num2) {
12                num2 = nums[i];
13            }
14        }
15
16        return first + num1 + num2;
17    }
18}