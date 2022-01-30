class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        int n=nums.length;
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            if(a.length()>b.length())
                return 1;
            else if(a.length()==b.length() && a.compareTo(b)>0)
                return 1;
            else
                return -1;
        });
        
        int size=0;
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
            size++;
            if(size>k)
            {
                pq.poll();
                size--;
            }
        }
        
        return pq.peek();
    }
}