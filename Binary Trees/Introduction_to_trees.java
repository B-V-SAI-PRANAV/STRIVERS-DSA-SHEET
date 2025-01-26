Print the maximum number of nodes on level i of a binary tree.



class Solution {
    static int countNodes(int i) {
        // code here
        return  (int)Math.pow(2,i-1);
    }
}
