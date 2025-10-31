class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] temp = new int[101];
        Arrays.fill(temp, -1);
        int i = 0;
        int[] ans = new int[2];

        for(int x : nums){
            if(temp[x] == x) ans[i++] = x;
            else temp[x] = x;
        }
        return ans;
    }
}
