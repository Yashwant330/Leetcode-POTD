1// This solution was implemented with assistance from ChatGPT
2class Solution {
3
4    public int[][] constructProductMatrix(int[][] grid) {
5        final int MOD = 12345;
6        int n = grid.length;
7        int m = grid[0].length;
8        int[][] p = new int[n][m];
9
10        long suffix = 1;
11        for (int i = n - 1; i >= 0; i--) {
12            for (int j = m - 1; j >= 0; j--) {
13                p[i][j] = (int) suffix;
14                suffix = (suffix * grid[i][j]) % MOD;
15            }
16        }
17
18        long prefix = 1;
19        for (int i = 0; i < n; i++) {
20            for (int j = 0; j < m; j++) {
21                p[i][j] = (int) (((long) p[i][j] * prefix) % MOD);
22                prefix = (prefix * grid[i][j]) % MOD;
23            }
24        }
25
26        return p;
27    }
28}