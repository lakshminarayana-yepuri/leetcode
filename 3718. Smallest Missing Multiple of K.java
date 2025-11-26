class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> numss = new HashSet<>();
        for(int i:nums){
            numss.add(i);
        }
        int count=1;
        for(int i=1;i<=nums.length;i++){
            if(!numss.contains(k*i)) return k*i;
            count++;
        }
        return count*k;
    }
}
