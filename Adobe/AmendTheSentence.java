// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
        //code here
        int n=s.length();
        
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            int curr=(int)s.charAt(i);
            if(curr<=90)
            {
                if(i!=0)
                    result.append(' ');
                char newCurr=(char)(curr+32);
                result.append(newCurr);
            }
            else
                result.append((char)curr);
        }
        
        return result.toString();
    }
}

