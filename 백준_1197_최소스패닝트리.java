import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1197_최소스패닝트리 {
	static class Node{
		int no;
		int cost;

		public Node(int no, int cost){
			this.no = no;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<List<Node>> matrix = new ArrayList<>();
		for(int i = 0; i <= V; i++){
			matrix.add(new ArrayList<>());
		}

		for(int i = 0; i < E; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			matrix.get(from).add(new Node(to, cost));
			matrix.get(to).add(new Node(from, cost));
		}

		int[] minV = new int[V+1];
		Arrays.fill(minV, Integer.MAX_VALUE);
		boolean[] isVisited = new boolean[V+1];

		int result = 0;
		minV[1] = 0;

		for(int v = 0; v < V; v++){
			int min = Integer.MAX_VALUE;
			int minNo = 0;

			for(int i = 1; i <= V; i++){
				if(!isVisited[i] && min > minV[i]){
					min = minV[i];
					minNo = i;
				}
			}

			isVisited[minNo] = true;
			result += min;

			for(int i = 0; i < matrix.get(minNo).size(); i++){
				if(isVisited[matrix.get(minNo).get(i).no]){
					continue;
				}
				if(minV[matrix.get(minNo).get(i).no] > matrix.get(minNo).get(i).cost){
					minV[matrix.get(minNo).get(i).no] = matrix.get(minNo).get(i).cost;
				}
			}
		}

		System.out.println(result);
	}

}
