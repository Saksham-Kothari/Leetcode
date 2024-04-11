class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        a1, a2, ans = [],[],[]

        for i in nums:
            if i>0:
                a1.append(i)
            else:
                a2.append(i)  
        
        ind1, ind2 = 0, 0

        while ind2<len(nums)//2 :
            ans.append(a1[ind1])
            ind1+=1
            ans.append(a2[ind2])
            ind2+=1
        return ans

