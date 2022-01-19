// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        long start=0;
        long end=0;
        long product=1;
        int subArraysWithProdK=0;
        
        while(end<n)
        {
            product=product*a[(int)end];
            while(start<n && product>=k)
            {
                product/=a[(int)start];
                start++;
            }
            
            subArraysWithProdK+=(end-start+1);
            end++;
        }
        
        return subArraysWithProdK;
    }
}