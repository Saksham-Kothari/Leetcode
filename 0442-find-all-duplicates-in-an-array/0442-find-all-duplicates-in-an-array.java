class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer>al=new ArrayList<>();
        int a[]=new int[nums.length];
        for(int i:nums)a[i-1]++;
        for(int i=0;i<a.length;i++)if(a[i]>1)al.add(i+1);
        return al;
    }
}