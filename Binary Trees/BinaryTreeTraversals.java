import java.util.*;
import java.util.List;
class Pair{
    TreeNode node;
    int number;
    public Pair(TreeNode node,int num)
    {
        this.node=node;
        this.number=num;
    }
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> ans=new ArrayList<>();
        Stack<Pair> stack=new Stack<>();
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        if(root==null){
            return ans;
        }
        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair current=stack.pop();
            TreeNode node=current.node;
            int num=current.number;
            if(num==1){
                pre.add(node.data);
                stack.push(new Pair(node,num+1));
                if(node.left!=null){
                    stack.push(new Pair(node.left,1));
                }
            }
            else if(num==2){
                in.add(node.data);
                stack.push(new Pair(node,num+1));
                if(node.right!=null){
                    stack.push(new Pair(node.right,1));
                }

            }
            else{
                post.add(node.data);
            }

        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}
