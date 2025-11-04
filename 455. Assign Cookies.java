class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gInd=0;
        int sInd=0;
        while(gInd<g.length && sInd<s.length){
            if(s[sInd]>=g[gInd]) gInd++;
            sInd++;
        }
        return gInd;
    }
}
