// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int D){
        // code here
        if(D<0)
            D=-D;

        int steps=0;
        int currPoint=0;
        while(true)
        {
            steps++;
            currPoint+=steps;
            
            if(currPoint==D)
                return steps;
                
            else if(currPoint>D && (currPoint-D)%2==0)
                return steps;
        }
    }
}