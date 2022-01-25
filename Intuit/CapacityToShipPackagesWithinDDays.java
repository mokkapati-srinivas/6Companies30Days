class Solution {
    
    public int getDaysWithCurrMaxWeight(int weights[], int weight, int n)
    {
        int totWeight=0;
        int days=1;
        for(int i=0;i<n;i++)
        {
            totWeight+=weights[i];
            if(totWeight>weight)
            {
                days++;
                totWeight=weights[i];
            }
        }
        
        return days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        
        int low=max;
        int high=sum;
        int leastWeight=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int daysWithCurrMaxWeight=getDaysWithCurrMaxWeight(weights,mid,n);
            if(daysWithCurrMaxWeight<=days)
            {
                leastWeight=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return leastWeight;
        
    }
}