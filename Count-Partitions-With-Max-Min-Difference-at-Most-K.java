1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        int n = nums.length, MOD = 1_000_000_007;
4        long[] dp = new long[n + 1];
5        dp[0] = 1;
6
7        java.util.Deque<Integer> mx = new java.util.ArrayDeque<>();
8        java.util.Deque<Integer> mn = new java.util.ArrayDeque<>();
9        long sum = 0;
10        int l = 0;
11
12        for (int r = 0; r < n; r++) {
13            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[r]) mx.pollLast();
14            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[r]) mn.pollLast();
15            mx.add(r);
16            mn.add(r);
17
18            while (nums[mx.peek()] - nums[mn.peek()] > k) {
19                if (mx.peek() == l) mx.poll();
20                if (mn.peek() == l) mn.poll();
21                sum = (sum - dp[l] + MOD) % MOD;
22                l++;
23            }
24
25            sum = (sum + dp[r]) % MOD;
26            dp[r + 1] = sum;
27        }
28        return (int) dp[n];
29    }
30}