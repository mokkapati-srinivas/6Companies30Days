// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        int maxDiff=A[n-1]-A[0];
        int dp[][]=new int[n][maxDiff+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<maxDiff+1;j++)
            {
                dp[i][j]=1;
            }
        }
        
        int longest=1;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int currDiff=A[j]-A[i];
                dp[j][currDiff]=dp[i][currDiff]+1;
                longest=Math.max(longest,dp[j][currDiff]);
            }
        }
        
        return longest;
    }
}