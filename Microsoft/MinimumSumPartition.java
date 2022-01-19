// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public int minDifferenceUtil(int arr[], int n, int currInd, int currSum, int totSum, int dp[][])
    {
        if(currInd==n)
            return totSum;
        
          
        if(dp[currInd][currSum]!=-1)
            return dp[currInd][currSum];
            
        int diff1=minDifferenceUtil(arr,n,currInd+1,currSum+arr[currInd],totSum,dp);
        int diff2=minDifferenceUtil(arr,n,currInd+1,currSum,totSum,dp);
        int diff3=Math.abs(2*currSum-totSum);
        
        dp[currInd][currSum]=Math.min(diff1,Math.min(diff2,diff3));
        
        return dp[currInd][currSum];
        
        // return Math.min(diff1,Math.min(diff2,diff3));
    }

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int totSum=0;
	    for(int i=0;i<n;i++)
	    {
	        totSum+=arr[i]; 
	    }
	    
	    int dp[][]=new int[n+1][totSum+1];
	    for(int i=0;i<n+1;i++)
	    {
	        for(int j=0;j<totSum+1;j++)
	        {
	           dp[i][j]=-1;
	        }
	    }
	    return minDifferenceUtil(arr,n,0,0,totSum,dp);
	} 
}