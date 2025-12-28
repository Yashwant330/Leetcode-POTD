1class Solution {
2    public int countNegatives(int[][] grid) {
3        int m=grid.length,n=grid[0].length;
4        int i=m-1,j=0;
5
6        int res=0;
7
8        while(i>=0&&j<n)
9        {
10            if(grid[i][j]<0)
11            {
12                res+=n-j;
13                i--;
14            }
15            else
16            j++;
17        }
18        return res;
19    }
20}