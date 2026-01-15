1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        Arrays.sort(hBars);
4        Arrays.sort(vBars);
5        return (int)Math.pow(Math.min(maxSpan(hBars), maxSpan(vBars)), 2);
6    }
7
8    private int maxSpan(int[] bars) {
9        int res = 1;
10        int streak = 1;
11        for (int i = 1; i < bars.length; i++) {
12            if (bars[i] == bars[i - 1] + 1) {
13                streak++;
14                continue;
15            }
16            res = Math.max(res, ++streak);
17            streak = 1;
18        }
19        return Math.max(res, ++streak);
20    }
21}
22