public class  PostorderTraversal{
    public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        // Write your code here
        List<Integer> ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    private static void helper(TreeNode node,List<Integer> ans){
        if(node==null){
            return ;
        }
        helper(node.left,ans);
        helper(node.right,ans);
        ans.add((int)node.data);
    }
}
