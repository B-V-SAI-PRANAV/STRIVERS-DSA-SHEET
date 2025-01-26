public class levelOrderTraversal {
    public static List<Integer> levelOrder(TreeNode<Integer> root) {
        
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode<Integer>> que = new LinkedList<>();
        que.offer(root);
        int count = 0;
        
        while (!que.isEmpty()) {
            int levelSize = que.size(); 
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> current = que.poll();
                ans.add(current.data); 
                
                if (current.left != null) {
                    que.offer(current.left);
                }
                if (current.right != null) {
                    que.offer(current.right);
                }
            }
               
           
        }
        
        return ans; 
    }
}
