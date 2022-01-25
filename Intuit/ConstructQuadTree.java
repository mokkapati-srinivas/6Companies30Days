/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    public Node constructUtil(int grid[][], int r, int c, int n)
    {
        
        if(n==1)
        {
            Node curr=null;
            if(grid[r][c]==0)
                curr=new Node(false,true);
            else
                curr=new Node(true,true);
            return curr;
        }
        
        n=n/2;
        Node topLeft=constructUtil(grid,r,c,n);
        Node topRight=constructUtil(grid,r,c+n,n);
        Node bottomLeft=constructUtil(grid,r+n,c,n);
        Node bottomRight=constructUtil(grid,r+n,c+n,n);
        
        Node curr=null;
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf)
        {
            if(topLeft.val==topRight.val && topLeft.val==bottomLeft.val && topLeft.val==bottomRight.val)
            {
                curr=new Node(topLeft.val,true);
                return curr;
            }
        }
        
        curr=new Node(true,false,topLeft,topRight,bottomLeft,bottomRight);        
        return curr;
    }
    
    public Node construct(int[][] grid) {
        int n=grid.length;
        
        Node root=constructUtil(grid,0,0,n);
        return root;
    }
}