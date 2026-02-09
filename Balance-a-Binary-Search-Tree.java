1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    // Inorder traversal to collect BST elements in sorted order
19    private void inorder(TreeNode root, List<Integer> nodes) {
20        if (root == null) return;
21        inorder(root.left, nodes);
22        nodes.add(root.val);
23        inorder(root.right, nodes);
24    }
25
26    // Build a height-balanced BST from sorted list
27    private TreeNode buildBST(int left, int right, List<Integer> nodes) {
28        if (left > right) return null;
29
30        int mid = (left + right) / 2; // choose middle element as root
31        TreeNode root = new TreeNode(nodes.get(mid));
32
33        // Recursively build left and right subtrees
34        root.left = buildBST(left, mid - 1, nodes);
35        root.right = buildBST(mid + 1, right, nodes);
36
37        return root;
38    }
39
40    public TreeNode balanceBST(TreeNode root) {
41        List<Integer> nodes = new ArrayList<>();
42
43        // Step 1: Store inorder traversal of BST
44        inorder(root, nodes);
45
46        // Step 2: Build balanced BST from sorted values
47        return buildBST(0, nodes.size() - 1, nodes);
48    }
49}