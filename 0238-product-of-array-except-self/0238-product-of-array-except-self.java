class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; // Corrected array size calculation
        int[] ans = new int[n]; // Corrected array initialization
        int[] left = new int[n]; // Corrected array initialization
        int[] right = new int[n]; // Corrected array initialization

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) { // Corrected loop start index
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
