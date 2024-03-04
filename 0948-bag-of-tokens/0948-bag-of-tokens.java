class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int currScore =0;
        int maxScore=0;
        int l,r;
        l = 0;
        r = n-1;
        while(l<=r){
            if (power >= tokens[l]){
                currScore += 1;
                maxScore = Math.max(currScore, maxScore);
                power -= tokens[l];
                l++;
            }else if (currScore >= 1){
                currScore--;
                power += tokens[r];
                r--;
            }else{
                return maxScore;
            }
        }
        return maxScore;
    }
}