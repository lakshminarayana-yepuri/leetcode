class Solution {
    private static void levelHelper(TreeNode root, List<List<Integer>> ans) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<size; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                arr.add(q.poll().val);
            }
            ans.add(arr);
        }
        return ans;
    }
}
