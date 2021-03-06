package guibin.zhang.leetcode.listAndArray;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * 
 * Run Status: Accepted!
 * Program Runtime: 676 milli secs
 * Progress: 164/164 test cases passed.
 * 
 * @author Gubin Zhang <guibin.beijing@gmail.com>
 */
public class RemoveDuplicatesFromSortedList {
    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode deleteDuplicates_v3(ListNode head) {
            
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            
            ListNode curr = dummy;
            while (curr.next != null) {
                ListNode nxt = curr.next;
                while (nxt.next != null && nxt.val == nxt.next.val) {
                    nxt = nxt.next;
                }
                curr.next = nxt;
                curr = curr.next;
            }
            
            return dummy.next;
        }
    
    //Remove duplicated node
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) {
            if (prev == null) {
                prev = curr;
                curr = curr.next;
            } else {
                if (prev.val == curr.val) {
                    ListNode nxt = curr.next;
                    prev.next = nxt;//Remove/Skip curr
                    curr.next = null;
                    curr = nxt;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
    
    //Copy non-duplicated value
    public ListNode deleteDuplicates_v2(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode idx = head;
        ListNode curr = head.next;
        
        while (curr != null) {
            if (curr.val != idx.val) {
                //Copy values from curr to idx.next
                idx.next.val = curr.val;
                idx = idx.next;
            }
            curr = curr.next;
        }
        idx.next = null;
        return head;
    }
}
