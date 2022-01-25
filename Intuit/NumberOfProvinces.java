class Solution {
    
    public int find(int node, int root[])
    {
        if(root[node]==node)
            return node;
        
        int parent=find(root[node],root);
        root[node]=parent;
        return parent;
    }
    
    public void union(int node1, int node2, int root[])
    {
        int parent1=find(node1,root);
        int parent2=find(node2,root);
        
        if(parent1!=parent2)
        {
            root[parent1]=parent2;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int n=isConnected.length;
        
        int root[]=new int[n];
        for(int i=0;i<n;i++)
        {
            root[i]=i;
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    union(i,j,root);
                }
            }
        }
        
        HashSet<Integer> result=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int parent=find(i,root);
            result.add(parent);
        }
        
        int provinces=result.size();
        
        return provinces;
    }
}