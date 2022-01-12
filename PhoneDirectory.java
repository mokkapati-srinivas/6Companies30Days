// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class TrieNode
{
    HashMap<Character,TrieNode> children;
    boolean isEnd;
    
    TrieNode()
    {
        this.children=new HashMap<>();
        for(char i='a';i<='z';i++)
        {
            this.children.put(i,null);
        }
        
        this.isEnd=false;
    }
}

class Solution{
    
    static TrieNode root;
    
    static void buildTrie(String contact[], int n)
    {
        root=new TrieNode();
        
        for(int i=0;i<n;i++)
        {
            String curr=contact[i];
            int len=curr.length();
            TrieNode prevNode=root;
            for(int j=0;j<len;j++)
            {
                char currChar=curr.charAt(j);
                TrieNode currNode=prevNode.children.get(currChar);
                if(currNode==null)
                {
                    currNode=new TrieNode();
                    prevNode.children.put(currChar,currNode);
                }
                
                prevNode=currNode;
                
                if(j==len-1)
                    prevNode.isEnd=true;
            }
        }
    }
    
    static void addMatchedContacts(TrieNode currNode, String prefix, ArrayList<String> currMatches)
    {
        if(currNode.isEnd==true)
        {
            currMatches.add(prefix);
        }
        
        for(char i='a';i<='z';i++)
        {
            TrieNode nextNode=currNode.children.get(i);
            if(nextNode!=null)
                addMatchedContacts(nextNode,prefix+i,currMatches);
        }
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        root=null;
        buildTrie(contact,n);
        
        String prefix="";
        int len=s.length();
        ArrayList<ArrayList<String>> contactMatches=new ArrayList<>();
        TrieNode prevNode=root;
        int i=0;
        
        for(i=0;i<len;i++)
        {
            char currChar=s.charAt(i);
            prefix+=currChar;
            TrieNode currNode=prevNode.children.get(currChar);
            
            if(currNode!=null)
            {
                ArrayList<String> currMatches=new ArrayList<>();
                addMatchedContacts(currNode,prefix,currMatches);
                contactMatches.add(currMatches);
            }
            else
            {
                break;
            }
            
            prevNode=currNode;
        }
        
        for(;i<len;i++)
        {
            ArrayList<String> currMatches=new ArrayList<>();
            currMatches.add("0");
            contactMatches.add(currMatches);
        }
        
        return contactMatches;
        
    }
}