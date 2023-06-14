/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//leetcode 24
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||(head.next==null))
        {
return head;

}
       ListNode swapped_head= swap(head);
        head = swapped_head.next; // head = 2nd node after swapping
      //  if((head==null)||(head.next==null))
        {
//return head;
}
        ListNode headfinal = swapped_head;
        while(head.next!=null)
        {
            System.out.println("next= "+head.next.val);
swapped_head = swap(head.next);
            if(swapped_head==head.next)
            {
break;
}
            head.next = swapped_head;
            if(head.next.next!=null)
            {

            head = head.next.next;
            }
        

}
        return headfinal;
    }
    
    ListNode swap(ListNode head)
    {
        ListNode temp = null;
        if(head.next!=null)
        {

temp = head.next;
        }
else return head;
        ListNode rest = null;
        if(head.next.next!=null)
        {
rest = head.next.next;
            head.next.next = head;
}
    temp.next = head;
        head.next = rest;
        head = temp;
        return head;

}
}
