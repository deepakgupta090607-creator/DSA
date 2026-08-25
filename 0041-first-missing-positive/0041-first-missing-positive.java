class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Put every number at its correct index
        for (int i = 0; i < n; i++) {

            while (nums[i] >= 1 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Find first number which is not at correct position
        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All 1 to n are present
        return n + 1;
    }
}