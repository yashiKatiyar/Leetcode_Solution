class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0; // position for next non-zero

        // Step 1: Move non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Step 2: Fill remaining with zeros
        while (j < n) {
            nums[j] = 0;
            j++;
        }
    }
}
        
        