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
    int pathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return pathSum;
    }
    int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,helper(node.left));
        int right = Math.max(0,helper(node.right));
        int path = left + right + node.val;

        pathSum = Math.max(path,pathSum);

        return node.val + Math.max(left,right);
    }
}