//You are given an array nodes. It contains 7 integers, which represents the value of nodes of the binary tree in level order traversal. You are also given a root of the tree which has a value equal to nodes[0].

class Solution{
    public static void createTree(Node root0, ArrayList<Integer> v ){
        // Code here
        if(v==null || v.isEmpty()){
            return;
        }
        Queue<Node> que=new LinkedList<>();
        que.offer(root0);
        int i=1;
        while(!que.isEmpty() && i<v.size()){
            Node current=que.poll();
            if(i<v.size()){
                current.left=new Node(v.get(i++));
                que.add(current.left);
            }
            if(i<v.size()){
                current.right=new Node(v.get(i++));
                que.add(current.right);
            }
        }
        
    }
}
