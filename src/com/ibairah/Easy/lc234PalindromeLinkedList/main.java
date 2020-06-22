package com.ibairah.Easy.lc234PalindromeLinkedList;

/**
 * Created by ibairah on 5/17/20.
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */

//https://www.youtube.com/watch?v=TM48V0N9YtE stack和分别展开的方法
//https://www.bilibili.com/video/BV16Q4y1M767?from=search&seid=10220634524050945593  reverse方法讲解
public class main {
    public static void main(String[] args) {

    }
}

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
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        if(fast != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null ){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre;
        ListNode cur = null;
        ListNode temp = head;
        while(temp != null){
            pre = cur;
            cur = temp;        // cur 等于刚存储的值
            temp = cur.next;   // temp等于存储了cur.next
            cur.next = pre;    // 切断连接，cur志向前一个
        }
        return cur;
    }
}