package com.ibairah.Easy.lc350IntersectionOfTwoArraysII;

import java.util.*;

/**
 * Created by ibairah on 6/23/20.
 */


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key: nums2){
            if(map.containsKey(key)){
                temp.add(key);
                map.put(key, map.get(key) - 1);
                map.remove(key,0);
            }
        }

        //System.out.println("temp  :"+ temp);
        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }
        //System.out.println("res :"+ Arrays.toString(res));
        return res;
    }
}
public class MainClass {
}
