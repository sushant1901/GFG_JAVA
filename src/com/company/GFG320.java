class GfG
{
    static ArrayList<Integer> list;
    GfG(){
        list = new ArrayList<>();
    }
    public Node buildBalancedTree(Node root) 
    {
        inorder(root);
        Node start = null;
        start = convertToBST(start,0,list.size()-1);
        return start;
    }
    public static Node convertToBST(Node start,int l,int u){
        
        if(l>u){
            return null;
        }
        
        int mid = (l+u)/2;
        start = new Node(list.get(mid));
        start.left = convertToBST(start.left,l,mid-1);
        start.right = convertToBST(start.right,mid+1,u);
      
        return start;
    }
    public static void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
}
