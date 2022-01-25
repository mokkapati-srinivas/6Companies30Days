class Solution {
    
    public int[] findOrderUtil(HashMap<Integer,ArrayList<Integer>> graph, int inDegree[], int n)
    {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
                queue.offer(i);
        }
        
        int order[]=new int[n];
        int ind=0;
        int count=0;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            order[ind++]=curr;
            for(int neigh: graph.get(curr))
            {
                inDegree[neigh]--;
                if(inDegree[neigh]==0)
                    queue.offer(neigh);
            }
            count++;
        }
        
        if(count==n)
            return order;
        else
            return new int[0];
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
        int inDegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            graph.put(i,new ArrayList<Integer>());
        }
        
        int p=prerequisites.length;
        for(int i=0;i<p;i++)
        {
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            graph.get(b).add(a);
            inDegree[a]++;
        }
        
        return findOrderUtil(graph,inDegree,numCourses);
    }
}