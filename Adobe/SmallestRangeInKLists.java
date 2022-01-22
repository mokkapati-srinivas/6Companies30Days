// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}
// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    //add your code here
	    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
	        int val1=a[0];
	        int val2=b[0];
	        return val1-val2;
	    });
	    
	    int max=Integer.MIN_VALUE;
	    for(int i=0;i<k;i++)
	    {
	        int curr[]=new int[3];
	        curr[0]=KSortedArray[i][0];
	        max=Math.max(max,curr[0]);
	        curr[1]=i;
	        curr[2]=0;
	        pq.add(curr);
	    }
	    
	    int minRangeValues[]=new int[2];
	    int minRange=Integer.MAX_VALUE;
	    while(true)
	    {
	        int curr[]=pq.poll();
	        int currVal=curr[0];
	        int currRow=curr[1];
	        int currInd=curr[2];
	        
	        int currRange=max-currVal+1;
	        if(currRange<minRange)
	        {
	            minRangeValues[0]=currVal;
	            minRangeValues[1]=max;
	            minRange=currRange;
	        }
	        
	        int newInd=currInd+1;
	        if(newInd==n)
	            break;
	        int newVal=KSortedArray[currRow][newInd];
	        max=Math.max(max,newVal);
	        
	        int newCurr[]=new int[3];
	        newCurr[0]=newVal;
	        newCurr[1]=currRow;
	        newCurr[2]=newInd;
	        pq.add(newCurr);
	    }
	    
	    return minRangeValues;
	}
}