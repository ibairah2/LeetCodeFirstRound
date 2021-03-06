package com.ibairah.Medium.lc430FlattenaMultilevelDoublyLinkedList;

/**
 * Created by ibairah on 2020/7/11.
 *
 * You are given a doubly linked list which in addition to the next
 * and previous pointers, it could have a child pointer, which may
 * or may not point to a separate doubly linked list. These child
 * lists may have one or more children of their own, and so on, to
 * produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level,
 * doubly linked list. You are given the head of the first level of
 * the list.
 *
 *  
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 *
 *
 *
 * After flattening the multilevel linked list it becomes:
 *
 *
 * Example 2:
 *
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *  
 *
 * How multilevel linked list is represented in test case:
 *
 * We use the multilevel linked list from Example 1 above:
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * The serialization of each level is as follows:
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * To serialize all levels together we will add nulls in each level
 * to signify no node connects to the upper node of the previous
 * level. The serialization becomes:
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * Merging the serialization of each level and removing trailing
 * nulls we obtain:
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *  
 *
 * Constraints:
 *
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */


/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
//想象成一颗二叉树，child是左子树，next是右子树
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {

    private Node prev;
    public Node flatten(Node head) {
        if(head == null) return null;
        // 处理previous， 因为要扁平化处理，相当于整个tree只有右子树，左子树为空
        // 连接prev和head
        if(prev != null){
            prev.next = head;
            head.prev = prev;
            prev.child = null;
        }
        //移动prev，先序遍历整个tree；
        prev = head;
        Node previousNext = head.next; // 保存原先的next，因为到下一步child的时候，next已经变更为child
        flatten(head.child); // 判断时候有child
        flatten(previousNext);
        return head;
    }
}



public class MainClass {
}
