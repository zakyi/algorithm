package linklist;

import linklist.util.Node;

/**
 *
 *  单链表的一些简单的coding问题
 */


public class Coding {


    /*
    单链表反转
     */

    public static Node reverseLinkList(Node node){
        Node l1 = node.next;
        Node l2 = node.next.next;
        node.next = null;
        while(l2!=null){
            l1.next = node;
            node = l1;
            l1 = l2;
            l2 = l2.next;
        }
        l1.next = node;
        return l1;
    }

    /*
    打印出两个单链表公共部分
     */

    public static void publicNodes(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return;
        }

        while(node1 != null && node2 !=null){
            if(node1.value<node2.value){
                node1 = node1.next;
            }else if(node1.value > node2.value){
                node2 = node2.next;
            }else{
                System.out.print(node1.value+" ");
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }


    public static void main(String[] args) {
        Node node = util.createLinkList(new int[]{1,2,3,4,5,6,7});
        node = reverseLinkList(node);
        util.printLinkList(node);

        System.out.println("\n===================");

        Node node1 = util.createLinkList(new int[]{1,2,3,4,5,6,7});
        Node node2 = util.createLinkList(new int[]{2,2,3,4,5,7,8});
        publicNodes(node1,node2);

    }
}
