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
    private TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, Map<Integer,Integer> map) {
        if(pStart>pEnd || iStart>iEnd) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int inRoot = map.get(postorder[pEnd]);
        int numsLeft = inRoot - iStart;
        root.left = build(inorder, iStart, inRoot-1, postorder, pStart,pStart+numsLeft-1, map);
        root.right = build(inorder, inRoot+1, iEnd, postorder, pStart+numsLeft, pEnd-1, map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
}
