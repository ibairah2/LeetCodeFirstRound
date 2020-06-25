package com.ibairah.Medium.lc96UniqueBinarySearchTree;

/**
 * Created by ibairah on 6/24/20.
 * Given n, how many structurally unique BST's (binary search
 * trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

//DP
//https://www.bilibili.com/video/BV1e5411W72t
class Solution {
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;

        //从左边第二位开始求
        for(int i = 2; i < n+1; i++){
            int temp = 0;
            //遍历以哪个数作为根，所以从0到i
            for( int j = 0; j < i; j++){
                //当确定j为根后，所有比根小的个数是j,比根大的个数是i-1-j
                temp += res[j] * res[i-1-j];
            }
            res[i] = temp;
        }
        return res[n];
    }
}
public class MainClass {
}
