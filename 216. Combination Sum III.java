class Solution {
    public static void findComb(int sum, int last, int k, List<Integer> curr, List<List<Integer>> ans){
        if(sum==0 && curr.size()==k){
            ans.add(new ArrayList(curr));
            return;
        }
        if (sum <= 0 || curr.size() > k) return;
        for(int i=last;i<=9;i++){
            if(i<=sum){
                curr.add(i);
                findComb(sum-i,i+1,k,curr,ans);
                curr.remove(curr.size()-1);
            }
            else break;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findComb(n,1,k,curr,ans);
        return ans;
    }
}
