
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node> queue=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        root.hd=0;
        queue.add(root);
        while(queue.size()>0)
        {
            Node temp=queue.remove();
            int hd=temp.hd;
            map.put(hd,temp.data);
            if(temp.left!=null)
            {
                temp.left.hd=hd-1;
                queue.add(temp.left);
            }
            if(temp.right!=null)
            {
                temp.right.hd=hd+1;
                queue.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> mp :map.entrySet())
        {
            ans.add(mp.getValue());
        }
        return ans;
    }
}
