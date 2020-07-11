package com.ibairah.Easy.lc292NimGame;

/**
 * Created by ibairah on 2020/7/10.
 *
 * You are playing the following Nim Game with your friend: There
 * is a heap of stones on the table, each time one of you take
 * turns to remove 1 to 3 stones. The one who removes the last
 * stone will be the winner. You will take the first turn to remove
 * the stones.
 *
 * Both of you are very clever and have optimal strategies for the
 * game. Write a function to determine whether you can win the game
 * given the number of stones in the heap.
 *
 * Example:
 *
 * Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will
 * never win the game;
 *              No matter 1, 2, or 3 stones you remove, the last
 * stone will always be
 *              removed by your friend.
 *
 */

//如果堆中石头的数量 nn 不能被 44 整除，那么你总是可以赢得 Nim 游戏的胜利。
//
//推理
//
//让我们考虑一些小例子。显而易见的是，如果石头堆中只有一块、两块、或是三块石头，
// 那么在你的回合，你就可以把全部石子拿走，从而在游戏中取胜。而如果就像题目描述
// 那样，堆中恰好有四块石头，你就会失败。因为在这种情况下不管你取走多少石头，
// 总会为你的对手留下几块，使得他可以在游戏中打败你。因此，要想获胜，在你的回合
// 中，必须避免石头堆中的石子数为 4 的情况。
//
//同样地，如果有五块、六块、或是七块石头，你可以控制自己拿取的石头数，总是恰好
// 给你的对手留下四块石头，使他输掉这场比赛。但是如果石头堆里有八块石头，你就不
// 可避免地会输掉，因为不管你从一堆石头中挑出一块、两块还是三块，你的对手都可以
// 选择三块、两块或一块，以确保在再一次轮到你的时候，你会面对四块石头。
//
//显然，它以相同的模式不断重复 n=4,8,12,16,\dotsn=4,8,12,16,…，
// 基本可以看出是 44 的倍数。

class Solution {
    public boolean canWinNim(int n) {
        if( n % 4 != 0) return false;
        return true;
    }
}
public class MainClass {
}
