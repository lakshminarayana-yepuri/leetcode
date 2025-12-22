class Solution {
    public static boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
    public static void findPartition(int ind, String s, List<String> temp, List<List<String>> ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                temp.add(s.substring(ind,i+1));
                findPartition(i+1,s,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        findPartition(0,s,temp,ans);
        return ans;
    }
}
