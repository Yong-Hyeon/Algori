package 백준_2623_음악프로그램;

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
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            for(int j = 1; j < n; j++){
                int e = Integer.parseInt(st.nextToken());
                indegree[e]++;
                graph.get(s).add(e);
                s = e;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        int[] result = new int[N];
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                queue.add(i);
                result[cnt++] = i;
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();

            int size = graph.get(now).size();
            for(int i = 0; i < size; i++){
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.add(graph.get(now).get(i));
                    result[cnt++] = graph.get(now).get(i);
                }
            }
        }

        if(cnt == N){
            for(int i = 0; i < N; i++){
                sb.append(result[i]).append("\n");
            }
        }else{
            sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
