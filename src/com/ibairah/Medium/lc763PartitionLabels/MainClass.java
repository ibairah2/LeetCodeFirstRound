package com.ibairah.Medium.lc763PartitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/24/20.
 *
 * A string S of lowercase English letters is given. We want to
 * partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of
 * integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one
 * part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect,
 * because it splits S into less parts.
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */

class Solution {
    public List<Integer> partitionLabels(String S) {
        //1. corner case
        if(S == null || S.length() == 0) return null;

        //2. store each letter of their last time appeared
        int[] last_indices = new int[26];
        for(int i = 0; i < S.length(); i++){
            //!!!!! last_indices[ a - 'a']  = 0; last_indices[0], a这一位， 最后出现的位置更新到i
            last_indices[S.charAt(i) - 'a'] = i;
        }

        //3.update the maxLen and add to final res;
        List<Integer> res = new ArrayList<>();

        int start = 0;
        int end = 0; // also means mathLength
        for(int i = 0; i < S.length(); i++){
            // 更新当前最长长度,  [0,a(8)]
            end = Math.max(end,last_indices[S.charAt(i) - 'a']);
            //如果i走到end的位置，end没有更新，说明后面没有重复字母
            if( i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}

public class MainClass {

}
