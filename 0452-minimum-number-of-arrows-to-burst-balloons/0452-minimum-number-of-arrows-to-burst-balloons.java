class Solution {
    public int findMinArrowShots(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->(a[1]-b[1]));
        int prev[] = arr[0];
        int ans = 1;
        for(int i=1; i<n; i++){
            if(prev[1]>=arr[i][0] && prev[1]<=arr[i][1]) continue;
            else{
                ans++;
                prev = arr[i];
            }
        }
        return ans;
    }
}