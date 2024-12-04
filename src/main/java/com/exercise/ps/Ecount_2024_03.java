package com.exercise.ps;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ecount_2024_03 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 검색 조건 입력
        String[] searchCondition = br.readLine().split(" ");
        String startTime = searchCondition[0];
        String endTime = searchCondition[1];
        String keyword = searchCondition.length > 2 ? searchCondition[2] : "";

        // 2. 로그 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 3. 로그 저장 및 처리
        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] logParts = br.readLine().split(" ", 3);
            Log log = new Log(logParts[0], logParts[1], logParts[2]);
            logs.add(log);
        }

        // 4. 로그 필터링
        List<Log> filteredLogs = filterLogs(logs, startTime, endTime, keyword);

        // 5. 로그 그룹화 및 압축
        Map<String, List<Log>> groupedLogs = groupAndCompressLogs(filteredLogs);

        // 6. 결과 출력
        printResults(groupedLogs);

        br.close();
    }

    static List<Log> filterLogs(List<Log> logs, String startTime, String endTime, String keyword) {
        List<Log> filteredLogs = new ArrayList<>();
        for (Log log : logs) {
            // 시간 범위 필터링
            boolean isTimeInRange = log.time.compareTo(startTime) >= 0 && log.time.compareTo(endTime) <= 0;

            // 키워드 필터링 (대소문자 무시, 부분 일치)
            boolean isKeywordMatched = keyword.isEmpty() ||
                    log.content.toLowerCase().contains(keyword.toLowerCase());

            if (isTimeInRange && isKeywordMatched) {
                filteredLogs.add(log);
            }
        }
        return filteredLogs;
    }

    static Map<String, List<Log>> groupAndCompressLogs(List<Log> logs) {
        Map<String, List<Log>> groupedLogs = new TreeMap<>(Comparator
                .comparing(k -> Arrays.asList("INFO", "WARN", "ERROR").indexOf(k)));

        for (int i = 0; i < logs.size(); i++) {
            Log currentLog = logs.get(i);
            int count = 1;

            // 연속된 중복 로그 압축
            while (i + 1 < logs.size() &&
                    isLogEqual(currentLog, logs.get(i + 1))) {
                count++;
                i++;
            }

            // 그룹화
            currentLog.count = count;
            groupedLogs.computeIfAbsent(currentLog.type, k -> new ArrayList<>()).add(currentLog);
        }

        return groupedLogs;
    }

    static boolean isLogEqual(Log log1, Log log2) {
        return log1.type.equals(log2.type) && log1.content.equals(log2.content);
    }

    static void printResults(Map<String, List<Log>> groupedLogs) {
        if (groupedLogs.isEmpty()) {
            System.out.println("No logs found.");
            return;
        }

        for (Map.Entry<String, List<Log>> entry : groupedLogs.entrySet()) {
            System.out.println("[" + entry.getKey() + "]:");
            for (Log log : entry.getValue()) {
                String countStr = log.count > 1 ? " (x" + log.count + ")" : "";
                System.out.println("- " + log.time + " " + log.content + countStr);
            }
            System.out.println();
        }
    }
}


class Log {
    String time;
    String type;
    String content;
    int count = 1;

    Log(String time, String type, String content) {
        this.time = time;
        this.type = type.substring(1, type.length() - 1);
        this.content = content;
    }
}