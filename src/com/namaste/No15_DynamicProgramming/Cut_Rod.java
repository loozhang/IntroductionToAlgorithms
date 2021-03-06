package com.namaste.No15_DynamicProgramming;

public class Cut_Rod {
    static int q;//最优价格临时变量
    static int[] p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};//不同长度对应的价格
    static int[] r = new int[p.length];//初始化不同长度对应的最优价格都为0

    public static void main(String[] args) {
        System.out.printf(getMaxValue(4) + "");
    }

    private static int getMaxValue(int length) {
        return memoized_aux(length, r, p);
    }

    private static int memoized_aux(int n, int[] r, int[] p) {

        if (r[n] > 0) {
            return r[n];
        }
        if (n == 0)
            return 0;
        else
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + memoized_aux(n - i, r, p));
            }
        r[n] = q;
        System.out.println(n + "---" + r[n]);
        return q;

    }
}
