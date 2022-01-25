/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1))
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        int peakInd=low;
        
        low=0;
        high=peakInd;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int midEle=mountainArr.get(mid);
            if(midEle==target)
                return mid;
            else if(midEle<target)
                low=mid+1;
            else
                high=mid-1;
        }
        
        low=peakInd+1;
        high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int midEle=mountainArr.get(mid);
            if(midEle==target)
                return mid;
            else if(midEle<target)
                high=mid-1;
            else
                low=mid+1;
        }
        
        return -1;
    }
}