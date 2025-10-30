class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i]) st.pop();
            if(!st.isEmpty()) res.add(st.peek());
            else res.add(-1);
            st.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
