package com.ibairah.lc283MoveZeroes;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * Created by ibairah on 5/17/20.
 *Given an array nums, write a function to move all 0's to
 *  the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {0,1,0,3,12};
        int[] nums2 = {0,1};
        sl.moveZeroes2(nums);
        System.out.println("  :"+ Arrays.toString(nums));
        sl.moveZeroes2(nums2);
        System.out.println("  :"+ Arrays.toString(nums2));
    }
}

class Solution {
    public void moveZeroes2(int[] nums) {
        int j = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {

                int temp = nums[j];  // temp保存原本数组当前数
                System.out.println(" temp:"+ temp);
                System.out.println(" nums[j] before :"+ nums[j]);
                nums[j] = nums[i];  // 原本数字当前数 = 按顺序不为0的数
                System.out.println(" nums[j] after:"+ nums[j]);
                System.out.println(" nums[i] before :"+ nums[i]);
                nums[i] = temp;     // 当前不为0的数 变为0
                System.out.println(" nums[i] after:"+ nums[i]);
                j++;
                System.out.println(" loop round :"+ Arrays.toString(nums));
            }
        }
    }

    //自己的笨办法
    public void moveZeroes(int[] nums) {
        int len_ = nums.length;
        int new_order = 0;
        int zero_coutner = 0;

        // 当不是0的时候，按顺序往前移动
        for (int i = 0; i < len_; i++) {
            if(nums[i] != 0){
                nums[new_order] = nums[i];
                new_order ++;
            }
            else {
                zero_coutner++;
            }
        }
        System.out.println("  :"+ zero_coutner);
        System.out.println("len_  :"+ len_);

        // 给后面补0
        while (zero_coutner != 0){
            nums[len_-1] = 0;
            zero_coutner--;
            len_--;
        }
    }

}