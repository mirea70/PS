package com.exercise.ps.Baekjoon.basic;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

public class Q10699 {
    public static void main(String[] args) throws IOException {
        LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.print(localDate);
    }
}
