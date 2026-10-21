class Solution {
    public int missingNumber(int[] nums) {
        
  int xorSum=0;
  for(int n:nums)
  {
    xorSum=xorSum^n;
  }
  for(int i=0;i<=nums.length;i++)
  {
    xorSum=xorSum^i;
  }
  return xorSum;
    }
}