package linklist;


public class lc21 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode node = new ListNode();
        node = list1.val > list2.val? list2 : list1;
        while(list1.next != null && list2.next !=null){
            if(list1.val > list2.val){
                ListNode temp = list2;
                list2 = list2.next;
                temp.next = list1;
            }else{
                ListNode temp = list1;
                list1 = list1.next;
                temp.next = list2;
            }
        }
        if(list1.next == null){
            ListNode temp = list2;
            list2 = list2.next;
            temp.next = list1;
            list1.next = list2;
        }
        if(list2.next == null){
            ListNode temp = list1;
            list1 = list1.next;
            temp.next = list2;
            list2.next = list1;
        }
        return node;
    }


    public static void main(String[] args) {

    }
}
