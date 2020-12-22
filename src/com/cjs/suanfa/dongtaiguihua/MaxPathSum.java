package com.cjs.suanfa.dongtaiguihua;

/**
 *          7
 *
 *        3   8
 *
 *       8   1   0
 *
 *     2   7   4   4
 *
 *   4   5   2   6   5
 *
 *   在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。
 *   https://blog.csdn.net/baidu_28312631/article/details/47418773
 */
public class MaxPathSum {

    public static void main(String[] args) {
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int[] m = new int[5];
        int maxSum;
        for (int i = 4; i >= 0; i--) {
            for (int k = 0; k < i; k++) {
                m[k] = Math.max(m[k] + arr[i][k], m[k + 1] + arr[i][k]);
            }
        }
        maxSum = Math.max(m[0], m[1]) + arr[0][0];
        System.out.println(maxSum);
    }
}
