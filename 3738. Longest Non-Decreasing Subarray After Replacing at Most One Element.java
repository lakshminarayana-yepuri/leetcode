class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int[] lend = new int[n];
        int[] lstart = new int[n];

        for (int i = 0; i < n; i++) {
            lend[i] = 1;
            lstart[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                lend[i] = lend[i - 1] + 1;
            }
        }

        // Longest non-decreasing starting at i
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                lstart[i] = lstart[i + 1] + 1;
            }
        }

        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, Math.max(lend[i], lstart[i]));
        }

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] <= nums[i + 1]) {
                maxVal = Math.max(maxVal, lend[i - 1] + lstart[i + 1] + 1);
            } else {
                maxVal = Math.max(maxVal, Math.max(lend[i - 1], lstart[i + 1]) + 1);
            }
        }

        // Replace first or last element
        maxVal = Math.max(maxVal, lstart[1] + 1);
        maxVal = Math.max(maxVal, lend[n - 2] + 1);

        return maxVal;
    }
}
