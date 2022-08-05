//Approach 1:
ArrayList<Integer> inOrder(Node root)
    {
         Code
         ArrayList<Integer> inorder=new ArrayList<>();
         Node cur=root;
         while(cur!=null)
         {
             if(cur.left==null)
             {
                 inorder.add(cur.data);
                 cur=cur.right;
             }
             else
             {
                 Node prev=cur.left;
                 while(prev.right!=cur && prev.right!=null)
                 {
                     prev=prev.right;
                 }
                 if(prev.right==null)
                 {
                     prev.right=cur;
                     cur=cur.left;
                 }
                   else
                   {
                     prev.right=null;
                     inorder.add(cur.data);
                     cur=cur.right;
                 }
            }
        }
        return inorder;
        }
  }
  
  
  
  //Approach 2:
  
   ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
       Stack <Node> st=new Stack<>();
       Node curr=root;
       while(st.size()>0 || curr!=null){
           while(curr!=null){
               st.push(curr);
               curr=curr.left;
           }
           curr=st.pop();
           ans.add(curr.data);
           curr=curr.right;
       }
       return ans;
