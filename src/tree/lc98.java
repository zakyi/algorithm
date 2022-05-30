package tree;
import tree.BinaryTree.TreeNode;

import static tree.BinaryTree.*;

public class lc98 {
    public static boolean isValidBST(TreeNode root) {
        double[] preValue = new double[]{-Double.MAX_VALUE} ;

        return process(root, preValue);

    }

    public static boolean process(TreeNode root, double[] preValue){
        if(root == null){
            return true;
        }

        if(process(root.left,preValue) == false){
            return false;
        }
        if(root.val <= preValue[0]){
            return false;
        }
        preValue[0] = root.val;
        if(process(root.right,preValue) == false){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,1};
        TreeNode root = BinaryTree(array);
        System.out.println(isValidBST(root));
    }
}
