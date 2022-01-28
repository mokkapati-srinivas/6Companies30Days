// class Solution {
    
//     public int stoneGameUtil(int piles[], int left, int right, int n, int dp[][])
//     {
//         if(left>right)
//             return 0;
        
//         if(dp[left][right]!=-1)
//             return dp[left][right];
        
//         int takeLeft=piles[left]+Math.min(stoneGameUtil(piles,left+2,right,n,dp),stoneGameUtil(piles,left+1,right-1,n,dp));
//         int takeRight=piles[right]+Math.min(stoneGameUtil(piles,left+1,right-1,n,dp),stoneGameUtil(piles,left,right-2,n,dp));
        
//         return dp[left][right]=Math.max(takeLeft,takeRight);
//     }
    
//     public boolean stoneGame(int[] piles) {
        
//         int n=piles.length;
//         int tot=0;
//         for(int i=0;i<n;i++)
//         {
//             tot+=piles[i];
//         }
        
//         int dp[][]=new int[n][n];
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 dp[i][j]=-1;
//             }
//         }
//         int maxCoinsByAlice=stoneGameUtil(piles,0,n-1,n,dp);
//         int bob=tot-maxCoinsByAlice;
//         if(maxCoinsByAlice>bob)
//             return true;
//         else
//             return false;
//     }
// }



// We have done this because our aim is only winning.
// If it was to maximize the no of stones and then win we have to use the above solution
// See this - https://youtu.be/ww4V7vRIzSk
class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n=piles.length;
        
        int evenSum=0;
        int oddSum=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
                evenSum+=piles[i];
            else
                oddSum+=piles[i];
        }
        
        if(evenSum!=oddSum)
            return true;
        else
            return false;
    }
}