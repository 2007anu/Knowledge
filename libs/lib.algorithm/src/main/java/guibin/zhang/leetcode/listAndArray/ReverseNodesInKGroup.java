package guibin.zhang.leetcode.listAndArray;

/**
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * 
 * http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
 * 
 * @author Gubin Zhang <guibin.beijing@gmail.com>
 */
public class ReverseNodesInKGroup {
    
    public class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, p1 = dummy;
        dummy.next = head;
        int i = 0;
        while (curr != null) {
            curr = curr.next;
            i++;
            if (i % k == 0) {
                if (curr != null) {
                    p1 = reverse_v2(p1, curr.next);
                    curr = p1;//Update curr after reverse.
                }
            }
        }
        return dummy.next;
    }
    
    public ListNode reverseKGroup_v2(ListNode head, int k) {
        
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = head;
        ListNode p1 = dummy;
        int i = 0;
        while (curr != null) {
            i++;
            if (i % k == 0) {
                /**
                 * After reverse, the linked list looks like below
                 * 
                 * |-------------|
                 * |             V
                 * p1  1 <- 2 <- 3  p2
                 *     |            ^
                 *     |____________|
                 *    p11
                 * 
                 * So we need to set p11 as the tail of reversed list, say 1, curr as p1.next.
                 * 
                 */
                p1 = reverse_v2(p1, curr.next);
                curr = p1.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    
    /**
     * Reverse list between p1 and p2 exclusively.
     * @param p1
     * @param p2 
     * @return  The tail of the reversed linked list
     */
    public ListNode reverse_v2(ListNode p1, ListNode p2) {
        
        ListNode curr = p1.next;
        ListNode tail = curr;
        ListNode prev = p1;
        ListNode nxt = null;
        
        while (curr != p2) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        tail.next = p2;
        p1.next = prev;
        
        return tail;
    }
    
    
    public static void main(String[] args) {
        ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
        ListNode a = rn.new ListNode(1);
        ListNode b = rn.new ListNode(2);
        ListNode c = rn.new ListNode(3);
        ListNode d = rn.new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode res = rn.reverseKGroup_v2(a, 4);
        
        while(res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
        System.out.println("");
    }
}
