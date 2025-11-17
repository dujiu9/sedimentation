package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;
import java.text.DecimalFormat;

public class P5735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        // 计算三边距离
        double ab = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double bc = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double ca = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));

        double perimeter = ab + bc + ca;

        // 方法1：使用 DecimalFormat（推荐，避免 0.5 -> 0.50 丢失末尾0）
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(perimeter));

        sc.close();
    }
}
