package com.ibairah.Medium.lc31NextPermutation;

import java.util.Arrays;

/**
 * Created by ibairah on 6/28/20.
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the
 * lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra
 * memory.
 *
 * Here are some examples. Inputs are in the left-hand column and
 * its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */


class Solution {
    public void nextPermutation(int[] nums) {
        //1.corner case
        if(nums == null || nums.length == 0) return;

        //2.从倒数第二位开始寻找,因为从倒数第二位和第一位比较
        int replace = nums.length - 2;

        while(replace >= 0){
            if(nums[replace] < nums[replace + 1 ]){
                break;
            }
            replace--;
        }

        //如果replace为负，说明没有前一位数小于后一位数,说明这个数组从大到小的排列
        if(replace < 0){
            Arrays.sort(nums);
            return;
        }

        //从要替换的数后一位找，找到一个刚好大于他的数
        int largeIdx = replace + 1;
        while(largeIdx < nums.length && nums[largeIdx] > nums[replace]){
            largeIdx++;
        }
        swap(nums, replace,largeIdx - 1);
        // 从被替换的数后面开始，从小到大排列
        Arrays.sort(nums,replace + 1, nums.length);

    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class MainClass {
}
