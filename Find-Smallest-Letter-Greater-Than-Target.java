1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int left = 0;
4        int right = letters.length - 1;
5
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8            if (letters[mid] <= target) {
9                left = mid + 1;
10            } else {
11                right = mid - 1;
12            }
13        }
14
15        return letters[left % letters.length];
16    }
17}