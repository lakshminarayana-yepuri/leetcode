class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int maxLeft=0;
        int maxRight=0;
        int total=0;
        int left=0;
        int right=n-1;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>maxLeft) maxLeft=height[left];
                else total+=maxLeft-height[left];
                left++;
            }
            else if(height[left]>height[right]){
                if(height[right]>maxRight) maxRight=height[right];
                else total+=maxRight-height[right];
                right--;
            }
        }
        return total;
    }
}
