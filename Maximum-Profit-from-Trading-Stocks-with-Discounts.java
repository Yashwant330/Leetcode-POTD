1class Solution {
2
3    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
4        // Build tree
5        List<Integer>[] tree = new List[n];
6        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
7        for (int[] edge : hierarchy) {
8            tree[edge[0] - 1].add(edge[1] - 1);
9        }
10
11        int[][][] dp = new int[n][2][budget + 1];  // [node][parentBought][budget]
12        dfs(0, present, future, tree, dp, budget);
13
14        // Answer is the max profit in dp[0][0][b] for any b <= budget
15        int ans = 0;
16        for (int b = 0; b <= budget; b++) {
17            ans = Math.max(ans, dp[0][0][b]);
18        }
19        return ans;
20    }
21
22    private void dfs(int u, int[] present, int[] future, List<Integer>[] tree,
23                            int[][][] dp, int budget) {
24        // Base case: no children, init to 0
25        for (int b = 0; b <= budget; b++) dp[u][0][b] = dp[u][1][b] = 0;
26
27        // For each child, process recursively
28        List<int[][]> childDPs = new ArrayList<>();
29        for (int v : tree[u]) {
30            dfs(v, present, future, tree, dp, budget);
31            childDPs.add(new int[][]{dp[v][0], dp[v][1]});
32        }
33
34        // For parentNotBought and parentBought
35        for (int parentBought = 0; parentBought <= 1; parentBought++) {
36            int price = parentBought == 1 ? present[u] / 2 : present[u];
37            int profit = future[u] - price;
38
39            // Create DP array to fill for this u
40            int[] curr = new int[budget + 1];
41
42            // Option 1: don't buy u
43            int[] base = new int[budget + 1];
44            base[0] = 0;
45            for (int[][] child : childDPs) {
46                int[] next = new int[budget + 1];
47                for (int b1 = 0; b1 <= budget; b1++) {
48                    for (int b2 = 0; b1 + b2 <= budget; b2++) {
49                        next[b1 + b2] = Math.max(next[b1 + b2], base[b1] + child[0][b2]);
50                    }
51                }
52                base = next;
53            }
54
55            for (int b = 0; b <= budget; b++) {
56                curr[b] = Math.max(curr[b], base[b]); // not buying u
57            }
58
59            // Option 2: buy u
60            if (price <= budget) {
61                int[] baseBuy = new int[budget + 1];
62                baseBuy[0] = 0;
63                for (int[][] child : childDPs) {
64                    int[] next = new int[budget + 1];
65                    for (int b1 = 0; b1 <= budget; b1++) {
66                        for (int b2 = 0; b1 + b2 <= budget; b2++) {
67                            next[b1 + b2] = Math.max(next[b1 + b2], baseBuy[b1] + child[1][b2]);
68                        }
69                    }
70                    baseBuy = next;
71                }
72
73                for (int b = price; b <= budget; b++) {
74                    curr[b] = Math.max(curr[b], baseBuy[b - price] + profit);
75                }
76            }
77
78            dp[u][parentBought] = curr;
79        }
80    }
81}