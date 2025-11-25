class Solution {
    public int characterReplacement(String s, int k) {
        if(k==s.length()) return s.length();
        int left=0;
        int mxFreq=0;
        int windowLength=0;
        int[] chars=new int[26];
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            chars[ch-'A']++;
            int window=right-left+1;
            mxFreq=Math.max(mxFreq,chars[ch-'A']);
            if(window-mxFreq>k){
                chars[s.charAt(left)-'A']--;
                left++;
            }
            windowLength = Math.max(windowLength, right - left + 1);
        }
        return windowLength;
    }
}
