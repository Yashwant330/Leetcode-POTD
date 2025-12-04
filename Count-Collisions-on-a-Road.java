1class Solution {
2    public int countCollisions(String directions) {
3        int n = directions.length(), collisions = 0;
4        int i = 0, j = n - 1;
5
6        while (i < n && directions.charAt(i) == 'L') i++;
7        while (j >= 0 && directions.charAt(j) == 'R') j--;
8
9        for (int k = i; k <= j; k++)
10            if (directions.charAt(k) != 'S')
11                collisions++;
12
13        return collisions;
14    }
15}