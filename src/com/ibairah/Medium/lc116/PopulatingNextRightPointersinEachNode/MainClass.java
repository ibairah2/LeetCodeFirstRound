package com.ibairah.Medium.lc116.PopulatingNextRightPointersinEachNode;

import org.w3c.dom.Node;

/**
 * Created by ibairah on 6/10/20.
 */

//class Solution {
//    public Node connect(Node root) {
//      // exit;
//      if(root == null) return null;
//
//      //decision
//      if(root.left != null ){
//        root.left.next = root.right;
//      }
//      //当前点右边不为空， 已经右子树不为空!!
//      if(root.right !=null && root.next != null) {
//         root.right.next = root.next.left;
//      }
//
//      connect(root.left);
//      connect(root.right);
//      return root;
//    }
//}

//https://www.youtube.com/watch?v=dPCrKhwswEk
class Solution {
    public Node connect(Node root) {
        return null;
    }
}
public class MainClass {
}
