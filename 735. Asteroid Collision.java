class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int count=0;
        int n=asteroids.length;
        for(int i:asteroids){
            boolean destroid = false;
            while(!st.isEmpty() && st.peek()>0 && i<0){
                if(st.peek()<-i){
                    st.pop();
                    continue;
                }
                else if(st.peek()==-i){
                    st.pop();
                } 
                destroid=true;
                break;
            }
            if(!destroid) st.push(i);
        }
        int[] res = new int[st.size()];
        int i=st.size()-1;;
        while(!st.isEmpty()){
            res[i--]=st.pop();
        }
        return res;

    }
}
