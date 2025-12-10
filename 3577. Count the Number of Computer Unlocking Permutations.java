class Solution {
    final static int mod=1000000007;
    public static int fact(int n){
        int ans=1;
        for(int i=2;i<=n;i++){
            ans=(int) (((long) ans*i)%mod);
        }
        return ans;
    }
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        return fact(n-1);
    }
}
