1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        Arrays.sort(arr);
4        int minDiff = Integer.MAX_VALUE;
5        for(int i = 0; i < arr.length - 1; i ++) {
6            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
7        }
8        List<List<Integer>> res = new ArrayList<>();
9        for(int i = 0; i < arr.length - 1; i ++){
10            if (arr[i + 1] - arr[i] == minDiff) {
11                res.add(Arrays.asList(arr[i], arr[i + 1]));
12            }
13        }
14        return res;
15    }
16}