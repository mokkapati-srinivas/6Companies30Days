class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        if(n<3)
            return 0;
        
        HashMap<Integer,Integer> distances=new HashMap<>();
        int xi=0,yi=0,xj=0,yj=0,dist=0;
        int boomerangs=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    xi=points[i][0];
                    yi=points[i][1];
                    xj=points[j][0];
                    yj=points[j][1];
                    dist=(xi-xj)*(xi-xj)+(yi-yj)*(yi-yj);
                    int count=distances.getOrDefault(dist,0);
                    distances.put(dist,count+1);
                }
            }
            
            for(int key: distances.keySet())
            {
                int count=distances.get(key);
                boomerangs+=count*(count-1);
            }
            
            distances.clear();
        }
        
        return boomerangs;
    }
}