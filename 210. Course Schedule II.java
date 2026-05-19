class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int ai=pre[0];
            int bi=pre[1];
            adj.get(bi).add(ai);
            indegree[ai]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int course = q.poll();
            order[index++]=course;
            for(int c : adj.get(course)){
                indegree[c]--;
                if(indegree[c]==0){
                    q.offer(c);
                }
            }
        }
        if(index==numCourses) return order;
        return new int[0];

    }
}
