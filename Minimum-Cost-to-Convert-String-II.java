1class Solution {
2
3    class TrieNode {
4        TrieNode[] next = new TrieNode[26];
5        int id = -1;
6    }
7
8    private int uniqueIDCounter = 0;
9
10    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
11
12        TrieNode root = new TrieNode();
13        for (String s : original) insert(root, s);
14        for (String s : changed) insert(root, s);
15
16        int numNodes = uniqueIDCounter;
17        long[][] dist = new long[numNodes][numNodes];
18        for (int i = 0; i < numNodes; i++) {
19            Arrays.fill(dist[i], Long.MAX_VALUE);
20            dist[i][i] = 0;
21        }
22
23        for (int i = 0; i < cost.length; i++) {
24            int u = getID(root, original[i]);
25            int v = getID(root, changed[i]);
26            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
27        }
28
29        for (int k = 0; k < numNodes; k++) {
30            for (int i = 0; i < numNodes; i++) {
31                if (dist[i][k] == Long.MAX_VALUE) continue;
32                for (int j = 0; j < numNodes; j++) {
33                    if (dist[k][j] == Long.MAX_VALUE) continue;
34                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
35                }
36            }
37        }
38
39        int n = source.length();
40        long[] dp = new long[n + 1];
41        Arrays.fill(dp, Long.MAX_VALUE);
42        dp[0] = 0;
43
44        for (int i = 0; i < n; i++) {
45            if (dp[i] == Long.MAX_VALUE) continue;
46
47            if (source.charAt(i) == target.charAt(i)) {
48                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
49            }
50
51            TrieNode p1 = root;
52            TrieNode p2 = root;
53
54            for (int j = i; j < n; j++) {
55                p1 = p1.next[source.charAt(j) - 'a'];
56                p2 = p2.next[target.charAt(j) - 'a'];
57
58                if (p1 == null || p2 == null) break;
59
60                if (p1.id != -1 && p2.id != -1 && dist[p1.id][p2.id] != Long.MAX_VALUE) {
61                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + dist[p1.id][p2.id]);
62                }
63            }
64        }
65
66        return dp[n] == Long.MAX_VALUE ? -1 : dp[n];
67    }
68
69    private void insert(TrieNode root, String s) {
70        TrieNode node = root;
71        for (char c : s.toCharArray()) {
72            if (node.next[c - 'a'] == null) {
73                node.next[c - 'a'] = new TrieNode();
74            }
75            node = node.next[c - 'a'];
76        }
77        if (node.id == -1) node.id = uniqueIDCounter++;
78    }
79
80    private int getID(TrieNode root, String s) {
81        TrieNode node = root;
82        for (char c : s.toCharArray()) {
83            node = node.next[c - 'a'];
84        }
85        return node.id;
86    }
87}