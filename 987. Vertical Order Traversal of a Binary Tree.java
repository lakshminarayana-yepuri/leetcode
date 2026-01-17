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
public class Node {
    int val;
    int row;
    int col;
    Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private void updateMap(TreeNode root, TreeMap<Integer, List<Node>> map, int row, int col) {
        if(root == null) return;
        map.computeIfAbsent(col, k -> new ArrayList<>()).add(new Node(root.val,row,col));
        updateMap(root.left, map, row+1, col-1);
        updateMap(root.right, map, row+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        updateMap(root, map, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int col : map.keySet()) {
            List<Node> list = map.get(col);
            list.sort((a, b) -> {
                if(a.row != b.row) return a.row - b.row;
                return a.val - b.val;
            });
            List<Integer> res = new ArrayList<>();
            for(Node n : list) {
                res.add(n.val);
            }
            ans.add(res);
        }
        return ans;
    }
}
