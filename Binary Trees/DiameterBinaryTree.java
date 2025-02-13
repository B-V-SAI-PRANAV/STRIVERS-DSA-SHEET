class DiameterBinaryTree {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
      height(root);
      return diameter-1;
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lh=height(node.left);
        int rh=height(node.right);
        int dia=lh+rh+1;
        diameter=Math.max(dia,diameter);
        return Math.max(lh,rh)+1;
    }
}
