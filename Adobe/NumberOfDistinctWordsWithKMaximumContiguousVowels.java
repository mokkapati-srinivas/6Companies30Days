// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N,K);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public double kVowelWordsUtil(int currInd, int currContiguousVowelCount, int n, int k, double dp[][], double mod)
    {
        if(currInd==n)
            return 1;
            
        if(dp[currInd][currContiguousVowelCount]!=-1)
            return dp[currInd][currContiguousVowelCount];
        
        if(currContiguousVowelCount<k)
        {
            dp[currInd][currContiguousVowelCount]=((5*(kVowelWordsUtil(currInd+1,currContiguousVowelCount+1,n,k,dp,mod))%mod)%mod+(21*(kVowelWordsUtil(currInd+1,0,n,k,dp,mod))%mod)%mod)%mod;
        }
        else if(currContiguousVowelCount==k)
        {
            dp[currInd][currContiguousVowelCount]=(21*(kVowelWordsUtil(currInd+1,0,n,k,dp,mod))%mod)%mod;
        }
        
        return dp[currInd][currContiguousVowelCount];
    }
    
    public int kvowelwords(int N,int K){
        // code here
        double dp[][]=new double[N+1][K+1];
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<=K;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        double mod=1000000007;
        return (int)(kVowelWordsUtil(0,0,N,K,dp,mod)%mod);
    }
}
