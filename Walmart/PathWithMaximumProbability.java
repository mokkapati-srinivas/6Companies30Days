class Solution {
    
    class Pair
    {
        int node;
        double prob;
        
        Pair(int n, double p)
        {
            this.node=n;
            this.prob=p;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        HashMap<Integer,ArrayList<Pair>> graph=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            graph.put(i,new ArrayList<>());
        }
        int len=edges.length;
        for(int i=0;i<len;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            double prob=succProb[i];
            graph.get(a).add(new Pair(b,prob));
            graph.get(b).add(new Pair(a,prob));
        }
        
        double prob[]=new double[n];
        for(int i=0;i<n;i++)
        {
            prob[i]=Double.MIN_VALUE;
        }
        int visited[]=new int[n];
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            double prob1=a.prob;
            double prob2=b.prob;
            if(prob1>prob2)
                return -1;
            else
                return 1;
            
        });
        pq.add(new Pair(start,1));
        prob[start]=1;
        double maxProb=0;
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            int currNode=curr.node;
            double currProb=curr.prob;
            
            if(currNode==end)
            {
                maxProb=currProb;
                break;
            }
            
            if(visited[currNode]==0)
            {
                visited[currNode]=1;
                for(Pair neigh: graph.get(currNode))
                {
                    int neighNode=neigh.node;
                    double probOfEdge=neigh.prob;
                    double nextProb=currProb*probOfEdge;
                    if(visited[neighNode]==0 && prob[neighNode]<nextProb)
                    {
                        prob[neighNode]=nextProb;
                        pq.add(new Pair(neighNode,nextProb));
                    }
                }
            }
        }
        
        return maxProb;
    }
}