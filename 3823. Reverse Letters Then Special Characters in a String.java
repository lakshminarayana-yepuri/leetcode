class Solution {
    public String reverseByType(String s) {
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;

        while (low < high) {
            if (arr[low] >= 'a' && arr[low] <= 'z' && arr[high] >= 'a' && arr[high] <= 'z') {
                char t = arr[low];
                arr[low] = arr[high];
                arr[high] = t;
                low++;
                high--;
            } else if (arr[low] < 'a' || arr[low] > 'z') {
                low++;
            } else {
                high--;
            }
        }

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if ((arr[i] < 'a' || arr[i] > 'z') && (arr[j] < 'a' || arr[j] > 'z')) {
                char t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } else if (arr[i] >= 'a' && arr[i] <= 'z') {
                i++;
            } else {
                j--;
            }
        }

        return new String(arr);
    }
}
