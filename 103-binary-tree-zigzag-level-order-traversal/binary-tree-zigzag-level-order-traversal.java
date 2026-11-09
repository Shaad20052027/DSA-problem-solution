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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            List<Integer> current = new ArrayList<>();
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++){
                if(!reverse){
                    TreeNode curr = q.pollFirst();
                    current.add(curr.val);
                    if(curr.left != null){
                        q.offerLast(curr.left);
                    }
                    if(curr.right != null){
                        q.offerLast(curr.right);
                    }
                }

                if(reverse){
                    TreeNode curr = q.pollLast();
                    current.add(curr.val);
                    if(curr.right != null){
                        q.offerFirst(curr.right);
                    }
                    if(curr.left != null){
                        q.offerFirst(curr.left);
                    }
                }
            }
            reverse = !reverse;
            res.add(current);
        }
        return res;
    }
}