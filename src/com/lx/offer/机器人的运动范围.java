package com.lx.offer;

/**
 * @author Werdio丶
 * @since 2021-02-09 10:09:23
 */
public class 机器人的运动范围 {
    int res = 1;
    boolean[][] map;
    public int movingCount(int m, int n, int k) {
        map = new boolean[m][n];

        dfs(0, m, 0, n, k);
        return res;
    }
    public void dfs(int i, int m, int j, int n, int k){
        if(i < 0 || i >= m || j < 0 || j >= n || map[i][j] || sum(i) + sum(j) > k){
            return;
        }
        res++;
        map[i][j] = true;
        dfs(i + 1, m, j, n, k);
        dfs(i, m, j + 1, n, k);
        dfs(i - 1, m, j, n, k);
        dfs(i, m, j - 1, n, k);
    }
    public int sum(int num){
        int ress = 0;
        while(num != 0){
            ress += num % 10;
            num /= 10;
        }
        return ress;
    }

    public static void main(String[] args) {
        机器人的运动范围 j = new 机器人的运动范围();
//        System.out.println(j.movingCount(2, 3, 1));
        System.out.println(j.sum(2));
    }
}
