/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private static boolean findPath(TreeNode root, List<Integer> path, TreeNode p) {
        if(root == null) return false;
        path.add(root.val);
        if(root.val==p.val) return true;
        if(findPath(root.left, path, p) || findPath(root.right,path,p)) return true;
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        if (!findPath(root, l1, p) || !findPath(root, l2, q)) {
            return null;
        }
        int i = 0;
        while (i < l1.size() && i < l2.size() && l1.get(i).equals(l2.get(i))) {
            i++;
        }
        return new TreeNode(l1.get(i - 1));

    }
}
