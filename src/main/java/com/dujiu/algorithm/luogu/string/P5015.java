package com.dujiu.algorithm.luogu.string;

import java.util.Scanner;

public class P5015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str.replaceAll("\\s+","").length());
        sc.close();
    }
}
