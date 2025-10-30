class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res = new int[n];
        int i=0;
        while(i<n){
        boolean done =false;
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i]){
                    res[i]=nums[j];
                    done=true;
                    break;
                }
            }
            if(!done){
                for(int k=0;k<i;k++){
                    if(nums[k]>nums[i]){
                        res[i]=nums[k];
                        done=true;
                        break;
                    }
                }
            }
            if(!done) res[i]=-1;
            i++;
        }
        return res;
    }
}
