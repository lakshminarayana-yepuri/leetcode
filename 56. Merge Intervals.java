class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] interval:intervals){
            if(ans.size()==0 || ans.get(ans.size()-1).get(1)<interval[0]) ans.add(Arrays.asList(interval[0],interval[1]));
            else{
                ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size() - 1).get(1), interval[1]));
            }
        }
        int[][] res = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i][0]=ans.get(i).get(0);
            res[i][1]=ans.get(i).get(1);
        }
        return res;
    }
}
