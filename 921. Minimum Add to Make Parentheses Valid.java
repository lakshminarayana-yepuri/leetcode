class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // unmatched '('
        int close = 0;  // unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else {
                if (open > 0) open--; // match with a '('
                else close++;         // no '(' available → needs one
            }
        }

        return open + close;
    }
}
