1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        return height(root) != -1;
4    }
5
6    private int height(TreeNode root) {
7        if (root == null) {
8            return 0; 
9        }
10
11        int leftHeight = height(root.left);
12        int rightHeight = height(root.right);
13
14        
15        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
16            return -1;
17        }
18        
19        return Math.max(leftHeight, rightHeight) + 1;
20    }
21}