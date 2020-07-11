package com.ibairah.Medium.lc825FriendsOfAppropriateAges;

import java.util.HashMap;

/**
 * Created by ibairah on 2020/7/11.
 *
 * Some people will make friend requests. The list of their ages is
 * given and ages[i] is the age of the ith person. 
 *
 * Person A will NOT friend request person B (B != A) if any of the
 * following conditions are true:
 *
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 *
 * Note that if A requests B, B does not necessarily request A. 
 * Also, people will not friend request themselves.
 *
 * How many total friend requests are made?
 *
 * Example 1:
 *
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 *
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 *
 * Input: [20,30,100,110,120]
 * Output: 3
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110,
 * 120 -> 100.
 *  
 *
 * Notes:
 *
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 *
 */

class Solution {
    public int numFriendRequests(int[] ages) {
        if(ages == null || ages.length == 0) return 0;
        int res  = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int age: ages){
            map.put(age,map.getOrDefault(age,0) + 1);
        }

        for(int a : map.keySet()){
            for(int b: map.keySet()){
                if(isValid(a,b)){
                    res += map.get(a) * map.get(b);
                    if(a == b){
                        res -= map.get(a);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(int a, int b){
        if(b <= 0.5 * a + 7) return false;
        if(b > a) return false;
        if(b > 100 && a < 100) return false;

        return true;
    }
}
public class MainClass {
}
