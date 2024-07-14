package 백준_15681_트리와쿼리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int[] result = new int[N+1];

        boolean[] isVisited = new boolean[N+1];

        search(graph, R, isVisited, result);

        for(int i = 0; i < Q; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(result[num]).append("\n");
        }

        System.out.println(sb);
    }

    static int search(List<List<Integer>> graph, int current, boolean[] isVisited, int[] result){
        int size = graph.get(current).size();

        isVisited[current] = true;
        int cnt = 1;

        for(int i = 0; i < size; i++){
            if(isVisited[graph.get(current).get(i)]){
                continue;
            }
            cnt += search(graph, graph.get(current).get(i), isVisited, result);

        }
        result[current] = cnt;
        return cnt;
    }
}
