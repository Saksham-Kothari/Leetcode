class Solution(object):
    def intersection(self, nums1, nums2):
        result = list(set(nums1)& set(nums2))
        return result 
       
        