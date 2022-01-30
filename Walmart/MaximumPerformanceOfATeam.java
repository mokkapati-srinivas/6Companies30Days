class Solution {
    
    class Engineer
    {
        int speed;
        int effec;
        Engineer(int s, int e)
        {
            this.speed=s;
            this.effec=e;
        }
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        // Think it this way. You're at an effeciency
        // Now in order to consider this effeciency into multiplication factor you have to have remaining effeciencies higher than current effeciency
        // So we sort effeciencies in reverse order
        // Now with curr effec, we have to choose atmost k from left side of the curr effec(since sorted reverse)
        // Now if we maintain a heap just to get our top k speeds everytime our job is done 

        ArrayList<Engineer> eng=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            eng.add(new Engineer(speed[i],efficiency[i]));
        }
        Collections.sort(eng,(a,b)->{
            return b.effec-a.effec;
        });
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long totalSpeed=0;
        long currPerform=0;
        long maxPerform=0;
        int size=0;
        for(Engineer e: eng)
        {
            int currSpeed=e.speed;
            int currEffec=e.effec;
            pq.add(currSpeed);
            size++;
            totalSpeed+=currSpeed;
            while(size>k)
            {
                int lowSpeed=pq.poll();
                totalSpeed-=lowSpeed;
                size--;
            }
            
            currPerform=totalSpeed*currEffec;
            maxPerform=Math.max(maxPerform,currPerform);
        }
        
        return (int)(maxPerform%1000000007);
    }
}