package com.ibairah.Medium.lc19RemoveNthNodeFromEndofList;

/**
 * Created by ibairah on 5/28/20.
 * Given a linked list, remove the n-th node from the end of list
 * and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list
 * becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */

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

class Solution {
    // One Pass method
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;

        ListNode slow = dummy_head;
        ListNode fast = dummy_head;

        for(int i = 1; i<n+1; i++){
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        //跳过倒数Nth的数
        slow.next = slow.next.next;
        return dummy_head;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int counter = 0;
        ListNode first = head;
        // 先遍历整个linked list，计算整个长度
        // ! ！因为linked list没法直接知道长度
        while (first != null) {
            counter++;
            first = first.next;
        }
        // 减去要求的值
        counter -= n;

        first = dummy;
        while (counter > 0) {
            counter--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy;
    }
}
public class MainClass {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}