package com.ibairah.Medium.lc275HindexII;

/**
 * Created by ibairah on 6/18/20.
 * Given an array of citations sorted in ascending order (each
 * citation is a non-negative integer) of a researcher, write a
 * function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A
 * scientist has index h if h of his/her N papers have at least h
 * citations each, and the other N − h papers have no more than h
 * citations each."
 *
 * Example:
 *
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in
 * total and each of them had
 *              received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3
 *              citations each and the remaining
 *              two with no more than 3 citations each, her h-index
 *              is 3.
 * Note:
 *
 * If there are several possible values for h, the maximum one is
 * taken as the h-index.
 *
 * Follow up:
 *
 * This is a follow up problem to H-Index, where citations is now
 * guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 */



//https://www.bilibili.com/video/BV1o54y1B7XL
// H-index 在这个数组中有h个数是大于等于h的 --》数组长度（n-h）剩下的数是小于h的
// 因为要找最大的h， n-h位置的值为最大， n-h到n-1包含了h个数，并且最大
// c[n-h -> n-1] >= h && c[0 -> n-h1] <= h

//https://www.bilibili.com/video/BV1o54y1B7XL
// H-index 在这个数组中有h个数是大于等于h的 --》数组长度（n-h）剩下的数是小于h的
// 因为要找最大的h， n-h位置的值为最大， n-h到n-1包含了h个数，并且最大
// c[n-h -> n-1] >= h && c[0 -> n-h1] <= h

class Solution {
    public int hIndex(int[] citations) {
        int start = 0 ;
        int end = citations.length-1;
        int n = citations.length;
        if( n == 0) return 0;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            int h = n - mid;

            if(citations[mid] > h ){
                end = mid;
            }else{
                start = mid;
            }
        }


        //返回 start， end两个值
        if(citations[start] >= n - start){
            return n-start;  // 当面对最小的start 也能大于h则说明可以直接返回
        }
        if(citations[end] < n - end ){
            return 0;       // 当面对最大的end 也能小于h则说明没有满足的数
        }
        return n - end; //当他不是start， 但是他又和h相等，说这个数是end
    }
}
public class MainClass {
}
