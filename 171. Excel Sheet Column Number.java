class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        for(int i=0;i<columnTitle.length();i++){
            res+=(columnTitle.charAt(i)-'A'+1)*Math.pow(26,columnTitle.length()-1-i);
        }
        return res;
    }
}
