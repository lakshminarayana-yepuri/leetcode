class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1 ;
        long nn=n;
        if(nn<0){
            x=1/x;
            nn=-nn;
        }
        if(nn==1) return x;
        double half=myPow(x,(int)(nn/2));
        if(nn%2==0) return half*half;
        else return x*half*half;
    }
}
