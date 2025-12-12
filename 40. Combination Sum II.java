class Solution {
    public static void comb(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList(temp));
        }
        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            temp.add(candidates[i]);
            comb(i + 1, candidates, target - candidates[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        comb(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
