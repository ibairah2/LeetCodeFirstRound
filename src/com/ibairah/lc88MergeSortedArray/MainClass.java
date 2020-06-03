package com.ibairah.lc88MergeSortedArray;

import java.util.Arrays;

/**
 * Created by ibairah on 6/2/20.
 * Given two sorted integer arrays nums1 and nums2, merge nums2
 * into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and
 * n respectively.
 * You may assume that nums1 has enough space (size that is greater
 * or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j= n-1, k = m+n-1; // k代表nums1最后一位
        while(i >=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j>=0){ // 如果nums1已经排列完毕，则单独计算idx2
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        System.out.println(" nums1 :"+ Arrays.toString(nums1));
    }

    //自己方法
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] newNumber = new int[nums1.length];

        int pointer1 = 0;
        int pointer2 = 0;

        int n_pointer =0;

        while(pointer1 != nums1.length && pointer2!= nums2.length){
            //System.out.println("n  :"+ n_pointer);
            //System.out.println("pointer1  :"+ nums1[pointer1] );
            //System.out.println("pointer2  :"+ nums2[pointer2] );
            if(nums1[pointer1] <= nums2[pointer2] && nums1[pointer1] != 0){
                newNumber[n_pointer] = nums1[pointer1];
                n_pointer++;
                pointer1++;
            }else{
               // System.out.println(" in else :" );
                newNumber[n_pointer] = nums2[pointer2];
                n_pointer++;
                pointer2++;
            }
           // System.out.println(" newNumber in loop:"+ Arrays.toString(newNumber));
           // System.out.println("---------Divided Line-----------" );

        }
        nums1 = newNumber.clone();
        System.out.println(" nums1 :"+ Arrays.toString(nums1));
    }
}


public class MainClass {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0}, nums2= {2,5,6};
        int m = 3, n = 3;
        Solution solution = new Solution();
        solution.merge(nums1, m,nums2,n);
    }
}
