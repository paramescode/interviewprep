package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreOrderNPostOrder {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        private static int preIndex = 0;

        public static TreeNode constructFromPrePost(int[]pre, int[] post) {
            if(pre == null || post == null || pre.length != post.length)
                return null;

            TreeNode res = buildTree(pre, post, 0, pre.length - 1,  post.length);
            preIndex = 0;
            return res;
        }

        private static TreeNode buildTree(int[] pre, int[] post, int l, int r,  int size){
            // System.out.println(l +" ---"+ r);
            if( preIndex >= size || l > r )
                return null;

            TreeNode root = new TreeNode(pre[preIndex]);
            preIndex++;
            //  System.out.println("aaa " + root.val);
            if(l == r || preIndex >= size)
                return root;

            int i;
            for(i =l; i <= r; i++){
                if(pre[preIndex] == post[i])
                    break;
            }
            //System.out.println(pre[preIndex] +" ++++"+ i);
            //System.out.println(l + " " + i +" i, l, r"+ r);
            if( i <= r){
                root.left = buildTree(pre, post, l, i, size) ;
                root.right= buildTree(pre, post, i + 1, r - 1, size);
            }

            return root;
        }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode res = constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});

    }
}
