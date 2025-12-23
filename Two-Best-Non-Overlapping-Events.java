1import java.util.*;
2
3class Solution {
4    public int maxTwoEvents(int[][] events) {
5        Arrays.sort(events, (a, b) -> a[1] - b[1]);
6
7        int n = events.length;
8        int[] endT = new int[n];
9        int[] best = new int[n];
10
11        for (int i = 0; i < n; i++) {
12            endT[i] = events[i][1];
13            best[i] = events[i][2];
14            if (i > 0) best[i] = Math.max(best[i], best[i - 1]);
15        }
16
17        int ans = 0;
18
19        for (int i = 0; i < n; i++) {
20            int st = events[i][0];
21            int val = events[i][2];
22
23            int l = 0, r = n - 1, idx = -1;
24            while (l <= r) {
25                int mid = (l + r) >>> 1;
26                if (endT[mid] < st) {
27                    idx = mid;
28                    l = mid + 1;
29                } else {
30                    r = mid - 1;
31                }
32            }
33
34            if (idx != -1) ans = Math.max(ans, val + best[idx]);
35            ans = Math.max(ans, val);
36        }
37
38        return ans;
39    }
40}