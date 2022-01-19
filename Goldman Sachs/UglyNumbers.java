// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        
        long uglyNumbers[]=new long[n+1];
        uglyNumbers[1]=1;
        
        int pointerFor2=1;
        int pointerFor3=1;
        int pointerFor5=1;
        for(int i=2;i<=n;i++)
        {
            long nextMultiple2=uglyNumbers[pointerFor2]*2;
            long nextMultiple3=uglyNumbers[pointerFor3]*3;
            long nextMultiple5=uglyNumbers[pointerFor5]*5;
            
            long nextUgly=Math.min(nextMultiple2, Math.min(nextMultiple3,nextMultiple5));
            uglyNumbers[i]=nextUgly;
            
            if(nextUgly==nextMultiple2)
                pointerFor2++;
            if(nextUgly==nextMultiple3)
                pointerFor3++;
            if(nextUgly==nextMultiple5)
                pointerFor5++;
        }
        
        return uglyNumbers[n];
    }
}