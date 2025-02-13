import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// import javax.swing.tree.TreeNode;
class Tuple{
    TreeNode node;
    int col;
    public Tuple(TreeNode node,int col){
        this.node=node;
        this.col=col;
    }
}
public class TopView {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> result=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        Tuple tuple=new Tuple(root,0);
        q.offer(tuple);
        while(!q.isEmpty()){
            Tuple current=q.poll();
            TreeNode node=current.node;
            int x=current.col;
            if(!map.containsKey(x)){
                map.put(x,node.data);

            }
            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right, x+1));
            }
            
        }
        for(int value:map.values()){
            result.add(value);
        }
        return result;
    }
}
