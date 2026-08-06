package com.dsa.LinkedList;

import java.util.List;

public class FlatterningTheList {
    public FlatterningTheList() {
    }

    public class ListNode {
        private int val;
        private ListNode next;
        private ListNode bottom;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FlatTheList(ListNode head){
        if(head == null && head.next == null)
            return head;
        ListNode mergedHead = FlatTheList(head.next);
        return merge(head, mergedHead);
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        if (l1.val < l2.val) {
            dummy = l1;
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode(0);
            while (l1 != null && l1.val <= l2.val){
                temp = l1;
                l1 = l1.bottom;
            }
            temp.bottom = l2;

            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        return dummy;
   }
}
