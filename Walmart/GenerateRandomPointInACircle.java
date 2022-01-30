class Solution {
    
    private double x;
    private double y;
    private double radius;
    
    public Solution(double radius, double x_center, double y_center) {
        this.x=x_center;
        this.y=y_center;
        this.radius=radius;
    }
    
    public boolean isInCircle(double randX, double randY)
    {
        // Circle equation (x-a)^2+(y-b)^2=r^2
        return (randX-x)*(randX-x)+(randY-y)*(randY-y)<=(radius*radius);
    }
    
    public double[] randPoint() {
        ThreadLocalRandom rand=ThreadLocalRandom.current();
        
        double minx=x-radius;
        double maxx=x+radius;
        double miny=y-radius;
        double maxy=y+radius;
        
        double randX=rand.nextDouble(minx,maxx);
        double randY=rand.nextDouble(miny,maxy);
        
        while(!isInCircle(randX,randY))
        {
            randX=rand.nextDouble(minx,maxx);
            randY=rand.nextDouble(miny,maxy);
        }
        
        double point[]=new double[2];
        point[0]=randX;
        point[1]=randY;
        
        return point;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */