import java.util.*;
class Tuple{
    TreeNode node;
    int col;
    int row;
    public Tuple(TreeNode node,int col,int row){
        this.node=node;
        this.col=col;
        this.row=row;
    }
}
public class BottomView {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.    
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();     
        Tuple tuple=new Tuple(root,0,0);
        q.offer(tuple);
        while(!q.isEmpty()){
            Tuple current=q.poll();
            TreeNode node=current.node;
            int y=current.col;
            map.put(y,node.val);
            
            if(node.left!=null){
                q.offer(new Tuple(node.left,y-1,current.row+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,y+1,current.row+1));
            }
        }
        for(int values:map.values()){
            ans.add(values);
        }
        return ans;
    }
}
