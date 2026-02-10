1class Solution {
2    private static int[] seen = new int[100001];
3    private static int leet = 0;
4    public int longestBalanced(int[] nums) {
5        leet++; 
6        int n = nums.length;
7        int res = 0;
8
9        for (int i = 0; i < n; i++) {
10            int[] A = new int[2];
11            int marker = (leet << 16) | (i + 1);
12            for (int j = i; j < n; j++) {
13                int val = nums[j];
14                if (seen[val] != marker) {
15                    seen[val] = marker;
16                    A[val & 1]++;
17                }
18
19                if (A[0] == A[1])
20                    res = Math.max(res, j - i + 1);
21            }
22        }
23
24        return res;
25    }
26}
27