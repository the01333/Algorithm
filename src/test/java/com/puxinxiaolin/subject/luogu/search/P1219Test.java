package com.puxinxiaolin.subject.luogu.search;

import lombok.Builder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class P1219Test {
    @Test
    void testObjectSort() {
        List<Student> list = new ArrayList<>();
        list.add(Student.builder().name("Alice").age(20).cScore(80).mScore(95).eScore(90).build());
        list.add(Student.builder().name("Bob").age(18).cScore(85).mScore(90).eScore(95).build());
        list.add(Student.builder().name("Charlie").age(18).cScore(85).mScore(90).eScore(95).build());
        list.add(Student.builder().name("David").age(18).cScore(90).mScore(85).eScore(80).build());

//        list.sort((a, b) -> {
//
//        });
    }

    @Builder
    static class Student {
        String name;
        int age;
        int cScore;
        int mScore;
        int eScore;

        public Student(String name, int age, int cScore, int mScore, int eScore) {
            this.name = name;
            this.age = age;
            this.cScore = cScore;
            this.mScore = mScore;
            this.eScore = eScore;
        }
    }
}
