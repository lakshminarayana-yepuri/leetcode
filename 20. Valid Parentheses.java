class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for(Character ch : s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char pp = st.pop();
                if(pp=='(' && ch!=')' || pp=='[' && ch!=']' || pp=='{' && ch!='}') return false;
            }
        }
        return st.isEmpty();
    }
}