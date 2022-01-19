// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static Node prepareParentMapAndReturnTarget(Node root, HashMap<Node,Node> parent, int target)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        Node targetNode=null;
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            if(curr.data==target)
            {
                targetNode=curr;
            }
            Node currLeft=curr.left;
            Node currRight=curr.right;
            if(currLeft!=null)
            {
                parent.put(currLeft,curr);
                queue.add(currLeft);
            }
            if(currRight!=null)
            {
                parent.put(currRight,curr);
                queue.add(currRight);
            }
        }
        
        return targetNode;
    }
    
    public static void addToQueue(Node curr, HashMap<Node,Node> parent, Queue<Node> queue, HashSet<Node> visited)
    {
        Node currLeft=curr.left;
        Node currRight=curr.right;
        Node currParent=parent.get(curr);
        if(currLeft!=null && !visited.contains(currLeft))
        {
            queue.add(currLeft);
            visited.add(currLeft);
        }
        if(currRight!=null && !visited.contains(currRight))
        {
            queue.add(currRight);
            visited.add(currRight);
        }
        if(currParent!=null && !visited.contains(currParent))
        {
            queue.add(currParent);
            visited.add(currParent);
        }
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node,Node> parent=new HashMap<>();
        Node targetNode=prepareParentMapAndReturnTarget(root,parent,target);
        
        int seconds=0;
        Queue<Node> queue=new LinkedList<>();
        queue.add(targetNode);
        HashSet<Node> visited=new HashSet<>();
        visited.add(targetNode);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                Node curr=queue.poll();
                addToQueue(curr,parent,queue,visited);
            }
            seconds++;
        }
        
        return seconds-1;
    }
}