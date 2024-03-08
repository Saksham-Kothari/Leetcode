class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freqArr = new int[101];
        int maxFreq = 0;
        int sumFreq = 0;
        for(int element : nums){
            freqArr[element]++;
            int curFreq = freqArr[element];
            
            if(curFreq > maxFreq){
                maxFreq = curFreq;
                sumFreq = curFreq;
            }else if(curFreq == maxFreq){
                sumFreq += curFreq;
            }

        }
        return sumFreq;
    }
}
