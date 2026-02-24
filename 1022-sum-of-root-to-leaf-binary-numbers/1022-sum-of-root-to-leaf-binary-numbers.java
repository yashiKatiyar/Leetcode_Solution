/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentBinaryValue) {
        // Base case: if node is null, contribute 0 to the sum
        if (node == null) {
            return 0;
        }
      
        currentBinaryValue = (currentBinaryValue << 1) | node.val;
      
        // If this is a leaf node, return the complete binary number
        if (node.left == null && node.right == null) {
            return currentBinaryValue;
        }
      
        // Recursively calculate sum for left and right subtrees
        return dfs(node.left, currentBinaryValue) + dfs(node.right, currentBinaryValue);
    }
    
}