class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur_sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur_sum = Math.max(nums[i], nums[i] + cur_sum);
            max = Math.max(max, cur_sum);
        }
        return max;
    }
}