package com.lx.offer;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-01 12:52:16
 */
public class 顺时针打印矩阵 {

    public static int[] spiralOrder(int[][] matrix) {
        int left = 0, top = 0, right = matrix[0].length - 1, buttom = matrix.length - 1;
        int[] res = new int[(right + 1) * (buttom + 1)];
        int index = 0;
        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i++){
                res[index++] = matrix[top][i];
            }
            if(++top > buttom){
                break;
            }
            for(int i = top; i <= buttom; i++){
                res[index++] = matrix[i][right];
            }
            if(--right < left){
                break;
            }
            for(int i = right; i >= left; i--){
                res[index++] = matrix[buttom][i];
            }
            if(--buttom < top){
                break;
            }
            for(int i = buttom; i >= top; i--){
                res[index++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(spiralOrder(arr)));
    }
}
