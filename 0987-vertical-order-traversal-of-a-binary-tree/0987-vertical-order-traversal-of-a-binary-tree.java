class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // column -> list of (row, value)
        Map<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0}); // node, row, col

        while (!queue.isEmpty()) {
            Object[] arr = queue.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            if (node.left != null)
                queue.offer(new Object[]{node.left, row + 1, col - 1});

            if (node.right != null)
                queue.offer(new Object[]{node.right, row + 1, col + 1});
        }

        for (List<int[]> list : map.values()) {
            // sort by row first, then by value
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> column = new ArrayList<>();
            for (int[] pair : list) {
                column.add(pair[1]);
            }
            ans.add(column);
        }

        return ans;
    }
}
