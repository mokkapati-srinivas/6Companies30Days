// { Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        int n=A.length();
        int frequency[]=new int[26];
        Queue<Character> queue=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char currChar=A.charAt(i);
            int currInt=currChar-'a';
            
            if(frequency[currInt]==0)
                queue.offer(currChar);
            frequency[currInt]++;
            
            while(!queue.isEmpty() && frequency[queue.peek()-'a']>1)
                queue.poll();
                
            if(queue.isEmpty())
                res.append('#');
            else
                res.append(queue.peek());
            
        }
        
        String result=res.toString();
        
        return result;
    }
}