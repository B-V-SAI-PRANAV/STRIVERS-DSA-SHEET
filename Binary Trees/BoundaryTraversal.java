import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        if(!isLeaf(root)){
            list.add(root.data);
        }
        addLeftElements(root.left,list);
        addLeaves(root,list);
        addRightElements(root.right,list);
        return  list;
    }

    private static  boolean isLeaf(TreeNode node){
        return node.left==null&& node.right==null;
    }
    private static void addLeaves(TreeNode node ,List<Integer> list){
        if(node==null){
            return ;
        }
        if(isLeaf(node)){
            list.add(node.data);
        }
        addLeaves(node.left,list);
        addLeaves(node.right,list);
    }
    private static void addLeftElements(TreeNode node,List<Integer> list){
        while(node!=null){
            if(!isLeaf(node)){
                list.add(node.data);
            }
            node=(node.left==null)?node.right:node.left;
        }
    }


    private static void addRightElements(TreeNode node,List<Integer> list){
        List<Integer> temp=new ArrayList<>();
        while(node!=null){
            if(!isLeaf(node)){
                temp.add(node.data);
            }
            node=node.right==null?node.left:node.right;

        }
        Collections.reverse(temp);
        list.addAll(temp);
    }
}
