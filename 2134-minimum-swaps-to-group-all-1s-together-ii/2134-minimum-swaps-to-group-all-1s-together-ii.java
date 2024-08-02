class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int t1s = 0;
        int curr1= 0;

        for(int num : nums){
            t1s += num;
        }

        if (t1s == 0|| t1s == n) {
            return 0;
        }

        for(int i = 0; i<t1s;i++ ){
            curr1 += nums[i];
        }
        int max1 = curr1; 

        for(int i=0;i<n;i++){
            curr1 -=nums[i];
            curr1 +=nums[(i+t1s)%n];
            max1= Math.max(max1,curr1);
        }
        return t1s-max1 ;
    }
}