class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> res =new ArrayList<>();
	    if(isLeaf(node)==false)
	        res.add(node.data);
	    addLeftBoundary(node,res);
	    addLeafNodes(node,res);
	    addRightBoundary(node,res);
	    return res;
	}
	boolean isLeaf(Node node)
	{
	    if(node.left==null && node.right==null)
	        return true;
	    else
	        return false;
	}
	void addLeftBoundary(Node node,ArrayList<Integer>res)
	{
	    Node curr=node.left;
	    while(curr!=null)
	    {
	        if(isLeaf(curr)==false)
	            res.add(curr.data);
	        if(curr.left!=null)
	            curr=curr.left;
	        else
	            curr=curr.right;
	    }
	}
	void addRightBoundary(Node node,ArrayList<Integer>res)
	{
	    Node curr=node.right;
	    ArrayList<Integer> temp=new ArrayList<>();
	    while(curr!=null)
	    {
	        if(isLeaf(curr)==false)
	            temp.add(curr.data);
	       if(curr.right!=null)
	             curr=curr.right;
	       else
	            curr=curr.left;
	    }
	    for(int i=temp.size()-1;i>=0;i--)
	    {
	        res.add(temp.get(i));
	    }
	}
	void addLeafNodes(Node node,ArrayList<Integer> res)
	{
	    if(node.left!=null)
	        addLeafNodes(node.left,res);
	        
	    if(isLeaf(node)==true)
	    {
	        res.add(node.data);
	        return;
	    }
	    if(node.right!=null)
	        addLeafNodes(node.right,res);
	}
}
