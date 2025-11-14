class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i:arr){
            pq.offer(i);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
