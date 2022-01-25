class Solution {
    
    public int getHrsWithCurrRate(int piles[], int n, int currRate)
    {
        int hrs=0;
        for(int i=0;i<n;i++)
        {
            if(piles[i]%currRate==0)
                hrs+=(piles[i]/currRate);
            else
                hrs+=(piles[i]/currRate)+1;
        }
        
        return hrs;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,piles[i]);
        }
        
        int low=1;
        int high=max;
        int minRate=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int hrsWithCurrRate=getHrsWithCurrRate(piles,n,mid);
            if(hrsWithCurrRate<=h)
            {
                minRate=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        
        return minRate;
    }
}