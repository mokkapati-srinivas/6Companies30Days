class Solution {
    public int longestMountain(int[] arr) {
        
        int maxMountain=0;
        int i=1;
        int n=arr.length;
        while(i<n)
        {
            int upSteps=0;
            int downSteps=0;
            while(i<n && arr[i-1]==arr[i])
                i++;
            
            while(i<n && arr[i-1]<arr[i])
            {
                upSteps++;
                i++;
            }
            
            while(i<n && arr[i-1]>arr[i])
            {
                downSteps++;
                i++;
            }
            
            if(upSteps!=0 && downSteps!=0)
            {
                int currMountainLen=upSteps+1+downSteps;
                maxMountain=Math.max(maxMountain,currMountainLen);   
            }
        }
        
        return maxMountain;
        
    }
}