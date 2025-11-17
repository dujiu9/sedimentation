package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5742 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int sno = sc.nextInt();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();

            Pair pair = new Pair(sno, score1, score2);

            if (pair.isExcellent()) {
                System.out.println("Excellent");
            } else {
                System.out.println("Not excellent");
            }
        }
    }
}

class Pair {
    int sno;
    int score1;
    int score2;

    public Pair(int sno, int score1, int score2) {
        this.sno = sno;
        this.score1 = score1;
        this.score2 = score2;
    }

    public boolean isExcellent() {
        int totalScore = score1 + score2;
        int weightedScore = 7 * score1 + 3 * score2;
        return totalScore > 140 && weightedScore >= 800;
    }
}