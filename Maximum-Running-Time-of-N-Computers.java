1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        long sum = 0;
4        for (int b : batteries) {
5            sum += b;
6        }
7
8        long left = 0, right = sum / n;
9
10        while (left < right) {
11            long mid = (left + right + 1) / 2;
12
13            long total = 0;
14            for (int b : batteries) {
15                total += Math.min(b, mid);
16            }
17
18            if (total >= mid * n) {
19                left = mid;
20            } else {
21                right = mid - 1;  
22            }
23        }
24        return left;
25    }
26}
27