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
    public TreeNode invertTree(TreeNode root) {
        return swap(root);
    }

    TreeNode swap(TreeNode node){
        if(node == null){
            return null;
        }

        TreeNode left = swap(node.left);
        TreeNode right = swap(node.right);

        TreeNode temp = left;
        node.left = right;
        node.right = temp;

        return node;
    }
}