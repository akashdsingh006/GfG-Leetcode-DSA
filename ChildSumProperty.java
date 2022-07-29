// Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes. 



public static int isSumProperty(Node root)
    {
        // add your code here
        if(root==null)
            return 1;
        boolean[] b={true};
        traverse(root,b);
        if(b[0])
            return 1;
        else
            return 0;
    }
    static void traverse(Node root,boolean[] b)
    {
        int child=0;
        if(root==null ||(root.left==null && root.right==null))
            return;
      if(root.left!=null)
      {
         child+=root.left.data;
         traverse(root.left,b);
      }
      if(root.right!=null)
      {
         child+=root.right.data;
         traverse(root.right,b);
      }
        if(root.data!=child)
            b[0]=false;
    }
