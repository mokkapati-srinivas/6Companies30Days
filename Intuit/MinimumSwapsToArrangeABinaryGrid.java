class Solution {
    
    public int getTrailingZeros(int row[], int n)
    {
        int zeros=0;
        for(int i=n-1;i>=0;i--)
        {
            if(row[i]==0)
                zeros++;
            else
                break;
        }
        
        return zeros;
    }
    
    public void swap(int arr[], int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    public int minSwaps(int[][] grid) {
        
        int n=grid.length;
        int trailingZeros[]=new int[n];
        for(int i=0;i<n;i++)
        {
            trailingZeros[i]=getTrailingZeros(grid[i],n);
        }
        
        int minSwaps=0;
        for(int i=0;i<n;i++)
        {
            int minTrailingZerosReq=n-i-1;
            int j=i;
            while(j<n && trailingZeros[j]<minTrailingZerosReq)
                j++;
            
            if(j==n)
                return -1;
            
            while(j>i)
            {
                minSwaps++;
                swap(trailingZeros,j,j-1);
                j--;
            }
        }
        
        return minSwaps;
    }
}