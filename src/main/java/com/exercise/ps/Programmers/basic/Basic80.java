package com.exercise.ps.Programmers.basic;

public class Basic80 {
    public int solution(int[] date1, int[] date2) {
        int year1 = date1[0];
        int month1 = date1[1];
        int day1 = date1[2];

        int year2 = date2[0];
        int month2 = date2[1];
        int day2 = date2[2];

        if(year1 < year2)
            return 1;
        else if(year1 == year2 && month1 < month2)
            return 1;
        else if(year1 == year2 && month1 == month2 && day1 < day2)
            return 1;
        else
            return 0;
    }
}
