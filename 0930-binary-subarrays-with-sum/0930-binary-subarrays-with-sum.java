class Solution {
    private int getNumOfSubarray(int[] nums, int goal) {
        int start = 0, subarray = 0, sum = 0;
        for(int end = 0; end <nums.length; end++){
            sum += nums[end];
            while(start <= end && sum >goal){
                sum -= nums[start++];
            }
            subarray += (end - start +1);
        }
        return subarray;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return getNumOfSubarray(nums, goal) - getNumOfSubarray(nums, goal - 1);
    }
}