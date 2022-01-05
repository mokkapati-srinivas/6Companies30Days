import java.util.*;

class FindMax10NumbersInAListHaving10M
{
    public List<Integer> get10Max(ArrayList<Integer> tenMEntries)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>(10, Collections.reverseOrder());
        int n=10000000;

        for(int i=0;i<n;i++)
        {
            int curr=tenMEntries.get(i);
            if(i<10)
            {
                pq.add(curr);
            }
            else
            {
                int minEle=pq.poll();
                if(curr<minEle)
                {
                    pq.add(curr);
                }
                else
                {
                    pq.add(minEle);
                }
            }
        }

        List<Integer> tenMaxElements=new ArrayList<>;
        for(int i=0;i<10;i++)
        {
            tenMaxElements.add(pq.poll());
        }

        return tenMaxElements;
    }
}