class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll(); // keep heap size k
        }
        return pq.peek();
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution();
 * int param_1 = obj.findKthLargest(nums,k);
 */