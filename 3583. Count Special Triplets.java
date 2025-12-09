class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> totalFreq = new HashMap<>();
        Map<Integer,Integer> leftFreq = new HashMap<>();
        long res=0;
        int mod=1000000007;
        for(int i:nums){
            totalFreq.put(i,totalFreq.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            int target = 2*i;
            int leftCount=leftFreq.getOrDefault(target,0);
            leftFreq.put(i,leftFreq.getOrDefault(i,0)+1);
            int rightCount=totalFreq.getOrDefault(target,0)-leftFreq.getOrDefault(target,0);
            res=(res+((long) leftCount*(long)rightCount))%mod;
        }
        return (int) res;
    }
}
