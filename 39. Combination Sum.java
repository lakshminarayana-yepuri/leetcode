class Solution {
    public static void comb(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp){
        if(ind==candidates.length){
            if(target==0) ans.add(new ArrayList(temp));
            return;
        }
        if(candidates[ind]<=target){
            temp.add(candidates[ind]);
            comb(ind,candidates,target-candidates[ind],ans,temp);
            temp.remove(temp.size()-1);
        }
        comb(ind+1,candidates,target,ans,temp);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
