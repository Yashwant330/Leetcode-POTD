1class Solution {
2
3  private static final int INF = Integer.MAX_VALUE / 2;
4
5  public int minCost(int n, int[][] edges) {
6
7   
8      List<List<int[]>> graph = new ArrayList<>();
9      for (int i = 0; i < n; i++) {
10          graph.add(new ArrayList<>());
11      }
12
13   
14      for (int[] e : edges) {
15          int u = e[0], v = e[1], w = e[2];
16          graph.get(u).add(new int[]{v, w});
17          graph.get(v).add(new int[]{u, w * 2});
18      }
19
20   
21      int[] dist = new int[n];
22      Arrays.fill(dist, INF);
23      dist[0] = 0;
24
25     
26      PriorityQueue<int[]> pq = new PriorityQueue<>(
27          (a, b) -> Integer.compare(a[0], b[0])
28      );
29
30      pq.offer(new int[]{0, 0}); 
31
32      while (!pq.isEmpty()) {
33          int[] cur = pq.poll();
34          int d = cur[0], node = cur[1];
35
36          if (d > dist[node]) continue;
37
38          for (int[] edge : graph.get(node)) {
39              int next = edge[0], cost = edge[1];
40              if (dist[next] > d + cost) {
41                  dist[next] = d + cost;
42                  pq.offer(new int[]{dist[next], next});
43              }
44          }
45      }
46
47      return dist[n - 1] >= INF ? -1 : dist[n - 1];
48  }
49}
50