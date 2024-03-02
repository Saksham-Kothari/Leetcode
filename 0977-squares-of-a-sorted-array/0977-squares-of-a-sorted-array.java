class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0, right = nums.length - 1, k = nums.length-1;

        while(left <= right) {
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare < rightSquare) {
                answer[k--] = rightSquare;
                right -= 1;
            }else {
                answer[k--] = leftSquare;
                left +=1;
            }
        }
        return answer;
    }
}