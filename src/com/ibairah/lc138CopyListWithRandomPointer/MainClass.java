package com.ibairah.lc138CopyListWithRandomPointer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ibairah on 6/16/20.
 * A linked list is given such that each node contains an
 * additional random pointer which could point to any node in the
 * list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of
 * n nodes. Each node is represented as a pair of [val,
 * random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where
 * random pointer points to, or null if it does not point to any node.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 *
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 *
 *
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * Example 4:
 *
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so
 * return null.
 *
 *
 * Constraints:
 *
 * -10000 <= Node.val <= 10000
 * Node.random is null or pointing to a node in the linked list.
 * Number of Nodes will not exceed 1000.
 */

//https://www.youtube.com/watch?v=oXABtaRa37U

// T:O(n) S:O(n)

class Solution {
    public Node copyRandomList(Node head) {
        // 1. corner case
        if(head == null || head.next == null) return head;
        Map<Node,Node> map = new HashMap<>();

        //2. loop 1 only copy the nodes
        //只深度复制他的值，其中的next和random指向null
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val,null,null));
            cur = cur.next;
        }

        // loop 2. assign next and random;
        // 通过map去获取 原Node的next和random，再复制到当前Node中
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }


    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Object o, Object o1) {
        }
    }
}


public class MainClass {
}
