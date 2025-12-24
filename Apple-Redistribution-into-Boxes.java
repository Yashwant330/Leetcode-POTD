1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3        int total=0;
4        for(int a:apple)
5        {
6            total +=a;
7        }
8        Arrays.sort(capacity);
9         int cnt=0;
10
11         for(int i=capacity.length-1;i>=0;i--)
12         {
13            total-=capacity[i];
14            cnt++;
15            if(total<=0)
16            {
17                return cnt;
18            }
19         }
20         return cnt;
21    }
22}