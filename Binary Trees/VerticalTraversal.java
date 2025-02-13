import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node,int row,int col){
        this.node=node ;
        this.row=row;
        this.col=col;

    }
}
public class VerticalTraversal {
    public static List<Integer> verticalOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> column = new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        Tuple tuple=new Tuple(root,0,0);
        q.offer(tuple);
        while(!q.isEmpty()){
            Tuple current=q.poll();
            TreeNode node=current.node;
            int x=current.row;
            int y=current.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);
            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));

            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
            
        }
         for (TreeMap<Integer, PriorityQueue<Integer>> rowMap : map.values()) {
            for (PriorityQueue<Integer> pq : rowMap.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }
        }
        return column;
        
    }
}
