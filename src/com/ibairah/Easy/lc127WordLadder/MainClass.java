package com.ibairah.Easy.lc127WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ibairah on 6/15/20.
 * Given two words (beginWord and endWord), and a dictionary's word
 * list, find the length of shortest transformation sequence from
 * beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not
 * the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" ->
 * "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no
 * possible transformation.
 */

//https://www.youtube.com/watch?v=hB_nYXFtwP0

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();

        //add word to HashSet
        for (String word : wordList) {
            set.add(word);
        }
        //corner case
        if (!set.contains(endWord)) {
            return 0;
        }

        //BFS initial
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int level = 1; //  which also means steps needed;

        while (!queue.isEmpty()) {
            // check queue size every time;
            // because every loop, queue will be updated, like: hit -->
            // hot,hat
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current_word = queue.poll();
                // for modifying current word, we need to transfer to
                // char;
                char[] word_toChar = current_word.toCharArray();
                for (int j = 0; j < word_toChar.length; j++) {
                    //保存当前的字母，比如说，hit中的h字母，下一次需要变i的时候，h字母需要还原回去
                    char temp = word_toChar[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if(word_toChar[j] == c) continue;
                        word_toChar[j] = c;
                        String new_word = new String(word_toChar);
                        if (new_word.equals(endWord)) return level + 1;
                        if (set.contains(new_word)) {
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }

                    word_toChar[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}

public class MainClass {
    public static void main(String[] args) {

    }
}
