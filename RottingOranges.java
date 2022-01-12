class Solution {
    
    public int addToQueue(int curr, Queue<Integer> queue, int grid[][], int rows, int cols, int freshOranges)
    {
        int row=curr/cols;
        int col=curr%cols;
        if(row-1>=0 && grid[row-1][col]==1)
        {
            grid[row-1][col]=2;
            freshOranges--;
            int next=(row-1)*cols+col;
            queue.add(next);
        }
        if(row+1<rows && grid[row+1][col]==1)
        {
            grid[row+1][col]=2;
            freshOranges--;
            int next=(row+1)*cols+col;
            queue.add(next);
        }
        if(col-1>=0 && grid[row][col-1]==1)
        {
            grid[row][col-1]=2;
            freshOranges--;
            int next=row*cols+col-1;
            queue.add(next);
        }
        if(col+1<cols && grid[row][col+1]==1)
        {
            grid[row][col+1]=2;
            freshOranges--;
            int next=row*cols+col+1;
            queue.add(next);
        }
        
        return freshOranges;
    }
    
    public int orangesRotting(int[][] grid) {
        
        int rows=grid.length;
        int cols=grid[0].length;
        
        Queue<Integer> queue=new LinkedList<>();
        int freshOranges=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==2)
                {
                    int index=i*cols+j;
                    queue.add(index);
                }
                else if(grid[i][j]==1)
                    freshOranges++;
            }
        }
        
        if(freshOranges==0)
            return 0;
        
        int minutes=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int curr=queue.poll();
                freshOranges=addToQueue(curr,queue,grid,rows,cols,freshOranges);
            }
            minutes++;
        }
        
        if(freshOranges==0)
            return minutes-1;
        else
            return -1;
    }
}