public class LeftView {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        Queue<TreeNode<Integer>> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int levelSize=que.size();
            for(int i=0;i<levelSize;i++){
                TreeNode<Integer> current=que.poll();
                if(i==0){
                    System.out.print(current.data+" ");
                }
                if(current.left!=null){
                    que.offer(current.left);
                }
                if(current.right!=null){
                    que.offer(current.right);
                }
            }
        }
    }
}
