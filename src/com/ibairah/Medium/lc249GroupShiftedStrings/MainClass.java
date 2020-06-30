package com.ibairah.Medium.lc249GroupShiftedStrings;
import java.util.*;

/**
 * Created by ibairah on 6/29/20.
 *
 * Given a string, we can "shift" each of its letter to its
 * successive letter, for example: "abc" -> "bcd". We can keep
 * "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of non-empty strings which contains only lowercase
 * alphabets, group all strings that belong to the same shifting
 * sequence.
 *
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 */

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            System.out.println("offset: "+ offset);
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                System.out.println("str.charAt(i) : "+ str.charAt(i));
                char c = (char) (str.charAt(i) - offset);
                System.out.println("c: "+ c);
                // za 情况不在里面, 如果前面数大于后面的数，后面的数-前面 = 负数，所以+26补正
                if (c < 'a') {
                    c += 26;
                }
                key += c;
                System.out.println("key: "+ key);

            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            // key现在只有 abc, az, acef, a -> value是其他值
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}

public class MainClass {
}
