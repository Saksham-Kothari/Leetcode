class Solution {
    public double averageWaitingTime(int[][] cust) {
        int n = cust.length;
        double servtm = cust[0][0]+ cust[0][1];
        double totalwait = servtm - cust[0][0];
        for(int i=1;i<n;i++){
            if(servtm < cust[i][0])servtm = cust[i][0];
            servtm = servtm + cust[i][1];
            totalwait += (servtm - cust[i][0]);
        }
        return totalwait/n;
    }   
}