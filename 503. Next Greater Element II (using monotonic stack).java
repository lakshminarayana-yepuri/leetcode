class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n*2-1;i>=0;i--){
            int ind=i%n;
            while(!st.isEmpty() && st.peek()<=nums[ind]) st.pop();
            if(ind<n && !st.isEmpty()){
                res[ind]=st.peek();
            }
            else res[ind]=-1;
            st.push(nums[ind]);
        }
        return res;
    }
}
