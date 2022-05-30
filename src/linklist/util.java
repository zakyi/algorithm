package linklist;

import java.util.Comparator;

public class util {
    public static class Node{
        public int value;
        public Node next;
        public Node(int val){
            value = val;
        }
        public Node(){
            value = Integer.MIN_VALUE;
        }
    }

    public class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            return o1.value - o2.value;
        }
    }
    /*
    创建无头单链表
     */
    public static Node createLinkList(int[] arr){
        if(arr == null){
            return null;
        }
        Node node = new Node(arr[0]);
        Node head = node;
        for(int i=1;i<arr.length;i++){
            node.next = new Node(arr[i]);
            node = node.next;
        }
        node.next = null;
        return head;
    }
//    /*
//   创建有头单链表
//    */
//    public static Node createHeadLinkList(int[] arr){
//        if(arr == null){
//            return null;
//        }
//        Node node = new Node();
//        Node head = node;
//        for(int i=1;i<arr.length;i++){
//            node.next = new Node(arr[i]);
//            node = node.next;
//        }
//        node.next = null;
//        return head;
//    }

    /*
    打印单链表
     */
    public static void printLinkList(Node node){
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}


