class Solution {
    public static void sub(int ind, int[] nums,List<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for (int i = ind; i < nums.length; i++) {
            // Skip duplicates
            if (i > ind && nums[i] == nums[i - 1]) continue;
            // Include nums[i] in current subset
            temp.add(nums[i]);
            // Recurse for next index
            sub(i + 1, nums, temp, ans);
            // Backtrack: remove last element
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();
        sub(0,nums,new ArrayList<>(),ans);
        return ans;
    }
}
