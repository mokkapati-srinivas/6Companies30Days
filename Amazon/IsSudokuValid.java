// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int mat[][]){
        // code here
        int row[][]=new int[10][10];
        int col[][]=new int[10][10];
        int box[][]=new int[10][10];
        
        int r=mat.length;
        int c=mat[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int curr=mat[i][j];
                int currBox=(i/3)*3+(j/3);
                if(curr!=0)
                {
                    if(row[i][curr]!=0 || col[j][curr]!=0 || box[currBox][curr]!=0)
                    {
                        return 0;
                    }
                    row[i][curr]=1;
                    col[j][curr]=1;
                    box[currBox][curr]=1;
                }
            }
        }
        
        return 1;
    }
}