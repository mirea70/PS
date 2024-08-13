package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());
			SingleLinkList list = new SingleLinkList();
			String[] datas = br.readLine().split(" ");
			list.adds(datas);
			int command_len = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i< command_len; i++) {
				String command = st.nextToken();
				switch(command) {
				case "I": {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					String[] arr = new String[y];
					for(int k=0; k<y; k++) {
						arr[k] = st.nextToken();
					}
					list.inserts(x, arr);
				break;
				}
				case "D": {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					list.removes(x, y);
				}
				break;
				case "A": {
					int y = Integer.parseInt(st.nextToken());
					String[] arr = new String[y];
					for(int k=0; k<y; k++) {
						arr[k] = st.nextToken();
					}
					list.adds(arr);
				}
				break;
				
			}
		}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0; i<10; i++)
				sb.append(list.get(i)).append(" ");
			System.out.println(sb);
		}
	}
}

class Node {
	Node next;
	String data;
	
	public Node() {}
}

class SingleLinkList {
	Node head;
	int size;
	
	public SingleLinkList() {
		head = new Node();
	}
	
	String get(int i) {
		if(i < 0  || i >= size) {
			System.out.println("조회 가능한 범위가 아닙니다.");
		}
			
		Node curr = head;
		// i 이전 노드 찾기
		for(int k=0; k<i; k++) {
			curr = curr.next;
		}
		return curr.next.data;
	}
	
	void inserts(int x, String[] datas) {
		if(size >=1 && (x < 0 || x >= size)) {
//			System.out.println("size = " + size);
//			System.out.println("x = " + x);
//			System.out.println("삽입가능한 범위가 아닙니다.");
			return;
		}
		
		Node curr = head;
		// x 이전 노드 찾기
		for(int k=0; k<x; k++) {
			curr = curr.next;
		}
		// 마지막 데이터 노드
		Node lastData = curr.next;
		// 다음 노드와 연결 시키기 (size != 0)
//		if(size != 0)
//			lastData.next = curr.next;
		// Node들을 생성해서 모두 연결시키기
		for(int i=datas.length-1; i>=0; i--) {
			Node node = new Node();
			node.data = datas[i];
			node.next = lastData;
			lastData = node;
		}
		// 기존 이전 노드와 연결
//		if(size != 0)
		curr.next = lastData;
		
		size += datas.length;
	}
	
	void adds(String[] datas) {
		this.inserts(size, datas);
	}
	
	void removes(int x, int y) {
		if(x < 0 || x >= size || x+y >= size) {
			System.out.println("삭제할 범위가 아닙니다.");
		}
		Node curr = head;
		// x 이전 노드 찾기
		for(int k=0; k<x; k++) {
			curr = curr.next;
		}
		// x + y번째 노드 찾기
		// 2 3 4 5 6
		// x = 2
		// y = 3
		Node last = curr;
		for(int k=0; k<y; k++) {
			last = curr.next;
		}
		curr.next = last.next;
		size -= y;
	}
}
