1class Solution {
2    private static final int MAX_SIZE = 100001;
3    private static long[] prefixSum = new long[MAX_SIZE];
4    
5    public long maxProfit(int[] prices, int[] strategy, int k) {
6        int n = prices.length, half = k / 2;
7        Arrays.fill(prefixSum, 0, n + 1, 0);
8        
9        for (int i = 0; i < n; i++) {
10            prefixSum[i + 1] = prefixSum[i] + (long) strategy[i] * prices[i];
11        }
12        
13        long windowSum = 0;
14        for (int i = half; i < k; i++) {
15            windowSum += prices[i];
16        }
17        long maxProfit = Math.max(prefixSum[n], windowSum + prefixSum[n] - prefixSum[k]);
18        
19        for (int start = 1; start + k <= n; start++) {
20            windowSum += prices[start + k - 1] - prices[start + half - 1];
21            maxProfit = Math.max(maxProfit, windowSum + prefixSum[n] - prefixSum[start + k] + prefixSum[start]);
22        }
23        
24        return maxProfit;
25    }
26}