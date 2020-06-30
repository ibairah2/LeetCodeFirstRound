package com.ibairah.Easy.lc937ReorderDatainLogFile;

import java.util.Arrays;

/**
 * Created by ibairah on 6/28/20.
 *
 * You have an array of logs.  Each log is a space delimited string
 * of words.
 *
 * For each log, the first word in each log is an alphanumeric
 * identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase
 * letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and
 * digit-logs.  It is guaranteed that each log has at least one
 * word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any
 * digit-log.  The letter-logs are ordered lexicographically
 * ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2
 * own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1
 * 8 1 5 1","dig2 3 6"]
 *
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after
 * the identifier.
 */
/*
class SplitDemo {
     public static String[] ss = new String[20];
     public static String[] ss2 = new String[20];
     public SplitDemo() {
         String s = "The rain in Spain falls mainly in the plain.";
         // 在每个空格字符处进行分解。
         ss = s.split(" ", 2);
         ss2 = s.split(" ");
     }
     public static void main(String[] args) {
         SplitDemo demo = new SplitDemo();
         System.out.println("11:");
         for (int i = 0; i < ss.length; i++){
             System.out.println(ss[i]);
         }
         System.out.println("22:");
         for (int i = 0; i < ss2.length; i++){
             System.out.println(ss2[i]);
         }
     }
}
11:
The
rain in Spain falls mainly in the plain.
22:
The
rain
in
Spain
falls
mainly
in
the
plain.
[Finished in 0.6s]
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(s1,s2)->{
            //从第一个空格开始，把这一句分成两段
            String[] split1 = s1.split(" ",2);
            String[] split2 = s2.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if( !isDigit1 && !isDigit2){
                // both letter-logs.
                //如果都不是数字，比较谁的哪一个字母要小一点
                //其返回的是一个int类型值。若Str1等于参数字符串Str2字符串，
                // 则返回0；若该Str1按字典顺序小于参数字符串Str2，则返回值小于0；
                // 若Str1按字典顺序大于参数字符串Str2，则返回值大于0。
                // 0 - 等于, 1 - 小于， 2-大于
                //split1[1]是一段string
                int comp = split1[1].compareTo(split2[1]);
                //如果后面没有结果，则比较前面一段
                if(comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            }
            // both digit-logs. So keep them in original order
            else if (isDigit1 && isDigit2) return 0;
                // first is digit, second is letter. bring letter to forward.
            else if (isDigit1 && !isDigit2) return 1;
                //first is letter, second is digit. keep them in this order.
            else return -1;
        });
        return logs;
    }
}

public class MainClass {
    public static void main(String[] args) {
        String number = "";
    }
}


