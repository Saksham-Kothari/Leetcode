class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length == 0 ) return 1;
        
        int tc[] = new int[n+1];
        for(int i=0; i<trust.length; i++){
            
            tc[trust[i][0]]--;
            tc[trust[i][1]]++;
            
        }
        for(int i=1; i<tc.length; i++ ){
            if( tc[i] == n-1) return i;
        }
        return -1;
    }
}