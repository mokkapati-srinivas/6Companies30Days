class Solution {
    public int[] recoverArray(int n, int[] sums) {

        // https://leetcode.com/problems/find-array-given-subset-sums/discuss/1431457/Easy-Explanation-for-Noobs-+-Python-code-with-comments
        // Wonderful explanation
        
        ArrayList<Integer> subSums=new ArrayList<>();
        for(int sum: sums)
            subSums.add(sum);
        Collections.sort(subSums);
        
        int res[]=new int[n];
        int ind=0;
        
        int sumSize=(int)Math.pow(2,n);
        while(sumSize>1)
        {
            int num=subSums.get(sumSize-1)-subSums.get(sumSize-2);
            HashMap<Integer,Integer> freq=new HashMap<>();
            for(int sum: subSums)
            {
                int count=freq.getOrDefault(sum,0);
                freq.put(sum,count+1);
            }
            
            ArrayList<Integer> inclusion=new ArrayList<>();
            ArrayList<Integer> exclusion=new ArrayList<>();
            boolean zeroInExclusion=false;
            for(int sum: subSums)
            {
                if(freq.get(sum)>0)
                {
                    exclusion.add(sum);
                    inclusion.add((sum+num));
                    if(sum==0)
                        zeroInExclusion=true;
                    int count=freq.get(sum);
                    freq.put(sum,count-1);
                    count=freq.get((sum+num));
                    freq.put((num+sum),count-1);
                }
            }
            
            if(zeroInExclusion)
            {
                subSums=exclusion;
                res[ind++]=num;
                
            }
            else
            {
                subSums=inclusion;
                res[ind++]=(-1*num);
            }
            
            sumSize=sumSize/2;
            
        }
        
        return res;
    }
}