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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        helper(root, "");

        return ans;
    }

    void helper(TreeNode node, String path){
        if(node.left == null && node.right == null){
            ans.add(path + node.val);
        }

        if(node.left != null){
            helper(node.left, path + node.val + "->");
        }

        if(node.right != null){
            helper(node.right, path + node.val + "->");
        }
    }
}