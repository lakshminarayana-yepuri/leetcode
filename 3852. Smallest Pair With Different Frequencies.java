class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getKey()<min) min=e.getKey();
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getKey()!=min && map.get(min)!=e.getValue() && e.getKey()<max) max=e.getKey();
        }
        if(min==Integer.MAX_VALUE || max==Integer.MAX_VALUE) return new int[]{-1,-1};
        return new int[]{min,max};
    }
}
