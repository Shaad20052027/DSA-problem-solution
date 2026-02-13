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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findnode(root,x);
        TreeNode yy = findnode(root,y);

        return (
           (level(root,x,0) == level(root,y,0)) && (!isSibiling(root,xx,yy))
        );
    }
    TreeNode findnode(TreeNode node, int x){
        if(node == null){
            return null;
        }
        if(node.val == x){
            return node;
        }
        TreeNode left = findnode(node.left,x);
        if(left != null){
            return left;
        }
        return findnode(node.right,x);
    }
    int level(TreeNode node, int x, int lev){
        if(node == null){
            return 0;
        }
        if(node.val == x){
            return lev;
        }
        int l = level(node.left,x,lev+1);
        if(l != 0){
            return l;
        }
        return level(node.right,x,lev+1);
    }

    boolean isSibiling(TreeNode node, TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) ||isSibiling(node.left,x,y) || isSibiling(node.right,x,y));
    }
}