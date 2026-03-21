1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        int m = grid.length, n = grid[0].length;
4
5        for (int i = 0; i < k / 2; i++) {
6            int top_row = x + i, bottom_row = x + k - 1 - i;
7
8            for (int j = y; j < y + k; j++) {
9                int temp = grid[top_row][j];
10                grid[top_row][j] = grid[bottom_row][j];
11                grid[bottom_row][j] = temp;
12            }
13        }
14
15        return grid;
16    }
17}