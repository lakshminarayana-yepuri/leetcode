class Solution {
    public static void findComb(String digits, List<String> res,String[] map,int index, String temp ){
        if(index==digits.length()){
            res.add(temp);
            return;
        }
        String s=map[digits.charAt(index)-'0'];
        for(int i=0;i<s.length();i++){
            findComb(digits,res,map,index+1,temp+s.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findComb(digits,res,map,0,"");
        return res;
    }
}
