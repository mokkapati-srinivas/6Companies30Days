// { Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int count=map.getOrDefault(arr[i],0);
            map.put(arr[i],count+1);
        }
        
        int maxVotes=0;
        String maxName="";
        for(String key: map.keySet())
        {
            int currVotes=map.get(key);
            if((currVotes>maxVotes) || (currVotes==maxVotes && key.compareTo(maxName)<0))
            {
                maxVotes=currVotes;
                maxName=key;
            }
        }
        
        String result[]=new String[2];
        result[0]=maxName;
        result[1]=""+maxVotes;
        
        return result;
    }
}

