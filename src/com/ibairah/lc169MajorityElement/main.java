package com.ibairah.lc169MajorityElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ibairah on 5/24/20.
 * Given an array of size n, find the majority element. The
 * majority element is the element that appears more than ⌊ n/2 ⌋
 * times.
 *
 * You may assume that the array is non-empty and the majority
 * element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */


class Solution {
    // Moore's voting 算法
    // 2 3 4 4 3 3 3 3

    //假设第一个值为Majority， 设置一个counter
    // ！一旦下一个数与Majority不一样时候，counter-1，如果一样则counter+1
    // ！一旦coutner被减为0，设置当数为majority，同时counter为1
    public int majorityElement(int[] nums) {
        int major = nums[0], counter = 1;
        for (int i = 1; i <nums.length ; i++) { // i从1开始因为已经设置了major
                if(counter == 0 ){
                    counter++;   // 更新counter；
                    major = nums[i];    //更新major如果counter为0
                }
                else if(major != nums[i]){
                    counter--;
                }
                else{
                    counter++;
                }
        }
        return major;
    }


    //HashMap为基础做法
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num)+1);
            }
            if(map.get(num) > nums.length/2){
                return num;
            }
        }
        return 0;
    }




    //直接先sort，然后返回在一半那个位置上的数，因为无论nums为奇数还是偶数，
    //n/2位置上的数必然是正确的也是题目也明确是这个数必须超过一半
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    /*
    For each example, the line below the array denotes the range of
    indices that are covered by a majority element that happens
    to be the array minimum. As you might expect, the line above the
    array is similar, but for the case where the majority element is
    also the array maximum. In all other cases, this line will lie
    somewhere between these two, but notice that even in these two
    most extreme cases, they overlap at index n/2 for both even- and
    odd-length arrays. Therefore, no matter what value the majority
    element has in relation to the rest of the array, returning
    the value at n/2 will never be wrong.
     */
}

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().majorityElement(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
}
