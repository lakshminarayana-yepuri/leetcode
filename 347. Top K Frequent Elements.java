class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        // Min-heap by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
