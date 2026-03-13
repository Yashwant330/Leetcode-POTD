1import java.util.*;
2
3class Solution {
4    public long minNumberOfSeconds(int h, int[] t) {
5
6        PriorityQueue<long[]> pq = new PriorityQueue<>(
7            (a, b) -> Long.compare(a[0], b[0])
8        );
9
10        for(int i = 0; i < t.length; i++){
11            pq.add(new long[]{t[i], i, 1});
12        }
13
14        long res = 0;
15
16        while(h > 0){
17            long[] cur = pq.poll();
18
19            long tm = cur[0];
20            int id = (int)cur[1];
21            int x = (int)cur[2];
22
23            res = tm;
24            h--;
25
26            if(h > 0){
27                long nx = x + 1;
28                long nt = (long)t[id] * (nx * (nx + 1) / 2);
29                pq.add(new long[]{nt, id, nx});
30            }
31        }
32
33        return res;
34    }
35}