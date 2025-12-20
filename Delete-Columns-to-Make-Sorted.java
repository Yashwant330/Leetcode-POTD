1class Solution {
2    public boolean isSortedColumn(int col, String[] strs) {
3        for(int i=1;i<strs.length;i++) {
4            if(strs[i].charAt(col) < strs[i-1].charAt(col))
5                return false;
6        }
7        return true;
8    }
9    public int minDeletionSize(String[] strs) {
10        int count = 0;
11        for(int i=0;i<strs[0].length();i++) {
12            if(!isSortedColumn(i, strs)) {
13                count++;
14            }
15        }
16        return count;
17    }
18}