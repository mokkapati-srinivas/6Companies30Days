// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    
    public int find(int value, int root[])
    {
        if(root[value]==value)
            return value;
        
        int currParent=find(root[value],root);
        root[value]=currParent;
        return currParent;
    }
    
    public void union(int value1, int value2, int root[])
    {
        if(value2==-1)
            return;
        
        int parent1=find(value1,root);
        int parent2=find(value2,root);
        if(parent1!=parent2)
            root[parent1]=parent2;
    }
    
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int root[]=new int[(n*m)];
        for(int i=0;i<(n*m);i++)
        {
            root[i]=i;
        }
        
        int topLeft=0,top=0,topRight=0,right=0,bottomRight=0,bottom=0,bottomLeft=0,left=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int curr=i*m+j;
                    
                    topLeft=(i-1>=0 && j-1>=0 && grid[i-1][j-1]==1)?((i-1)*m+j-1):-1;
                    union(curr,topLeft,root);
                    
                    top=(i-1>=0 && grid[i-1][j]==1)?((i-1)*m+j):-1;
                    union(curr,top,root);
                    
                    topRight=(i-1>=0 && j+1<m && grid[i-1][j+1]==1)?((i-1)*m+j+1):-1;
                    union(curr,topRight,root);
                    
                    right=(j+1<m && grid[i][j+1]==1)?(i*m+j+1):-1;
                    union(curr,right,root);
                    
                    bottomRight=(i+1<n && j+1<m && grid[i+1][j+1]==1)?((i+1)*m+j+1):-1;
                    union(curr,bottomRight,root);
                    
                    bottom=(i+1<n && grid[i+1][j]==1)?((i+1)*m+j):-1;
                    union(curr,bottom,root);
                    
                    bottomLeft=(i+1<n && j-1>=0 && grid[i+1][j-1]==1)?((i+1)*m+j-1):-1;
                    union(curr,bottomLeft,root);
                    
                    left=(j-1>=0 && grid[i][j-1]==1)?(i*m+j-1):-1;
                    union(curr,left,root);
                }
            }
        }
        
        int count[]=new int[(n*m)];
        for(int i=0;i<(n*m);i++)
        {
            int row=i/m;
            int col=i%m;
            if(grid[row][col]==1)
            {
                int parent=find(i,root);
                count[parent]++;
            }
        }
        
        int largestRegion=Integer.MIN_VALUE;
        for(int i=0;i<(n*m);i++)
        {
            largestRegion=Math.max(largestRegion,count[i]);
        }
        
        return largestRegion;
    }
}