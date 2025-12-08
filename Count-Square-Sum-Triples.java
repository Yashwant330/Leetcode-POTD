1class Solution {
2    public int countTriples(int n) {
3        int count = 0;
4
5        for (int a = 1; a <= n; a++) {
6            for (int b = 1; b <= n; b++) {
7                int sum = a * a + b * b;
8                int c = (int) Math.sqrt(sum);
9                if (c <= n && c * c == sum) {
10                    count++;
11                }
12            }
13        }
14        return count;
15    }
16}
17