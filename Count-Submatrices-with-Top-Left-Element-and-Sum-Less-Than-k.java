1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int total = 0;
4        for(int row = 0; row < grid.length; row++) {
5            int sum = 0;
6            for(int col = 0; col < grid[row].length; col++) {
7                sum += grid[row][col];
8                if(sum <= k) total++;
9                if(row < grid.length-1) grid[row+1][col] += grid[row][col];
10            }
11        }
12        return total;
13    }
14}