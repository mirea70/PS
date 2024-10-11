package com.exercise.ps.Programmers.basic;

public class Basic20 {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i=0; i<myString.length(); i++) {
            char c = Character.toLowerCase(myString.charAt(i));

            boolean isContain = false;
            for(int j=0; j<pat.length() && i+j<myString.length(); j++) {
                char cc = Character.toLowerCase(myString.charAt(i+j));
                if(cc != Character.toLowerCase(pat.charAt(j))) {
                    break;
                }

                if(j == pat.length()-1)
                    isContain = true;
            }

            if(isContain) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
