class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<in.length;i++)
        {
            map.put(in[i],i);
        }
        Node node=getBuildTree(in,0,n-1,post,0,n-1,map);
        return node;
    }
    Node getBuildTree(int[] in,int inStart,int inEnd,int[] post,int postStart,
                        int postEnd,HashMap<Integer,Integer> map)
    {
        if(postStart>postEnd || inStart>inEnd)
            return null;
        Node root=new Node(post[postEnd]);
        int inRoot=map.get(post[postEnd]);
        int numsLeft=inRoot-inStart;
        
        root.left=getBuildTree(in,inStart,inRoot-1,post,postStart,postStart+numsLeft-1,map);
        root.right=getBuildTree(in,inRoot+1,inEnd,post,postStart+numsLeft,postEnd-1,map);
        
        return root;
    }
}
