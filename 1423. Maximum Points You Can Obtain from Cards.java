class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tot=0;
        for(int i:cardPoints){
            tot+=i;
        }
        if(cardPoints.length==k) return tot;
        int n=cardPoints.length-k;
        int sum=0;
        int min=Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<cardPoints.length;right++){
            sum+=cardPoints[right];
            if(right-left+1==n){
                min=Math.min(min,sum);
                sum-=cardPoints[left++];
            }
        }
        return tot-min;
        
    }
}
