1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5
6        // Convert strings to char arrays once
7        // This avoids repeated charAt() calls inside nested loops
8        char[][] a = new char[n][];
9        for (int i = 0; i < n; i++) {
10            a[i] = strs[i].toCharArray();
11        }
12
13        // resolved[i] = true means:
14        // strs[i] is already strictly smaller than strs[i+1]
15        // considering previously kept columns
16        boolean[] resolved = new boolean[n - 1];
17
18        // Number of adjacent row pairs whose order is still undecided
19        int unresolved = n - 1;
20
21        int deletions = 0;
22
23        // Process columns left to right
24        for (int col = 0; col < m && unresolved > 0; col++) {
25            boolean needDelete = false;
26
27            // Check if keeping this column breaks lexicographical order
28            for (int row = 0; row < n - 1; row++) {
29                // Only compare rows whose order is not yet fixed
30                if (!resolved[row] && a[row][col] > a[row + 1][col]) {
31                    needDelete = true;
32                    break;
33                }
34            }
35
36            // If this column violates order, delete it
37            if (needDelete) {
38                deletions++;
39                continue;
40            }
41
42            // Otherwise, update which row pairs become strictly ordered
43            for (int row = 0; row < n - 1; row++) {
44                if (!resolved[row] && a[row][col] < a[row + 1][col]) {
45                    resolved[row] = true;
46                    unresolved--;
47                }
48            }
49        }
50
51        return deletions;
52    }
53}