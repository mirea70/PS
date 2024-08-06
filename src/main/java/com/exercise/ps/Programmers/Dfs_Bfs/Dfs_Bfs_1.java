package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

public class Dfs_Bfs_1 {
    public static void main(String[] args) {
        Dfs_Bfs_1_Solution d = new Dfs_Bfs_1_Solution();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println("d.solution(numbers, target) = " + d.solution(numbers, target));
    }
}
class Dfs_Bfs_1_Solution {
    int[] numbers;
    int target;
    int answer;

    // index는 순회 중인 numbers의 인덱스, sum은 순회 중 target과 비교할 합
    private void dfs(int index, int sum) {
        // 1. 탈출조건 : 인덱스가 numbers 길이와 같아지면
        if(index == numbers.length) {
            if(target == sum) answer++;
            return;
        }
        // 2. 작동방식
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        // numbers를 순회하며 각 수를 answer에 계속 더해본다.
        // 그 다음은 직전까지 순회했던 합에 -를 해본다.
        // target과 비교하여 일치하면 answer++
        // 반복 -> 재귀함수
        // numbers의 길이만큼 DFS 한번 돌면 끝
        dfs(0,0);

        return answer;
    }
}
