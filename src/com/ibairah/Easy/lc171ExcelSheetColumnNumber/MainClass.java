package com.ibairah.Easy.lc171ExcelSheetColumnNumber;

/**
 * Created by ibairah on 6/12/20.
 * Given a column title as appear in an Excel sheet, return its
 * corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */

class Solution {
    public int titleToNumber(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for( int i = 0 ; i < arr.length ; i++ ){
            System.out.println("res start :"+ res);
            System.out.println(" (arr[i] - 'A' + 1);  :"+
                    (arr[i] - 'A' + 1));
            //update每次当前位置需要乘的数
            res = res * 26 + (arr[i] - 'A' + 1);
            System.out.println("res after  :"+ res);
        }
        return res;
    }
}

public class MainClass {
    public static void main(String[] args) {
        String s = "CBB";
        Solution solution = new Solution();
        solution.titleToNumber(s);
    }
}
