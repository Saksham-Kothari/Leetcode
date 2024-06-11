class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> mpp=new TreeMap<>();
        for(int i:arr1)
        mpp.put(i,mpp.getOrDefault(i,0)+1);
        int i=0;
        for(int n:arr2){
            for(int j=0;j<mpp.get(n);j++){
                arr1[i++]=n;
            }
            mpp.remove(n);

        }
        for(int n:mpp.keySet()){
            for(int j=0;j<mpp.get(n);j++){
                arr1[i++]=n;
            }
        }
        return arr1;
    }
}