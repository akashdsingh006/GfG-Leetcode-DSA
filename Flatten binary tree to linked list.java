class Solution
{
    //public static Node prev=null;
    public static void flatten(Node root)
    {
        //code here
        // if(root==null)
        //     return;
        // flatten(root.right);
        // flatten(root.left);
        
        // root.right=prev;
        // root.left=null;
        // prev=root;
        // return;
        Stack<Node> st=new Stack<>();
        st.push(root);
        while(st.size()>0)
        {
            Node curr=st.peek();
            st.pop();
            if(curr.right!=null)
            {
                st.push(curr.right);
            }
            if(curr.left!=null)
            {
                st.push(curr.left);
            }
            if(!st.isEmpty())
            {
                curr.right=st.peek();
            }
            curr.left=null;
        }
    }
}
