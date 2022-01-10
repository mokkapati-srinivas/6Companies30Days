// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int maxProfitUtil(int currInd, int N, int A[], int own, int currTrans, int dp[][][])
    {
        if(currInd==N)
            return 0;
            
        if(currTrans==0)
            return 0;
            
        if(dp[currInd][own][currTrans]!=-1)
        {
            return dp[currInd][own][currTrans];
        }
            
        if(own==0)
        {
            int firstOpt=(-A[currInd]+maxProfitUtil(currInd+1,N,A,1,currTrans,dp));
            int secondOpt=maxProfitUtil(currInd+1,N,A,0,currTrans,dp);
            return dp[currInd][own][currTrans]=Math.max(firstOpt,secondOpt);
        }
        else
        {
            int firstOpt=A[currInd]+maxProfitUtil(currInd+1,N,A,0,currTrans-1,dp);
            int secondOpt=maxProfitUtil(currInd+1,N,A,1,currTrans,dp);
            return dp[currInd][own][currTrans]=Math.max(firstOpt,secondOpt);
        }
    }
    
    static int maxProfit(int K, int N, int A[]) {
        // code here
        
        int memoizationDP[][][]=new int[N+1][2][K+1];
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<=K;k++)
                {
                    memoizationDP[i][j][k]=-1;
                }
            }
        }
        return maxProfitUtil(0,N,A,0,K,memoizationDP);
    }
}