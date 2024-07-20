package 백준_2252_줄세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            indegree[e]++;
            graph.get(s).add(e);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");

            int size = graph.get(now).size();
            for(int i = 0; i < size; i++){
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.add(graph.get(now).get(i));
                }
            }
        }

        System.out.println(sb);
    }
}
