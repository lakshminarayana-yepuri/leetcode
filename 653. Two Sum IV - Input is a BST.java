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
    List<TreeNode> list = new ArrayList<>();
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int l=0;
        int r=list.size()-1;
        while(l<r){
            if(list.get(l).val+list.get(r).val==k) return true;
            else if(list.get(l).val+list.get(r).val>k) r--;
            else l++;
        }
        return false;
    }
}
