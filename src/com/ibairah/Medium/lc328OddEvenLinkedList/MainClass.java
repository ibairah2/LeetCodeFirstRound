package com.ibairah.Medium.lc328OddEvenLinkedList;

/**
 * Created by ibairah on 6/21/20.
 *
 * Given a singly linked list, group all odd nodes together
 * followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1)
 * space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 *
 * Constraints:
 *
 * The relative order inside both the even and odd groups should
 * remain as it was in the input.
 * The first node is considered odd, the second node even and so on
 * ...
 * The length of the linked list is between [0, 10^4].
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

//把所有奇数位的数放在偶数位的数的前面
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //1. corner case
        if( head == null || head.next == null) return head;

        //2. create two dummy ListNode(in-place does not means you can not create dummy node)
        ListNode odd = head;
        ListNode even = head.next;
        //关键,先需要创建even的开头是他自己
        ListNode evenHead = even;

        //3. while loop with even condition, because even is the last element
        while(even != null && even.next != null ){
            odd.next = odd.next.next;   //先设定奇数的下一个是奇数位的值所以+2
            even.next = even.next.next;
            odd = odd.next;             //update当前位置，odd移动到下一个
            even = even.next;
        }
        odd.next = evenHead;        // connect odd and even
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    //ListNode(int val, ListNode next) {this.val = val;this.next = next;}
}

public class MainClass {
}
