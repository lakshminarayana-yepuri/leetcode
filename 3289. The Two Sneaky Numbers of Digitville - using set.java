class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res=new int[2];
        int ind=0;
        for(int num: nums){
            if(set.contains(num)) res[ind++]=num;
            else set.add(num);
        }
        return res;
    }
}
