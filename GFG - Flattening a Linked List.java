/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    
    public static Node merge(Node root, Node mergedRoot){
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(root!=null && mergedRoot!=null){
            if(root.data<mergedRoot.data){
                res.bottom=root;
                res=root;
                root=root.bottom;
            }
            else{
                res.bottom=mergedRoot;
                res=mergedRoot;
                mergedRoot=mergedRoot.bottom;
            }
            res.next=null;
        }
        if(root!=null){
            res.bottom=root;
        }
        else {
            res.bottom=mergedRoot;
        }
        if(dummyNode.bottom!=null){
            dummyNode.bottom.next=null;
        }
        return dummyNode.bottom;
    }
    
    public Node flatten(Node root) {
        // code here
        if(root==null || root.next==null) return root;
        Node mergedRoot = flatten(root.next);
        root = merge(root,mergedRoot);
        return root;
    }
}
