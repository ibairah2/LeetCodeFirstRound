package com.ibairah.Easy.lc14LongestCommonPrefix;


/**
 * Created by ibairah on 5/30/20.
 *
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */

//class indexOf {
//    public static void main(String args[]) {
//        String string = "aaa456ac";
//        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
//        System.out.println(string.indexOf("b")); // indexOf(String str); 返回结果：-1，"b"不存在
//
//        // 从第四个字符位置开始往后继续查找，包含当前位置
//        System.out.println(string.indexOf("a",3));//indexOf(String str, int fromIndex); 返回结果：6
//
//        //（与之前的差别：上面的参数是 String 类型，下面的参数是 int 类型）参考数据：a-97,b-98,c-99
//
//        // 从头开始查找是否存在指定的字符
//        System.out.println(string.indexOf(99));//indexOf(int ch)；返回结果：7
//        System.out.println(string.indexOf('c'));//indexOf(int ch)；返回结果：7
//
//        //从fromIndex查找ch，这个是字符型变量，不是字符串。字符a对应的数字就是97。
//        System.out.println(string.indexOf(97,3));//indexOf(int ch, int fromIndex); 返回结果：6
//        System.out.println(string.indexOf('a',3));//indexOf(int ch, int fromIndex); 返回结果：6
//    }
//}

class Solution {
    // 最长公共前缀
    //方法2 ， 设置第一个string为prefix，然后和下一个每一个对比
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0]; //设置第一个string为prefix

        for(int i=1; i< strs.length;i++){
            //看上放IndexOf用法，如果indexof等于0，说明完全一致
            while(strs[i].indexOf(prefix) != 0){  //注意是strs[i]不是strs
                // prefix每一次不断减少最后一个字母
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }


    //Brute Force, 每一个string，一个一个字母loop
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = "";
        for(int i = 0; i< strs[0].length();i++){ //遍历第一个字符串每个字母
            char c = strs[0].charAt(i); // 第一个字符串按顺序给出 字母
            //遍历所有字符串
            for (int j = 1; j <strs.length ; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }
}
class Solution14{
// 最长公共前缀
//方法2 ， 设置第一个string为prefix，然后和下一个每一个对比
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
        while(strs[i].indexOf(prefix) != 0){
         prefix = prefix.substring(0,prefix.length()-1);
       }
    }
        return prefix;
    }


    public String longestCommonPrefixBruteForce(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        String res = "";

        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(i > strs[j].length() || c != strs[j].charAt(i)){
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }
}
public class MainClass {
    public static void main(String[] args) {
        String[] st = {"aa","a"};
        Solution solution = new Solution();
        solution.longestCommonPrefix2(st);
    }

}
