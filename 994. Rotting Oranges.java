class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited = grid;
        Queue<int[]> q = new LinkedList<>();
        int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==2){
                    q.offer(new int[] {i,j});
                }
                if(visited[i][j]==1) countFresh++;
            }
        }
        if(countFresh==0) return 0;
        if(q.isEmpty()) return -1;

        int time=-1;
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] ind = q.poll();
                int row=ind[0];
                int col=ind[1];
                for(int[] dir:directions){
                    int i=row+dir[0];
                    int j=col+dir[1];
                    if(i>=0 && i<n && j>=0 && j<m && visited[i][j]==1){
                        visited[i][j]=2;
                        countFresh--;
                        q.offer(new int[] {i,j});
                    }
                }
            }
            time++;
        }
        if(countFresh==0) return time;
        return -1;
    }
}
