// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        HashMap<Integer,Integer> frequency=new HashMap<>();
        
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int curr=nums[i];
            int rem=curr%k;
            int count=frequency.getOrDefault(rem,0);
            frequency.put(rem,count+1);
        }
        
        for(int rem: frequency.keySet())
        {
            
            int otherRem=k-rem;
            int count=frequency.get(rem);
            int otherCount=frequency.getOrDefault(otherRem,0);
            if(rem==0 && count%2!=0)
                return false;
            
            else if(rem==otherRem && count%2!=0)
                return false;
            
            else if(rem!=0 && count!=otherCount)
                return false;
        }
        
        return true;
    }
}