1class Solution {
2    public long largestSquareArea(int[][] bottom_left, int[][] top_right) {
3        int n = bottom_left.length;
4        long max_side = 0;
5
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                int width = 
9                    Math.min(top_right[i][0], top_right[j][0]) - 
10                    Math.max(bottom_left[i][0], bottom_left[j][0]);
11                int height = 
12                    Math.min(top_right[i][1], top_right[j][1]) - 
13                    Math.max(bottom_left[i][1], bottom_left[j][1]);
14                int side = Math.min(width, height);
15
16                max_side = Math.max(max_side, side);
17            }
18        }
19
20        return max_side * max_side;
21    }
22}