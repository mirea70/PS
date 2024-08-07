package main.java.com.exercise.ps.swea;

import java.util.Scanner;

public class SWEA_1217 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int tc = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.printf("#%d %d%n", tc, multiple(n,m));
		}
	}

	private static int multiple(int n, int m) {
		if(m == 0) return 1;
		return n * multiple(n, m-1);
	}
}
