class Solution {
    
    public static int prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
            
        }
    }
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)) sb.append(ch);
            else if(ch=='(') stack.push(ch);
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while (!stack.isEmpty() && ((prec(ch) < prec(stack.peek())) || (prec(ch) == prec(stack.peek()) && ch != '^'))){
                    sb.append(stack.pop());
                }
                stack.push(ch);
            } 
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution();
 * String res = obj.infixToPostfix(s);
 */