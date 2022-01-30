class Solution {
    
    public int getMoneyAmountUtil(int start, int end, int dp[][])
    {
        if(start>=end)
            return 0;
        
        if(dp[start][end]!=-1)
            return dp[start][end];
        
        int guess=0,lower=0,higher=0;
        int currAmt=0;
        int minAmt=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++)
        {
            guess=i;
            lower=getMoneyAmountUtil(start,guess-1,dp);
            higher=getMoneyAmountUtil(guess+1,end,dp);
            currAmt=guess+Math.max(lower,higher);
            minAmt=Math.min(minAmt,currAmt);
        }
        
        return dp[start][end]=minAmt;
    }
    
    public int getMoneyAmount(int n) {
        
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        return getMoneyAmountUtil(1,n,dp);
    }
}