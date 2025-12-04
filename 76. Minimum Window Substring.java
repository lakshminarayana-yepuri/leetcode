class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int count=0,minLength=Integer.MAX_VALUE,left=0,sIndex=-1,m=t.length(),n=s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        for(int right=0;right<n;right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)-1);
            if(map.get(s.charAt(right))>=0) count++;
            while(count==m){
                if(minLength>right-left+1){
                    minLength=right-left+1;
                    sIndex=left;
                }
                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                if(map.get(s.charAt(left))>0) count--;
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE? "":s.substring(sIndex,sIndex+minLength);
    }
}
