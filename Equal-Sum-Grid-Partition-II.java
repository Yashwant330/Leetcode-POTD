1class Solution {
2
3    boolean canRemove(int r1, int c1, int r2, int c2, int i, int j) {
4        int rows = r2 - r1 + 1;
5        int cols = c2 - c1 + 1;
6
7        if (rows * cols == 1) return false;
8
9        if (rows == 1) {
10            return (j == c1 || j == c2);
11        }
12
13        if (cols == 1) {
14            return (i == r1 || i == r2);
15        }
16
17        return true;
18    }
19
20    public boolean canPartitionGrid(int[][] grid) {
21        int n = grid.length;
22        int m = grid[0].length;
23
24        long[] prefRow = new long[n];
25        long[] prefCol = new long[m];
26
27        Map<Long, List<int[]>> mp = new HashMap<>();
28
29        for (int i = 0; i < n; i++) {
30            long val = 0;
31            for (int j = 0; j < m; j++) {
32                val += grid[i][j];
33                mp.computeIfAbsent((long)grid[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
34            }
35            prefRow[i] = val + (i > 0 ? prefRow[i - 1] : 0);
36        }
37
38        for (int j = 0; j < m; j++) {
39            long val = 0;
40            for (int i = 0; i < n; i++) {
41                val += grid[i][j];
42            }
43            prefCol[j] = val + (j > 0 ? prefCol[j - 1] : 0);
44        }
45
46        long total = prefRow[n - 1];
47
48        for (int i = 0; i < n - 1; i++) {
49            long top = prefRow[i];
50            long bottom = total - top;
51
52            if (top == bottom) return true;
53
54            long diff = Math.abs(top - bottom);
55
56            if (!mp.containsKey(diff)) continue;
57
58            if (top > bottom) {
59                for (int[] p : mp.get(diff)) {
60                    int x = p[0], y = p[1];
61                    if (x <= i && canRemove(0, 0, i, m - 1, x, y)) return true;
62                }
63            } else {
64                for (int[] p : mp.get(diff)) {
65                    int x = p[0], y = p[1];
66                    if (x > i && canRemove(i + 1, 0, n - 1, m - 1, x, y)) return true;
67                }
68            }
69        }
70
71        for (int j = 0; j < m - 1; j++) {
72            long left = prefCol[j];
73            long right = total - left;
74
75            if (left == right) return true;
76
77            long diff = Math.abs(left - right);
78
79            if (!mp.containsKey(diff)) continue;
80
81            if (left > right) {
82                for (int[] p : mp.get(diff)) {
83                    int x = p[0], y = p[1];
84                    if (y <= j && canRemove(0, 0, n - 1, j, x, y)) return true;
85                }
86            } else {
87                for (int[] p : mp.get(diff)) {
88                    int x = p[0], y = p[1];
89                    if (y > j && canRemove(0, j + 1, n - 1, m - 1, x, y)) return true;
90                }
91            }
92        }
93
94        return false;
95    }
96}