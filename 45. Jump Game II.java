class Solution {
    public int jump(int[] nums) {
        int count=0;
        int maxDistance=0;
        int current=0;
        for(int i=0;i<nums.length-1;i++){
            maxDistance=Math.max(maxDistance,i+nums[i]);
            if(i==current){
                count++;
                current=maxDistance;
            }
        }
        return count;
    }
}
