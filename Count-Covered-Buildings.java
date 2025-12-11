1class Solution {
2    public int countCoveredBuildings(int n, int[][] buildings) {
3        Map<Integer,TreeSet<Integer>> rowToCol = new HashMap<>();
4        Map<Integer,TreeSet<Integer>>colToRow = new HashMap<>();
5        for(int building[]:buildings)
6        {
7            int x= building[0],y=building[1];
8            rowToCol.computeIfAbsent(x,k-> new TreeSet<>()).add(y);
9            colToRow.computeIfAbsent(y,k->new TreeSet<>()).add(x);
10        }
11        int cnt=0;
12        for(int building[]:buildings){
13            int x=building[0],y=building[1];
14
15            TreeSet<Integer>cols=rowToCol.get(x);
16            TreeSet<Integer>rows=colToRow.get(y);
17
18            Integer left = cols.lower(y);
19            Integer right=cols.higher(y);
20            Integer up=rows.lower(x);
21            Integer down=rows.higher(x);
22    
23            if((left!=null)&&(right!=null)&&(up!=null) &&(down!=null))
24            {
25                cnt++;
26            }
27
28
29        }
30        return cnt;
31    }
32}