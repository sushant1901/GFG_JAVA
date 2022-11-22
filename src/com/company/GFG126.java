class Solution
{
    class Node{
        int data;
        Node left;
        Node right;
        
        Node(){
            
        }
        Node(int data){
            this.data=data;
        }
    }
    public int[] sortedArrayToBST(int[] arr)
    {
        ArrayList<Integer> list=new ArrayList<>();
        Node root=tobst(arr,0,arr.length-1);
        preorder(root,list);
        return list.stream().mapToInt(i->i).toArray();
    }
    Node tobst(int[] arr, int lo, int hi){
        if(lo>hi) return null;
        int mid=(lo+hi)/2;
        Node root=new Node(arr[mid]);
        
        root.left=tobst(arr,lo,mid-1);
        root.right=tobst(arr,mid+1,hi);
        
        return root;
    }
    void preorder(Node node, ArrayList<Integer> list){
        if(node==null) return ;
        list.add(node.data);
        preorder(node.left,list);
        preorder(node.right,list);
    }
}
