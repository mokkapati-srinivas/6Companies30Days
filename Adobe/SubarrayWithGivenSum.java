// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int left=0;
        int sum=0;
        ArrayList<Integer> indices=new ArrayList<>();
        for(int right=0;right<n;right++)
        {
            sum+=arr[right];
            while(left<=right && sum>s)
            {
                sum-=arr[left];
                left++;
            }
            
            if(sum==s)
            {
                indices.add(left+1);
                indices.add(right+1);
                break;
            }
        }
        
        if(indices.size()==0)
            indices.add(-1);
        
        return indices;
    }
}