package com.exercise.ps.Programmers.basic;

public class Basic90 {
    public String solution(String my_string, int s, int e) {
        String head = my_string.substring(0, s);
        String tail = my_string.substring(e+1);
        String src = my_string.substring(s, e+1);

        StringBuilder reverseExecuter = new StringBuilder(src);
        reverseExecuter.reverse();
        reverseExecuter.insert(0, head);
        reverseExecuter.insert(reverseExecuter.length(), tail);

        return reverseExecuter.toString();
    }
}
