1import java.util.*;
2
3class Solution {
4    public int numberOfSubmatrices(char[][] grid) {
5        int n = grid.length;
6        int m = grid[0].length;
7
8        int[][] sum = new int[n][m];
9        int[][] cntX = new int[n][m];
10
11        int res = 0;
12
13        for(int i = 0; i < n; i++){
14            for(int j = 0; j < m; j++){
15
16                int val = 0, x = 0;
17
18                if(grid[i][j] == 'X'){
19                    val = 1;
20                    x = 1;
21                }
22                else if(grid[i][j] == 'Y'){
23                    val = -1;
24                }
25
26                sum[i][j] = val;
27                cntX[i][j] = x;
28
29                if(i > 0){
30                    sum[i][j] += sum[i-1][j];
31                    cntX[i][j] += cntX[i-1][j];
32                }
33                if(j > 0){
34                    sum[i][j] += sum[i][j-1];
35                    cntX[i][j] += cntX[i][j-1];
36                }
37                if(i > 0 && j > 0){
38                    sum[i][j] -= sum[i-1][j-1];
39                    cntX[i][j] -= cntX[i-1][j-1];
40                }
41
42                if(sum[i][j] == 0 && cntX[i][j] > 0) res++;
43            }
44        }
45
46        return res;
47    }
48}