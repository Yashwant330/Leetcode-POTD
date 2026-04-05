1class Solution {
2    public boolean judgeCircle(String moves) {
3        int count_v=0, count_h=0;
4
5        for(int i=0;i<moves.length();i++)
6        {
7            char ch = moves.charAt(i);
8            if(ch =='U') count_v++;
9            else if (ch=='D') count_v--;
10            else if (ch == 'R') count_h++;
11            else count_h--;
12        }
13
14        return count_v==0 && count_h == 0;
15    }
16}