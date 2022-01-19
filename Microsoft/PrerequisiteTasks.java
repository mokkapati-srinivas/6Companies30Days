// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public boolean isPossibleUtil(HashMap<Integer,ArrayList<Integer>> preReq, int inDegree[], int n)
    {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
                queue.add(i);
        }
        
        int nodesProcessed=0;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            for(int neigh: preReq.get(curr))
            {
                inDegree[neigh]--;
                if(inDegree[neigh]==0)
                    queue.add(neigh);
            }
            
            nodesProcessed++;
        }
        
        if(nodesProcessed==n)
            return true;
        else
            return false;
    }
    
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        HashMap<Integer,ArrayList<Integer>> preReq=new HashMap<>();
        for(int i=0;i<N;i++)
        {
            preReq.put(i,new ArrayList<Integer>());
        }
        
        int len=prerequisites.length;
        int inDegree[]=new int[N];
        for(int i=0;i<len;i++)
        {
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            preReq.get(b).add(a);
            inDegree[a]++;
        }
        
        boolean result=isPossibleUtil(preReq,inDegree,N);
        return result;
    }
    
}