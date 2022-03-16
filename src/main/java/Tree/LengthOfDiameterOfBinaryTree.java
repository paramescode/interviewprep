package Tree;

public class LengthOfDiameterOfBinaryTree {

    int len = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return len;
    }

    private int dfs(TreeNode root){

        if(root == null)
            return 0;

        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);

        len = Math.max(len, leftLen + rightLen);

        return Math.max(leftLen , rightLen ) +  1;
    }
}
