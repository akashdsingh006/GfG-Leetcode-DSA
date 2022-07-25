//User function Template for Java
class Tuple
{
    Node node;
    int v;
    int level;
    Tuple(Node node,int v,int level)
    {
        this.node=node;
        this.v=v;
        this.level=level;
    }
}

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        getVerticalTraversal(root,list);
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).size();j++)
            {
                res.add(list.get(i).get(j));
            }
        }
        return res;
    }
    static void getVerticalTraversal(Node root,ArrayList<ArrayList<Integer>> list)
    {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> qu=new LinkedList<>();
        qu.offer(new Tuple(root,0,0));
        while(qu.size()>0)
        {
            Tuple tup=qu.poll();
            Node node=tup.node;
            int x=tup.v;
            int y=tup.level;
            
            if(!map.containsKey(x))
            {
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);
            
            if(node.left !=null)
                qu.offer(new Tuple(node.left,x-1,y+1));
            if(node.right !=null)
                qu.offer(new Tuple(node.right,x+1,y+1));
        }
        
        for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values())
        {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values())
                {
                    while(nodes.size()>0)
                    {
                        list.get(list.size()-1).add(nodes.poll());
                    }
                }
        }
    }
}
