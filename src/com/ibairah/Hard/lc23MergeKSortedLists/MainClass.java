package com.ibairah.Hard.lc23MergeKSortedLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/29/20.
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
            while(lists[i].next != null){
                list.add(lists[i].val);
            }
        }
        System.out.println(" list :"+ list.toString());
        return null;
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
