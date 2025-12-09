1class Solution {
2    int mod = 1000000007;
3    public int specialTriplets(int[] nums) {
4        int n = nums.length;
5        Map<Integer, Integer> mapLeft = new HashMap<>();
6        Map<Integer, Integer> mapRight = new HashMap<>();
7        long cnt = 0;
8        for(int i=2; i<n; i++){
9            mapRight.put(nums[i], mapRight.getOrDefault(nums[i], 0)+1);
10        }
11        mapLeft.put(nums[0], 1);
12        int i=1;
13        while(i<nums.length-1){
14            int req = 2 * nums[i];
15            if(mapLeft.containsKey(req) && mapRight.containsKey(req)){
16                int n1 = mapLeft.get(req);
17                int n2 = mapRight.get(req);
18                cnt = (cnt + ((long)n1 * (long)n2) % mod) % mod;
19            } 
20            mapLeft.put(nums[i], mapLeft.getOrDefault(nums[i], 0)+1);
21            if(i+1 < nums.length){
22                mapRight.put(nums[i+1], mapRight.get(nums[i+1])-1);
23                if(mapRight.get(nums[i+1]) == 0){
24                    mapRight.remove(nums[i+1]);
25                }
26            }
27            i++;
28        }
29        return (int)cnt;
30    }
31}