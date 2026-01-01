1class Solution {
2    public int[] plusOne(int[] digits) {
3        for(int i=digits.length-1;i>=0;i--)
4        {
5            if(digits[i]<9)
6            {
7                digits[i]++;
8                return digits;
9            }
10            digits[i]=0;
11        }
12        int[]res=new int[digits.length+1];
13        res[0]=1;
14        return res;
15    }
16}