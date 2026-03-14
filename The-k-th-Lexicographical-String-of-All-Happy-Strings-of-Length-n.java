1// Added using AI
2class Solution {
3    public String getHappyString(int n, int k) {
4        int sz = (int) Math.pow(2, n - 1);
5        if (3 * sz < k) return "";
6
7        String[] opts = {"bc", "ac", "ab"};
8        StringBuilder res = new StringBuilder();
9
10        if      (k <= sz)     res.append('a');
11        else if (k <= 2 * sz) { res.append('b'); k -= sz; }
12        else                  { res.append('c'); k -= 2 * sz; }
13
14        for (int i = 1; i < n; i++) {
15            sz /= 2;
16            String ch = opts[res.charAt(res.length() - 1) - 'a'];
17            if (k <= sz) res.append(ch.charAt(0));
18            else       { res.append(ch.charAt(1)); k -= sz; }
19        }
20        return res.toString();
21    }
22}