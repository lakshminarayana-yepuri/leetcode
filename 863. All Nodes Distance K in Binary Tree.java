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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>  parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left!=null) {
                parentMap.put(node.left,node);
                q.add(node.left);
            }
            if(node.right!=null) {
                parentMap.put(node.right,node);
                q.add(node.right);
            }
        }

        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int currentDist = 0;

        while(!q.isEmpty()) {
            if(currentDist == k) {
                while(!q.isEmpty()) {
                    res.add(q.poll().val);
                }
                return res;
            }
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    q.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currentDist++;
        }
        return res;
    }
}
