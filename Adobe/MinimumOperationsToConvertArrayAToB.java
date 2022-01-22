// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);
                
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int binarySearch(ArrayList<Integer> seq, int low, int high, int curr)
    {
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(seq.get(mid)==curr)
                return mid;
            else if(seq.get(mid)>curr)
                high=mid-1;
            else
                low=mid+1;
        }
        
        return low;
    }
    
    static int lis(ArrayList<Integer> a, int n)
    {
        if(n==0)
            return 0;
        
        ArrayList<Integer> sequence=new ArrayList<>();
        sequence.add(a.get(0));
        int seqSize=1;
        for(int i=1;i<n;i++)
        {
            int curr=a.get(i);
            int seqCurr=sequence.get(seqSize-1);
            if(curr>seqCurr)
            {
                sequence.add(curr);
                seqSize++;
            }
            else
            {
                int ind=binarySearch(sequence,0,seqSize-1,curr);
                sequence.set(ind,curr);
            }
        }
        
        return seqSize;
    }
    
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // code here
        HashSet<Integer> b=new HashSet<>();
        for(int i=0;i<M;i++)
        {
            b.add(B[i]);
        }
        
        ArrayList<Integer> aCommon=new ArrayList<>();
        int aCount=0;
        for(int i=0;i<N;i++)
        {
            if(b.contains(A[i]))
            {
                aCommon.add(A[i]);
                aCount++;
            }
        }
        
        int lisCount=lis(aCommon,aCount);
        
        return ((N-lisCount)+(M-lisCount));
    }
};