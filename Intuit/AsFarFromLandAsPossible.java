class Solution {
    
    class Pair
    {
        int i;
        int j;
        Pair(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }
    
    public boolean isValid(int grid[][], int n, int r, int c)
    {
        if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==0)
            return true;
        
        return false;
    }
    
    public int maxDistance(int[][] grid) {
        
        int n=grid.length;
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    queue.add(new Pair(i,j));
            }
        }
        
        boolean firstTime=true;
        int maxDistance=-1;
        int dirs[][]={{0,-1},{0,1},{1,0},{-1,0}};
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                Pair p=queue.poll();
                int r=p.i;
                int c=p.j;
                for(int d=0;d<4;d++)
                {
                    int newR=r+dirs[d][0];
                    int newC=c+dirs[d][1];
                    if(isValid(grid,n,newR,newC))
                    {
                        queue.add(new Pair(newR,newC));
                        if(firstTime)
                            grid[newR][newC]=1;
                        else
                            grid[newR][newC]=grid[r][c]+1;
                        
                        maxDistance=Math.max(maxDistance,grid[newR][newC]);
                    }
                }
            }
            firstTime=false;
        }
        
        return maxDistance;
        
    }
}