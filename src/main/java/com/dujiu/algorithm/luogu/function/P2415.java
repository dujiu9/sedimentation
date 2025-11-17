package com.dujiu.algorithm.luogu.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2415 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());

        }
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }

        System.out.println(sum * (1 << (list.size() - 1)));
        sc.close();
    }
}
