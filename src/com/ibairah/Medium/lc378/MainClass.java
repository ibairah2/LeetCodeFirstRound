package com.ibairah.Medium.lc378;

/**
 * Created by ibairah on 6/21/20.
 *
 * Given a n x n matrix where each of the rows and columns are
 * sorted in ascending order, find the kth smallest element in the
 * matrix.
 *
 * Note that it is the kth smallest element in the sorted order,
 * not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */

class Solution {
    //The following solution inspired by solution 2 might be a bit
    // more verbose, but I found it consistent with my basic binary
    // search template and easier to understand. This might not be a
    // perfect solution, but this could help u to understand the idea
    // behind the ingenious solution provided by the original Author.
    public int kthSmallest(int[][] matrix, int k) {
        // num of rows and cols in matrix
        int rows = matrix.length, cols = matrix[0].length;
        // get the lowest and highest possible num, will shrink search space according to the two nums
        // [lo, hi] is our initial search range
        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  maxNum = lo;
            // for each row, we r going to find # of nums < mid in that row
            for (int r = 0, c = cols - 1; r < rows; r++) {
                // this row's c has to be smaller than the c found in
                // last row due to the sorted property of the matrix
                while (c >= 0 && matrix[r][c] > mid) c--;
                if (c >= 0) {
                    // count of nums <= mid in matrix
                    count += (c + 1);
                    // mid might be value not in matrix, we need to
                    // record the actually max num;
                    maxNum = Math.max(maxNum, matrix[r][c]);
                }
            }
            // adjust search range
            if (count == k) return maxNum;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        // 1) Q: Why we return lo at the end:
        //    A: Here lo=hi+1, for hi, we found <k elems, for lo,
        //    we found >=k elem, lo must have duplicates in matrix, return lo
        // 2) Q: Why lo exist in the matrix
        //    A: for lo which is only 1 more than hi, we could find
        //    some extra nums in matrix so that there are >=k elems,
        //    so lo it self must exist in the matrix to meet the requirement.
        //    please check the illustration at the beginning of the post
        return lo;
    }
}

class Solution2 {
    public static int findKthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            // first number is the smallest and the second number is the largest
            int[] smallLargePair = { matrix[0][0], matrix[n - 1][n - 1] };

            int count = countLessEqual(matrix, mid, smallLargePair);

            if (count == k)
                return smallLargePair[0];

            if (count < k)
                start = smallLargePair[1]; // search higher
            else
                end = smallLargePair[0]; // search lower
        }

        return start;
    }

    private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid, let's keep track of the
                // smallest number greater than the mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                // as matrix[row][col] is less than or equal to the mid, let's keep track of the
                // biggest number less than or equal to the mid
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}

public class MainClass {
}
