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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isWordExistsUtil(char board[][], String word, int currInd, int n, int r, int c, int rows, int cols)
    {
        if(currInd==n)
            return true;
        
        char curr=board[r][c];
        board[r][c]='#';
        
        if(r+1<rows && board[r+1][c]==word.charAt(currInd))
            if(isWordExistsUtil(board,word,currInd+1,n,r+1,c,rows,cols))
                return true;
        
        if(r-1>=0 && board[r-1][c]==word.charAt(currInd))
            if(isWordExistsUtil(board,word,currInd+1,n,r-1,c,rows,cols))
                return true;
            
        if(c+1<cols && board[r][c+1]==word.charAt(currInd))
            if(isWordExistsUtil(board,word,currInd+1,n,r,c+1,rows,cols))
                return true;
        
        if(c-1>=0 && board[r][c-1]==word.charAt(currInd))
            if(isWordExistsUtil(board,word,currInd+1,n,r,c-1,rows,cols))
                return true;
        
        board[r][c]=curr;
            
        return false;
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n=word.length();
        int rows=board.length;
        int cols=board[0].length;
        char firstLetter=word.charAt(0);
        
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(board[i][j]==firstLetter)
                    if(isWordExistsUtil(board,word,1,n,i,j,rows,cols))
                        return true;
                        
        return false;
    }
}