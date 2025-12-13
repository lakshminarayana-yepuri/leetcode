class Solution {
    public int numSubseq(int[] nums, int target) {
        int n=nums.length;
        int mod=1000000007;
        Arrays.sort(nums);
        int[] powers = new int[n];
        powers[0]=1;
        for(int i=1;i<n;i++){
            powers[i]=(2*powers[i-1])%mod;
        }        
        int left=0;
        int right=n-1;
        int ans=0;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(ans+powers[right-left])%mod;
                left++;
            }
            else right--;
        }
        return ans;
    }
}
