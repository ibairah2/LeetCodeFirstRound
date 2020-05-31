package com.ibairah.Medium.lc17LetterCombinationOfaPhone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 5/28/20.
 * Given a string containing digits from 2-9 inclusive, return all
 * possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone
 * buttons) is given below. Note that 1 does not map to any letters.
 *
 *  1       2(abc)  3(def)
 *  4(ghi)  5(jkl)  6(mno)
 *  7(pqrs) 8(tuv)  9(wxyz)
 *  *(+)    0()     #(shift)
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your
 * answer could be in any order you want.
 */

//DFS 方法
class Solution {
    String[] keys = new String[] {"","","abc","def","ghi",
            "jkl","mno","pqrs","tuv","wxyz"}; // 初始化（0到9）对应keys

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(); // 结果
        StringBuilder sb = new StringBuilder(); // 单个结果

        if(digits.length() == 0) return res;
        dfs(digits, res,sb,0); // 从index为0，开头开始
        return res;
    }
    public void dfs(String digits,List<String> res,StringBuilder sb,int index){
        // exist
        if(index == digits.length()){  //到达最后一位
            res.add(sb.toString());   //满足条件，添加至结果
            return;         //结束当前if，返回原functionn；
        }

        // 拆解!!
        //keys作用类似dictionary，letters 就可以找出 2对应abc
        String letters = keys[digits.charAt(index)-'0'];
        System.out.println(" digits.charAt(index):"+ (digits.charAt(index)-'0'));
        System.out.println(" letters :"+ letters.toString());
        // letters :abc
        // letters :def
        // letters :def
        // letters :def
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            sb.append(c);
            dfs(digits, res,sb, index+1); // 指向下一个字母,类似for j
            sb.deleteCharAt(sb.length()-1); // 清空sb
        }
    }

}
public class MainClass {
    public static void main(String[] args) {

    }
}
