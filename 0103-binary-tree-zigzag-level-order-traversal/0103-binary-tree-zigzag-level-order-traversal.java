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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> current = new ArrayList<>();
            for(int i = 0; i < levelsize; i++){
                if(!reverse){
                    TreeNode curr = queue.pollFirst();
                    current.add(curr.val);
                    if(curr.left != null){
                        queue.addLast(curr.left);
                    }
                    if(curr.right != null){
                        queue.addLast(curr.right);
                    }  
                }
                if(reverse){
                   TreeNode curr = queue.pollLast();
                   current.add(curr.val);
                   if(curr.right != null){
                    queue.addFirst(curr.right);
                   }
                   if(curr.left != null){
                    queue.addFirst(curr.left);
                   }
                }
            } 
            reverse = !reverse;
            result.add(current);         
        }
        return result;
    }
}