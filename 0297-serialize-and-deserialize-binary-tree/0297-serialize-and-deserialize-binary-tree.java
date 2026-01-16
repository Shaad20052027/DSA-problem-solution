/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder list = new StringBuilder();
        helper(root,list);
        return list.toString();
    }

    void helper(TreeNode node, StringBuilder list){
        if(node == null){
            list.append("null,");
            return;
        }
        list.append(String.valueOf(node.val)).append(",");

        helper(node.left,list);
        helper(node.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> nodeList = new ArrayList<>(Arrays.asList(nodes));
        return deserializeHelper(nodeList);
    }

    private TreeNode deserializeHelper(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);

        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));