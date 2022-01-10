// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static String stringWithBrackets;
    static char matName;
    
    static void makeStringWithBrackets(int left, int right, int bracketInd[][])
    {
        if(left>right)
            return;
        
        if(left==right)
        {
            stringWithBrackets+=matName;
            matName++;
            return;
        }
        
        stringWithBrackets+="(";
        
        int bInd=bracketInd[left][right];
        makeStringWithBrackets(left,bInd,bracketInd);
        makeStringWithBrackets(bInd+1,right,bracketInd);
        
        stringWithBrackets+=")";
    }
    
    static String matrixChainOrder(int p[], int n){
        // code here
        
        int bracketInd[][]=new int[n][n];
        int minMultiplications[][]=new int[n][n];
        
        for(int i=1;i<n;i++)
        {
            minMultiplications[i][i]=0;
        }
        for(int noOfMat=2;noOfMat<=n-1;noOfMat++)
        {
            for(int left=1;left<=n-noOfMat;left++)
            {
                int right=left+noOfMat-1;
                minMultiplications[left][right]=Integer.MAX_VALUE;
                for(int bInd=left;bInd<=right-1;bInd++)
                {
                    int currMul=minMultiplications[left][bInd]+minMultiplications[bInd+1][right]+p[left-1]*p[bInd]*p[right];
                    if(currMul<minMultiplications[left][right])
                    {
                        minMultiplications[left][right]=currMul;
                        bracketInd[left][right]=bInd;
                    }
                }
            }
        }
        
        stringWithBrackets="";
        matName='A';
        
        makeStringWithBrackets(1,n-1,bracketInd);
        
        return stringWithBrackets;
        
    }
}