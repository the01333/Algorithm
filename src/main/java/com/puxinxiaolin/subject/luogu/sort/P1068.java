package com.puxinxiaolin.subject.luogu.sort;

import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable<Person> {
    int num;
    int score;

    public Person(int num, int score) {
        this.num = num;
        this.score = score;
    }

    @Override
    public int compareTo(Person o) {
        if (this.score != o.score) {
            return Integer.compare(o.score, this.score);
        }
        return Integer.compare(this.num, o.num);
    }
}

public class P1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int targetNum = (int) Math.floor(m * 1.5);

        Person[] p = new Person[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int score = sc.nextInt();
            p[i] = new Person(num, score);
        }
        sc.close();

        Arrays.sort(p);

        // dealing
        int passScore = p[targetNum - 1].score, count = 0;
        for (Person person : p) {
            if (person.score >= passScore) {
                count++;
            }
        }
        System.out.println(passScore + " " + count);

        for (Person person : p) {
            if (person.score >= passScore) {
                System.out.println(person.num + " " + person.score);
            }
        }
    }
}
