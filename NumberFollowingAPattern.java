// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n=S.length();
        
        StringBuilder resBuilder=new StringBuilder();
        int number=1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            char curr=S.charAt(i);
            if(curr=='D')
            {
                stack.push(number);
                number++;
            }
            else
            {
                stack.push(number);
                number++;
                
                int size=stack.size();
                while(size-->0)
                {
                    resBuilder.append(stack.pop());
                }
            }
        }
        
        stack.push(number);
        int size=stack.size();
        while(size-->0)
        {
            resBuilder.append(stack.pop());
        }
        
        return resBuilder.toString();
    }
}
