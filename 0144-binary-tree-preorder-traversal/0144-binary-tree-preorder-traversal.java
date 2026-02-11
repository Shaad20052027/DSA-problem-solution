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
    public List<Integer> preorderTraversal(TreeNode root) {
        return helper(root);
    }
    public List<Integer> helper(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.val);
        result.addAll(helper(root.left));
        result.addAll(helper(root.right));

        return result;
    }

}