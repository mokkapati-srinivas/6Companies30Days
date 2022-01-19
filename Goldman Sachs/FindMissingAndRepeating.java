// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int repeatingMissing[]=new int[2];
        
        for(int i=0;i<n;i++)
        {
            int curr=Math.abs(arr[i]);
            int index=curr-1;
            if(arr[index]<0)
            {
                repeatingMissing[0]=curr;
            }
            else
            {
                arr[index]=-1*arr[index];
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                repeatingMissing[1]=i+1;
                break;
            }
        }
        
        return repeatingMissing;
    }
}