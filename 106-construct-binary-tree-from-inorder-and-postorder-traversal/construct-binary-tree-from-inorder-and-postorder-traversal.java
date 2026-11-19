class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] index = {postorder.length - 1};   // start from the last element
        return helper(postorder, 0, inorder.length - 1, map, index);
    }

    public TreeNode helper(int[] postorder, int left, int right,
                           HashMap<Integer, Integer> map, int[] index) {
        if (left > right) {
            return null;
        }

        int current = postorder[index[0]];
        index[0]--;                              // move backwards

        TreeNode node = new TreeNode(current);

        if (left == right) {
            return node;
        }

        int inorderIndex = map.get(current);

        node.right = helper(postorder, inorderIndex + 1, right, map, index);  // RIGHT first
        node.left  = helper(postorder, left, inorderIndex - 1, map, index);   // then LEFT

        return node;
    }
}