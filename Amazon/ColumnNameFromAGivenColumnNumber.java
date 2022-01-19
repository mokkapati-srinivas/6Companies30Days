// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        Stack<Character> stack=new Stack<>();
        while(n>=1L)
        {
            int rem=(int)(n%26L);
            if(rem==0)
            {
                stack.push('Z');
                n=n-26L;
            }
            else
            {
                char curr=(char)(65+rem-1);
                stack.push(curr);
                n=n-rem;
            }
            n=n/26L;
        }
        
        String result="";
        while(!stack.isEmpty())
        {
            result+=stack.pop();
        }
        
        return result;
    }
}