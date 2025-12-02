class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0;i<k;i++){
            int ind=0;
            int min=Integer.MAX_VALUE;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    ind=j;
                }
            }
            nums[ind]=nums[ind]*multiplier;
        }
        return nums;
    }
}
