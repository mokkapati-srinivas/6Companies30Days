class Solution {
    
    public boolean isValid(int r, int c, int heights[][], int visited[][], int rows, int cols, int prevHeight)
    {
        if(r>=0 && r<rows && c>=0 && c<cols && visited[r][c]==0 && heights[r][c]>=prevHeight)
            return true;
        
        return false;
    }
    
    public void dfs(int r, int c, int heights[][], int visited[][], int rows, int cols)
    {
        visited[r][c]=1;
        int prevHeight=heights[r][c];
        
        int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<4;i++)
        {
            int newRow=r+dirs[i][0];
            int newCol=c+dirs[i][1];
            if(isValid(newRow,newCol,heights,visited,rows,cols,prevHeight))
                dfs(newRow,newCol,heights,visited,rows,cols);
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        
        int pacificVisited[][]=new int[rows][cols];
        int atlanticVisited[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            dfs(i,0,heights,pacificVisited,rows,cols);
            dfs(i,cols-1,heights,atlanticVisited,rows,cols);
        }
        
        for(int j=0;j<cols;j++)
        {
            dfs(0,j,heights,pacificVisited,rows,cols);
            dfs(rows-1,j,heights,atlanticVisited,rows,cols);
        }
        
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(pacificVisited[i][j]==1 && atlanticVisited[i][j]==1)
                {
                    List<Integer> point=new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        
        return result;
    }
}