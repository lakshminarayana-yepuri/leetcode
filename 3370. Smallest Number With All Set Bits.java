class Solution {
    public int smallestNumber(int n) {
        for(int i=1;i<32;i++){
            if((1<<i)-1>=n){
                return (1<<i)-1;
            }
        }
        return 0;
    }
}
