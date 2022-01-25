// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}// } Driver Code Ends




class Solution
{
    static String max;
    
    public static String swap(String s, int i, int j)
    {
        char c[]=s.toCharArray();
        
        char ch=c[i];
        c[i]=c[j];
        c[j]=ch;
        
        return String.valueOf(c);
    }
    
    public static void findMaxUtil(String s, int k, int n)
    {
        if(max.compareTo(s)<0)
            max=s;
        
        if(k==0)
            return;
            
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(s.charAt(j)>s.charAt(i))
                {
                    String swapped=swap(s,i,j);
                    findMaxUtil(swapped,k-1,n);
                }
            }
        }
    }
    
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        int n=str.length();
        max=str;
        findMaxUtil(str,k,n);
        
        return max;
    }
}