class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        a = nums.sort(key = int)
        n = len(nums)
        return nums[n-k]