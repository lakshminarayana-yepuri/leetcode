class Solution {
    public int countMonobit(int n) {
        int count=0;
        int i=0;
        while(Math.pow(2,i)-1<=n){
            count++;
            i++;
        }
        return count;
    }
}
