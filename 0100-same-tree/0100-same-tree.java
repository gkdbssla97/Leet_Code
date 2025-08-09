/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static List<Integer> arr1;
    static List<Integer> arr2;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        //전위순회로 다 밀면 되지않나?
        preOrder(p, 1);
        preOrder(q, 2);
        boolean isEqual = IntStream.range(0, arr1.size()).allMatch(e -> arr1.get(e).equals(arr2.get(e)));
        System.out.println(arr1);
        System.out.println(arr2);
        return isEqual;
    }
    public void preOrder(TreeNode p, int i) {
        if(p == null) {
            // System.out.println("널이다");
            if(i == 1) arr1.add(1_000_000);
        if(i == 2) arr2.add(1_000_000);
            return;
        }
        System.out.println(p.val);
        if(i == 1) arr1.add(p.val);
        if(i == 2) arr2.add(p.val);
        preOrder(p.left, i);
        preOrder(p.right, i);
    }
}