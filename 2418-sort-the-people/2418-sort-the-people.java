class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> hmap=new HashMap<>();
        int n = heights.length;
        for(int i=0;i<n;i++){
            hmap.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] res = new String[n];
        for(int i=n-1,j=0;i>=0;j++,i--){
            res[j]= hmap.get(heights[i]);
        }
        return res;
    }
}