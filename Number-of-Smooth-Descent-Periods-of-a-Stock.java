1class Solution {
2    public long getDescentPeriods(int[] prices) {
3        long total = 1;
4        int current_length = 1;
5
6        for (int i = 1; i < prices.length; i++) {
7            if (prices[i] == prices[i - 1] - 1) {
8                current_length++;
9            } else {
10                current_length = 1;
11            }
12            total += current_length;
13        }
14
15        return total;
16    }
17}