package com.ibairah.Medium.lc127WordLadder;

import java.util.*;

/**
 * Created by ibairah on 2020/7/14.
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> setWord = new HashSet<>(wordList);
        //1.corner case
        if(setWord.size() == 0 || !setWord.contains(endWord)) return 0;

        // !!!!!!!!!!!!
        setWord.remove(beginWord);

        //2.initialize
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            //遍历每一个在q的单词
            for(int i = 0; i < size; i++){
                String curWord = q.poll();
                char[] curChar = curWord.toCharArray();
                //当前词的长度
                for(int j = 0; j < beginWord.length(); j++){
                    //
                    char originChar = curChar[j];
                    //从a到z的变换
                    for(char k = 'a'; k <= 'z'; k++){
                        // 如果当前字母一样跳过
                        if( k == originChar) continue;
                        // 变换当前字母
                        curChar[j] = k;
                        String nextWord = String.valueOf(curChar);


                        //判断当前单词时候存在, 同时它等于最后的结果时，返回
                        if(nextWord.equals(endWord)){
                            return step + 1;
                        }

                        if(setWord.contains(nextWord)) {
                                q.add(nextWord);
                                setWord.remove(nextWord);
                        }
                    }
                    //恢复原来的字母
                    curChar[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }
}

public class MainClass {

}


class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();
        for (String word :wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int level = 1;


        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                char[] word_chars = curr.toCharArray();
                for(int j = 0; j < word_chars.length;j++){
                    char ori = word_chars[j];
                    for (char c ='a';c<'z';c++){
                        if(word_chars[j]==c) continue;
                        word_chars[j]=c;
                        String new_word = String.valueOf(word_chars);
                        if(new_word.equals(endWord)) return level+1;
                        if(set.contains(new_word)){
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }

                    word_chars[j] = ori;
                }

            }



            level++;
        }

        return 0;

    }
}
