// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void allParanthesisUtil(int n, int open, int closed, String curr, List<String> result)
    {
        if(open==n && closed==n)
        {
            result.add(curr);
            return;
        }
        
        if(open<n)
            allParanthesisUtil(n,open+1,closed,curr+'(',result);
        
        if(closed<open)
            allParanthesisUtil(n,open,closed+1,curr+')',result);
    }
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> result=new ArrayList<>();
        allParanthesisUtil(n,0,0,"",result);
        
        return result;
    }
}