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
    int ans = Integer.MIN_VALUE;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }
    boolean helper(TreeNode node, int target){
        if(node == null){
            return false;
        }
        
        if(node.left == null && node.right == null && node.val == target){
            return true;
        }
        return helper(node.left,target - node.val) || helper(node.right, target - node.val);
    }
}