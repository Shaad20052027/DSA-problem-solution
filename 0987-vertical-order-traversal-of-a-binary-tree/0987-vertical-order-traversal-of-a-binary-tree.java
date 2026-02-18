class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            map.putIfAbsent(p.col, new ArrayList<>());
            map.get(p.col).add(new int[]{p.row, p.node.val});

            if (p.node.left != null)
                queue.offer(new Pair(p.node.left, p.row + 1, p.col - 1));

            if (p.node.right != null)
                queue.offer(new Pair(p.node.right, p.row + 1, p.col + 1));
        }

        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> column = new ArrayList<>();
            for (int[] arr : list) {
                column.add(arr[1]);
            }
            ans.add(column);
        }

        return ans;
    }
}
