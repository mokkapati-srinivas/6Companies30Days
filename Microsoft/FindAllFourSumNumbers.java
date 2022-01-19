// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        int n=arr.length;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int targetTwoSum=k-(arr[i]+arr[j]);
                int left=j+1;
                int right=n-1;
                while(left<right)
                {
                    int twoSum=arr[left]+arr[right];
                    if(targetTwoSum<twoSum)
                        right--;
                    else if(targetTwoSum>twoSum)
                        left++;
                    else
                    {
                        ArrayList<Integer> quad=new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[left]);
                        quad.add(arr[right]);
                        result.add(quad);
                        
                        int leftEle=arr[left];
                        int rightEle=arr[right];
                        while(left<right && arr[left]==leftEle)
                            left++;
                        while(left<right && arr[right]==rightEle)
                            right--;
                    }
                    
                    while(j+1<n && arr[j+1]==arr[j])
                        j++;
                }
                
                while(i+1<n && arr[i+1]==arr[i])
                        i++;
            }
        }
        
        return result;
    }
}