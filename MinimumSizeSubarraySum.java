class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n=nums.length;
        
        int start=0;
        int end=0;
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        
        while(end<n)
        {
            sum+=nums[end];
            
            while(sum>=target)
            {
                minLen=Math.min(minLen,(end-start+1));
                sum-=nums[start];
                start++;
            }
            end++;
        }
        
        if(minLen==Integer.MAX_VALUE)
            return 0;
        return minLen;
    }
}