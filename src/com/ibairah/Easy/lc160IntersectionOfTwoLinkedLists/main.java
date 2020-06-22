package com.ibairah.Easy.lc160IntersectionOfTwoLinkedLists;

/**
 * Created by ibairah on 5/11/20.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *    a1->a2->
 *            c1->c2->c3
 *b1->b2->b3->
 * begin to intersect at node c1.
 *
 * Example 1:
 *  4->1->
 *          8->4->5
 *5->0->1->
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not
 * be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5].
 * From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the
 * intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 * 0->9->1->
 *          2->4
 *       3->
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not
 * be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4].
 * From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
 * node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *2->6->4
 *
 *   1->5
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B,
 * it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 * while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */


public class main {
    public static void main(String[] args) {

    }
}

//    本题和141一个意思，都是找链表多久能相遇

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointer1 = headA;
        ListNode pointer2 = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

            if (pointer1 == pointer2) {
                return pointer1;
            }

            // pointer1 可以等于headA,但是runtime变成600ms，
            // 而通过pointer1=headB，只需要1ms runtime
            // ！！可能是因为为了寻找两个node 交互，则把指针放到相互的node上
            if (pointer1 == null) {
                pointer1 = headB;
            }
            if (pointer2 == null) {
                pointer2 = headA;
            }
        }
        return pointer1;
    }
}
