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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        helper(root, 0);
        return ans;
    }

    void helper(TreeNode node, int level){
        if(node == null) return;

        if(level == ans.size()){
            ans.add(node.val);
        }

        helper(node.right, level + 1);
        helper(node.left, level + 1);
    }
}