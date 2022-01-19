// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public String getSortedOrderAlien(HashMap<Character,HashSet<Character>> adj, HashMap<Character,Integer> inDegree, int k)
    {
        Queue<Character> queue=new LinkedList<>();
        String res="";
        for(char c: inDegree.keySet())
        {
            if(inDegree.get(c)==0)
            {
                queue.add(c);
            }
        }
        
        while(!queue.isEmpty())
        {
            char curr=queue.poll();
            res+=curr;
            for(char neigh: adj.get(curr))
            {
                int count=inDegree.get(neigh);
                inDegree.put(neigh,count-1);
                if((count-1)==0)
                {
                    queue.add(neigh);
                }
            }
        }
        
        return res;
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashMap<Character,HashSet<Character>> adj=new HashMap<>();
        for(char c='a';c<=('a'+K);c++)
            adj.put(c,new HashSet<>());
            
        HashMap<Character,Integer> inDegree=new HashMap<>();
        for(char c='a';c<=('a'+K);c++)
            inDegree.put(c,0);
        
        String s1="",s2="";
        for(int i=0;i<N-1;i++)
        {
            s1=dict[i];
            s2=dict[i+1];
            int s1Len=s1.length();
            int s2Len=s2.length();
            int len=Math.min(s1Len,s2Len);
            for(int k=0;k<len;k++)
            {
                char c1=s1.charAt(k);
                char c2=s2.charAt(k);
                if(c1!=c2)
                {
                    adj.get(c1).add(c2);
                    int count=inDegree.get(c2);
                    inDegree.put(c2,count+1);
                    break;
                }
            }
        }
        
        String result=getSortedOrderAlien(adj,inDegree,K);
        return result;
        
    }
}