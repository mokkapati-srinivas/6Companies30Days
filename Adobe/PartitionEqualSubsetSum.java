// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static int equalPartitionUtil(int arr[], int n, int currInd, int currSum, int totSum, int dp[][])
    {
        if(currInd==n)
            return 0;
            
        if(dp[currInd][currSum]!=-1)
            return dp[currInd][currSum];
        
        int newSum=currSum+arr[currInd];
        int opt1=equalPartitionUtil(arr,n,currInd+1,newSum,totSum,dp);
        int opt2=equalPartitionUtil(arr,n,currInd+1,currSum,totSum,dp);
        int opt3=((2*currSum)==totSum)?1:0;
        
        if(opt1==1 || opt2==1 || opt3==1)
            dp[currInd][currSum]=1;
        else
            dp[currInd][currSum]=0;
        
        return dp[currInd][currSum];
    }
    
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum+=arr[i];
        }
        
        if(sum%2!=0)
            return 0;
        else
        {
            int dp[][]=new int[N+1][sum+1];
            for(int i=0;i<=N;i++)
            {
                for(int j=0;j<=sum;j++)
                {
                    dp[i][j]=-1;
                }
            }
            return equalPartitionUtil(arr,N,0,0,sum,dp);
        }
    }
}