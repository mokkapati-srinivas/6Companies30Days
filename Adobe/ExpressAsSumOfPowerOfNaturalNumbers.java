// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    
    static int numOfWaysUtil(int n, int x, int currNum, int currSum, int maxNum, int dp[][], int mod)
    {
        if(currNum>maxNum || currSum>n)
            return 0;
        
        if(currSum==n)
            return 1;
            
        if(dp[currNum][currSum]!=-1)
            return dp[currNum][currSum];
            
        int currPower=(int)(Math.pow(currNum,x));
        int opt1=numOfWaysUtil(n,x,currNum+1,currSum+currPower,maxNum,dp,mod)%mod;
        int opt2=numOfWaysUtil(n,x,currNum+1,currSum,maxNum,dp,mod)%mod;
        
        dp[currNum][currSum]=(opt1+opt2)%mod;
        
        return dp[currNum][currSum];
        // return (opt1+opt2)%mod;
    }
    
    static int numOfWays(int n, int x)
    {
        // code here
        int maxNum=(int)Math.pow(n,1.0/x)+1;
        
        int dp[][]=new int[maxNum+1][n+1];
        for(int i=0;i<=maxNum;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        int mod=1000000007;
        return numOfWaysUtil(n,x,1,0,maxNum,dp,mod)%mod;
    }
}