package com.ibairah.Hard.lc212WordSearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibairah on 6/30/20.
 *
 * Given a 2D board and a list of words from the dictionary, find
 * all words in the board.
 *
 * Each word must be constructed from letters of sequentially
 * adjacent cell, where "adjacent" cells are those horizontally or
 * vertically neighboring. The same letter cell may not be used
 * more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0) return res;

        TrieNode root = new TrieNode(' ');
        buildTrie(root,words);
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    dfs(board, i, j, root, res);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] board,int i, int j, TrieNode cur, List<String> res){
        if(i<0||j<0||i>=board.length||j>=board[0].length) return;

        char c = board[i][j];
        if(c == '*') return;
        if(cur.children[c-'a'] == null) return;

        cur = cur.children[c - 'a'];
        if(cur.word != null){
            res.add(cur.word);
            //当前string 重新变为null，为了防止重复出现
            cur.word = null;
        }

        board[i][j] = '*';
        dfs(board,i+1,j,cur,res);
        dfs(board,i-1,j,cur,res);
        dfs(board,i,j+1,cur,res);
        dfs(board,i,j-1,cur,res);
        board[i][j] = c;
    }
    private void buildTrie(TrieNode root, String[] words){
        for(String s: words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                //cur更新到下一个，类似cur = root.next
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
    }

}
class TrieNode{
    char val;
    TrieNode[] children;
    String word;
    public TrieNode(char x){
        children = new TrieNode[26];
        word = null;
    }
}

public class MainClass {
}
