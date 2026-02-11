1class Solution {
2
3    static class Node {
4        int l, r;
5        int mn, mx;
6        int lazy;
7    }
8
9    static class SegmentTree {
10        Node[] tr;
11
12        SegmentTree(int n) {
13            tr = new Node[n << 2];
14            for (int i = 0; i < tr.length; i++) {
15                tr[i] = new Node();
16            }
17            build(1, 0, n);
18        }
19
20        void build(int u, int l, int r) {
21            tr[u].l = l;
22            tr[u].r = r;
23            tr[u].mn = tr[u].mx = 0;
24            tr[u].lazy = 0;
25            if (l == r) return;
26            int mid = (l + r) >> 1;
27            build(u << 1, l, mid);
28            build(u << 1 | 1, mid + 1, r);
29        }
30
31        void modify(int u, int l, int r, int v) {
32            if (tr[u].l >= l && tr[u].r <= r) {
33                apply(u, v);
34                return;
35            }
36            pushdown(u);
37            int mid = (tr[u].l + tr[u].r) >> 1;
38            if (l <= mid) modify(u << 1, l, r, v);
39            if (r > mid) modify(u << 1 | 1, l, r, v);
40            pushup(u);
41        }
42
43        int query(int u, int target) {
44            if (tr[u].l == tr[u].r) {
45                return tr[u].l;
46            }
47            pushdown(u);
48            int left = u << 1;
49            int right = u << 1 | 1;
50            if (tr[left].mn <= target && target <= tr[left].mx) {
51                return query(left, target);
52            }
53            return query(right, target);
54        }
55
56        void apply(int u, int v) {
57            tr[u].mn += v;
58            tr[u].mx += v;
59            tr[u].lazy += v;
60        }
61
62        void pushup(int u) {
63            tr[u].mn = Math.min(tr[u << 1].mn, tr[u << 1 | 1].mn);
64            tr[u].mx = Math.max(tr[u << 1].mx, tr[u << 1 | 1].mx);
65        }
66
67        void pushdown(int u) {
68            if (tr[u].lazy != 0) {
69                apply(u << 1, tr[u].lazy);
70                apply(u << 1 | 1, tr[u].lazy);
71                tr[u].lazy = 0;
72            }
73        }
74    }
75
76    public int longestBalanced(int[] nums) {
77        int n = nums.length;
78        SegmentTree st = new SegmentTree(n);
79        Map<Integer, Integer> last = new HashMap<>();
80        int now = 0;
81        int ans = 0;
82
83        for (int i = 1; i <= n; i++) {
84            int x = nums[i - 1];
85            int det = (x & 1) == 1 ? 1 : -1;
86
87            if (last.containsKey(x)) {
88                st.modify(1, last.get(x), n, -det);
89                now -= det;
90            }
91
92            last.put(x, i);
93            st.modify(1, i, n, det);
94            now += det;
95
96            int pos = st.query(1, now);
97            ans = Math.max(ans, i - pos);
98        }
99
100        return ans;
101    }
102}