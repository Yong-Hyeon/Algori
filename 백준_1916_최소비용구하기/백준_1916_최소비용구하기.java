package 백준_1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1916_최소비용구하기 {
	static class Node implements Comparable<Node>{
		int no;
		int cost;

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		public Node(int no, int cost){
			this.no = no;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<List<Node>> matrix = new ArrayList<>();
		for(int i = 0; i <= N; i++){
			matrix.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			matrix.get(from).add(new Node(to, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] D = new int[N+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] isVisited = new boolean[N+1];

		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		D[start] = 0;
		pQueue.add(new Node(start, D[start]));

		while (!pQueue.isEmpty()){
			Node current = pQueue.poll();
			if(isVisited[end]){
				break;
			}
			if(isVisited[current.no]){
				continue;
			}
			isVisited[current.no] = true;

			for(int i = 0; i < matrix.get(current.no).size(); i++){
				if(isVisited[matrix.get(current.no).get(i).no]){
					continue;
				}
				if(D[matrix.get(current.no).get(i).no] > D[current.no] + matrix.get(current.no).get(i).cost){
					D[matrix.get(current.no).get(i).no] = D[current.no] + matrix.get(current.no).get(i).cost;
					pQueue.add(new Node(matrix.get(current.no).get(i).no, D[matrix.get(current.no).get(i).no]));
				}
			}
		}

		System.out.println(D[end]);
	}

}
