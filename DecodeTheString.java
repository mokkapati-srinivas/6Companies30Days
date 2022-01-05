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
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        
        int i=0;
        int n=s.length();
        
        int noOfTimes=0;
        String decode="";
        Stack<String> prevDecodes=new Stack<>();
        Stack<Integer> prevTimes=new Stack<>();
        while(i<n)
        {
            char curr=s.charAt(i);
            if(Character.isDigit(curr))
            {
                while(i<n && Character.isDigit(s.charAt(i)))
                {
                    noOfTimes=noOfTimes*10+(s.charAt(i)-'0');
                    i++;
                }
            }
            else if(curr=='[')
            {
                prevDecodes.push(decode);
                prevTimes.push(noOfTimes);
                noOfTimes=0;
                decode="";
                i++;
            }
            else if(curr==']')
            {
                StringBuilder temp=new StringBuilder(prevDecodes.pop());
                int count=prevTimes.pop();
                for(int j=0;j<count;j++)
                {
                    temp.append(decode);
                }
                decode=temp.toString();
                i++;
            }
            else
            {
                decode+=curr;
                i++;
            }
        }
        
        return decode;
    }
}