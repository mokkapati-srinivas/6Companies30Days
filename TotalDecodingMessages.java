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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        // code here
        if(str.charAt(0)=='0')
            return 0;
            
        int n=str.length();
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
        {
            char prev=str.charAt(i-1);
            char curr=str.charAt(i);
            if(prev=='0' && curr=='0')
            {
                dp[i]=0;
            }
            else if(prev=='0' && curr!='0')
            {
                dp[i]=dp[i-1];
            }
            else if(prev!='0' && curr=='0')
            {
                if(prev=='1' || prev=='2')
                    if(i>=2)
                        dp[i]=dp[i-2];
                    else
                        dp[i]=1;
                else
                    dp[i]=0;
            }
            else
            {
                if((prev=='1' && curr<='9') || (prev=='2' && curr<'7'))
                {
                    if(i>=2)
                        dp[i]=(dp[i-1]+dp[i-2])%1000000007;
                    else
                        dp[i]=(dp[i-1]+1)%1000000007;
                }
                else
                {
                    dp[i]=dp[i-1];
                }
            }
        }
        
        return dp[n-1];
    }
}