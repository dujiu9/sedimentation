package com.dujiu.algorithm.luogu.string;

import java.util.Scanner;

public class P5734 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 操作次数
        int q = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        for (int i = 0; i < q; i++) {
            String line = sc.nextLine();
            String[] split = line.split("\\s+");
            int type = Integer.parseInt(split[0]);

            switch (type) {
                case 1:
                    String x = split[1];
                    System.out.println(str + x);
                    break;
                case 2:
                    int l = Integer.parseInt(split[1]);
                    int r = Integer.parseInt(split[2]);
                    if (l + r > str.length()) {
                        System.out.println(str.substring(l));
                    }else {
                        System.out.println(str.substring(l, l + r));
                    }
                    break;
                case 3:
                    int pos = Integer.parseInt(split[1]);
                    String s = split[2];
                    String res3 = str.substring(0, pos) + s + str.substring(pos);
                    System.out.println(res3);
                    break;
                case 4:
                    String x4 = split[1];
                    System.out.println(str.indexOf(x4));
                    break;
            }
        }
        sc.close();
    }
}
