package com.exercise.ps.Programmers.basic;

public class Basic107 {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        switch (ineq) {
            case "<" : {
                switch (eq) {
                    case "=" : {
                        return n <= m ? 1 : 0;
                    }
                    case "!" : {
                        return n < m ? 1 : 0;
                    }
                }
            }
            case ">" : {
                switch (eq) {
                    case "=" : {
                        return n >= m ? 1 : 0;
                    }
                    case "!" : {
                        return n > m ? 1 : 0;
                    }
                }
            }
        }

        return answer;
    }
}
