class Solution
{
    private Node first;
    private Node middle;
    private Node prev;
    private Node last;
    private void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null && (root.data<prev.data))
        {
            if(first==null)
            {
                first=prev;
                middle=root;
            }
            else
                last=root;
        }
        prev=root;
        inorder(root.right);
    }
    //Function to fix a given BST where two nodes are swapped.  
    public Node correctBST(Node root)
    {
        //code here.
        first=last=middle=null;
        prev=new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null)
        {
            int t=first.data;
            first.data=last.data;
            last.data=t;
        }
        else if(first!=null && middle!=null)
        {
            int t=first.data;
            first.data=middle.data;
            middle.data=t;
        }
        return root;
    }
}
