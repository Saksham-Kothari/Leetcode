class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] contains = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(contains[nums[i]-1]){
                return nums[i];
            }
            contains[nums[i]-1]=true;
        }
        return 0;
    }
}