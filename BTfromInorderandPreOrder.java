public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        Node node=getBuildTree(preorder,0,n-1,inorder,0,n-1,map);
        return node;
    }
    public static Node getBuildTree(int[] preorder,int preStart,int preEnd,int[]inorder,
                                int inStart,int inEnd,HashMap<Integer,Integer> map)
    {
        if(preStart>preEnd || inStart>inEnd)
            return null;
        Node root=new Node(preorder[preStart]);
        
        int inRoot=map.get(root.data);
        int numsleft=inRoot-inStart;
        
        root.left=getBuildTree(preorder,preStart+1,preStart+numsleft,inorder,inStart,inRoot-1,map);
        root.right=getBuildTree(preorder,preStart+1+numsleft,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
    }
