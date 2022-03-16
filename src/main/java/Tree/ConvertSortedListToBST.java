package Tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nValues = new ArrayList<>();

        ListNode t = head;
        while(t != null){
            nValues.add(t.val);
            t = t.next;
        }

        return buildTree(nValues, 0, nValues.size() - 1);

    }

    private TreeNode buildTree(List<Integer> nValues, int l, int r){
        if(l > r){
            return null;
        }

        int mid = l + (r - l) /2;
        TreeNode node = new TreeNode(nValues.get(mid));
        node.left = buildTree(nValues, l, mid -1);
        node.right = buildTree(nValues, mid +1 , r);
        return node;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int va){
            this.val = val;
        }
    }

    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }


}
