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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxSum(root);
        return max;
    }

    int maxSum(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(0, maxSum(node.left));
        int rightSum = Math.max(0, maxSum(node.right));

        max = Math.max(max, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}