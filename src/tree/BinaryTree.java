package tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 层次遍历建立二叉树
 */

public class BinaryTree {

    public static class TreeNode{
        public int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode BinaryTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        int len = array.length;
        Deque<TreeNode> treeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(array[0]);
        treeQueue.offer(root);
        //遍历数组
        for (int index = 1; index < len; index++) {
            TreeNode currNode = treeQueue.poll();
            if (array[index] != null) {
                TreeNode leftNode = new TreeNode(array[index]);
                currNode.left = leftNode;
                treeQueue.offer(leftNode);
            }
            index++;
            if (index >= len) {
                return root;
            }
            if (array[index] != null) {
                TreeNode rightNode = new TreeNode(array[index]);
                currNode.right = rightNode;
                treeQueue.offer(rightNode);
            }
        }
        return root;
    }

    public static void preorderTraversal(TreeNode node){
        if(node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void inorderTraversal(TreeNode node){
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    public static void postorderTraversal(TreeNode node){
        if(node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val + " ");
    }


    public static List<TreeNode> preorderTraversalNoRecurse(TreeNode node){
        List<TreeNode> resultList = new ArrayList<>();

        if(node == null) {
            return resultList;
        }
        Stack<TreeNode> treeStack  = new Stack<>();

        treeStack.push(node);

        while(!treeStack.isEmpty()){
            TreeNode tempNode = treeStack.pop();
            if(tempNode != null){
                resultList.add(tempNode);
                treeStack.push(tempNode.right);
                treeStack.push(tempNode.left);
            }
        }

        return resultList;
    }

    public static List<TreeNode> inorderTraversalNoRecurse(TreeNode node){
        List<TreeNode> resultList = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode cur = node;

        while(cur != null || !treeStack.isEmpty()){
            while(cur != null){
                treeStack.push(cur);
                cur = cur.left;
            }
            cur = treeStack.pop();
            resultList.add(cur);
            cur = cur.right;
        }
        return resultList;
    }

    public static List<TreeNode> postorderTraversalNoRecurse(TreeNode node){
        List<TreeNode> resultList = new ArrayList<>();

        if(node == null) {
            return resultList;
        }
        Stack<TreeNode> treeStack  = new Stack<>();
        Stack<TreeNode> collectStack  = new Stack<>();

        treeStack.push(node);

        while(!treeStack.isEmpty()){
            TreeNode tempNode = treeStack.pop();
            if(tempNode != null){
                collectStack.push(tempNode);
                treeStack.push(tempNode.left);
                treeStack.push(tempNode.right);
            }
        }
        while(!collectStack.isEmpty()){
            resultList.add(collectStack.pop());
        }

        return resultList;
    }

    public static List<TreeNode> HierarchicalTraversal(TreeNode root){
        List<TreeNode> resultList = new ArrayList<>();
        if(root == null){
            return null;
        }if(root.left == null && root.right == null){
            resultList.add(root);
            return resultList;
        }
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            TreeNode node = treeQueue.poll();
            resultList.add(node);
            if(node.left!=null){
                treeQueue.add(node.left);
            }
            if(node.right!=null){
                treeQueue.add(node.right);
            }
        }
        return resultList;
    }



    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }if(root.left == null && root.right == null){
            return 1;
        }
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        TreeNode nextLast = new TreeNode();
        TreeNode thisLast = root;
        treeQueue.add(root);
        int lev = 0;
        while(!treeQueue.isEmpty()){
            TreeNode node = treeQueue.poll();
            if(node.left!=null){
                treeQueue.add(node.left);
                nextLast = node.left;
            }
            if(node.right!=null){
                treeQueue.add(node.right);
                nextLast = node.right;
            }
            if(node == thisLast){
                thisLast = nextLast;
                lev++;
            }
        }
        return lev;
    }

    // Encodes a tree to a single string.
    //层次遍历序列化二叉树
    public static String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }if(root.left == null && root.right == null){
            return "["+root.val+"]";
        }
        String resultString = "[";
        //计算树的高度
        int depth = maxDepth(root);
        TreeNode nextLast = new TreeNode();
        TreeNode thisLast = root;
        int lev = 0;

        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.add(root);
        //是否遍历到 倒数第二行的 thisLast节点
        int flag=0;


        while(!treeQueue.isEmpty()){
            TreeNode node = treeQueue.poll();

            if(node.val != -1001){
                resultString += node.val+",";
            }else{
                resultString += "null,";
            }

            if(node == thisLast && lev == depth - 2){
                //当遍历到倒数第二行的thisLast节点时，flag置1，此后的null节点都不用处理
                flag = 1;
                if(node.left!=null){
                    treeQueue.add(node.left);
                }else if(node.val!=-1001 && node.right!=null){
                    treeQueue.add(new TreeNode(-1001));
                }
                if(node.right!=null){
                    treeQueue.add(node.right);
                }
                thisLast = nextLast;
                lev++;
                continue;
            }

            if(node.left!=null){
                treeQueue.add(node.left);
                nextLast = node.left;
            }else if(node.val!=-1001 && flag==0){
                treeQueue.add(new TreeNode(-1001));
            }
            if(node.right!=null){
                treeQueue.add(node.right);
                nextLast = node.right;
            }else if(node.val!=-1001 && flag==0){
                treeQueue.add(new TreeNode(-1001));
            }

            if(node == thisLast){
                thisLast = nextLast;
                lev++;
            }
        }
        return resultString.substring(0,resultString.length()-1) + "]";
    }

    // Decodes your encoded data to tree.
    // 层次遍历构建二叉树
    public static TreeNode deserialize(String data) {
        data = data.substring(1,data.length()-1);
        String[] dataList = data.split(",");

        Integer[] inputList = new Integer[dataList.length];
        for(int i=0; i<dataList.length;i++){
            if(!Objects.equals(dataList[i], "null")){
                inputList[i] = Integer.parseInt(dataList[i]);
            }else{
                inputList[i] = null;
            }
        }
        return BinaryTree(inputList);
    }




    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,6,3,4,7,8};
        TreeNode root = BinaryTree(array);
        preorderTraversal(root);
        System.out.println(" ");
        inorderTraversal(root);
        System.out.println(" ");
        postorderTraversal(root);
        System.out.println(" ");
        System.out.println("preorderTraversalNoRecurse");
        List<TreeNode> resPre = preorderTraversalNoRecurse(root);
        for(TreeNode i :resPre){
            System.out.print(i.val);
            System.out.print(" ");
        }
        System.out.println("\npreorderTraversalNoRecurse");
        System.out.println("inorderTraversalNoRecurse");
        List<TreeNode> resIn = inorderTraversalNoRecurse(root);
        for(TreeNode i :resIn){
            System.out.print(i.val);
            System.out.print(" ");
        }
        System.out.println("\ninorderTraversalNoRecurse");
        System.out.println("postorderTraversalNoRecurse");
        List<TreeNode> resPost = postorderTraversalNoRecurse(root);
        for(TreeNode i :resPost){
            System.out.print(i.val);
            System.out.print(" ");
        }
        System.out.println("\npostorderTraversalNoRecurse");
        System.out.println("maxDepth");
        Integer[] array1 = new Integer[]{1,2,3,4,5};
        TreeNode root1 = BinaryTree(array1);
        System.out.println(maxDepth(root1));
        System.out.println("maxDepth");
        System.out.println("HierarchicalTraversal");
        List<TreeNode> resHier = HierarchicalTraversal(root);
        for(TreeNode i :resHier){
            System.out.print(i.val);
            System.out.print(" ");
        }
        System.out.println("\nHierarchicalTraversal");
        System.out.println("serialize");
        Integer[] array2 = new Integer[]{1,2,3,null,null,4,5,6,7};
        TreeNode root2 = BinaryTree(array2);
        String serializeString = serialize(root2);
        System.out.println(serializeString);
        System.out.println("serialize");

        System.out.println("deserialize");
        String data = "[1,2,3,null,null,4,5,6,7]";
        TreeNode root3 = deserialize(serialize(root2));
        List<TreeNode> resHier1 = HierarchicalTraversal(root3);
        for(TreeNode i :resHier1){
            System.out.print(i.val);
            System.out.print(" ");
        }
        System.out.println("\ndeserialize");


    }
}
