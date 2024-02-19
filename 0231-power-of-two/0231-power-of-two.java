class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1)
        return true;
        if(n==2147483647)
        return false;
        int currNumber=2,pow=1;
        while(currNumber<n){
            currNumber=(int)Math.pow(2,pow);
            pow++;
        }
        if(currNumber ==n){
            return true;
        }
        else{
            return false;
        }
    }
}