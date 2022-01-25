class Solution {
    public int splitArray(int[] nums, int m) {
        
        int n=nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        
        int low=max;
        int high=sum;
        int maxSum=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int subArraySum=0;
            int noOfSubarrays=1;
            for(int i=0;i<n;i++)
            {
                subArraySum+=nums[i];
                if(subArraySum>mid)
                {
                    noOfSubarrays++;
                    subArraySum=nums[i];
                }
            }
            
            if(noOfSubarrays<=m)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return low;
    }
}