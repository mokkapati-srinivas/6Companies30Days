// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(nuts, bolts, n);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    
    void quickSortUsingTwoArrays(char nuts[], char bolts[], int low, int high)
    {
        if(low<high)
        {
            char pivotForNuts=bolts[high];
            int pivotInd=partition(nuts,low,high,nuts[high]);
            char pivotForBolts=nuts[pivotInd];
            partition(bolts,low,high,pivotForBolts);
            
            quickSortUsingTwoArrays(nuts,bolts,low,pivotInd-1);
            quickSortUsingTwoArrays(nuts,bolts,pivotInd+1,high);
        }
    }
    
    int partition(char arr[], int low, int high, char pivot)
    {
        int i=low;
        for(int j=low;j<high;j++)
        {
            if(arr[j]<pivot)
            {
                swap(arr,i,j);
                i++;
            }
            else if(arr[j]==pivot)
            {
                swap(arr,j,high);
                j--;
            }
        }
        
        swap(arr,i,high);
        
        return i;
    }
    
    void swap(char arr[], int i, int j)
    {
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        quickSortUsingTwoArrays(nuts,bolts,0,n-1);
    }
}