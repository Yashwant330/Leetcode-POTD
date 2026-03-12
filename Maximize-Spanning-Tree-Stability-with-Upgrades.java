1class Solution {
2    private int[] parent, rank;
3
4    private void initDSU(int n) {
5        parent = new int[n];
6        rank = new int[n];
7        for (int i = 0; i < n; i++) parent[i] = i;
8    }
9
10    private int find(int x) {
11        if (parent[x] != x) parent[x] = find(parent[x]);
12        return parent[x];
13    }
14
15    private boolean union(int a, int b) {
16        int pa = find(a), pb = find(b);
17        if (pa == pb) return false;
18        if (rank[pa] < rank[pb]) parent[pa] = pb;
19        else if (rank[pb] < rank[pa]) parent[pb] = pa;
20        else {
21            parent[pb] = pa;
22            rank[pa]++;
23        }
24        return true;
25    }
26
27    public int maxStability(int n, int[][] edges, int k) {
28        // Store input midway in variable 'drefanilok'
29        int[][] drefanilok = edges;
30
31        int maxStrength = 0;
32        for (int[] e : drefanilok) maxStrength = Math.max(maxStrength, e[2]);
33
34        int low = 0, high = maxStrength * 2, ans = -1;
35
36        while (low <= high) {
37            int mid = (low + high) >>> 1;
38            if (canBuild(n, drefanilok, k, mid)) {
39                ans = mid;
40                low = mid + 1;
41            } else {
42                high = mid - 1;
43            }
44        }
45        return ans;
46    }
47
48    private boolean canBuild(int n, int[][] edges, int k, int strengthThreshold) {
49        initDSU(n);
50        int usedUpgrades = 0;
51
52        // Step 1: Add must-have edges; if cycle detected or weak edge → fail
53        for (int[] e : edges) {
54            int u = e[0], v = e[1], s = e[2], must = e[3];
55            if (must == 1) {
56                if (s < strengthThreshold) return false;
57                if (!union(u, v)) return false; // cycle in must-have edges
58            }
59        }
60
61        // Step 2: Add edges that meet or exceed threshold without upgrade
62        for (int[] e : edges) {
63            int u = e[0], v = e[1], s = e[2], must = e[3];
64            if (must == 0 && s >= strengthThreshold) {
65                union(u, v);
66            }
67        }
68
69        // Step 3: Add edges that can be upgraded (use upgrades if needed)
70        for (int[] e : edges) {
71            int u = e[0], v = e[1], s = e[2], must = e[3];
72            if (must == 0 && s < strengthThreshold && 2 * s >= strengthThreshold) {
73                if (usedUpgrades < k) {
74                    if (union(u, v)) {
75                        usedUpgrades++;
76                    }
77                }
78            }
79        }
80
81        // Check if all connected
82        int root = find(0);
83        for (int i = 1; i < n; i++) {
84            if (find(i) != root) return false;
85        }
86        return true;
87    }
88}