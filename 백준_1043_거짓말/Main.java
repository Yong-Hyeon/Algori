package 백준_1043_거짓말;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] isKnow = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for(int i = 0; i < cnt; i++){
            int num = Integer.parseInt(st.nextToken());
            isKnow[num] = true;
        }

        int[][] graph = new int[N+1][N+1];
        List<List<Integer>> parties = new ArrayList<>();
        for(int p = 0; p < M; p++){
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            int[] input = new int[cnt];
            parties.add(new ArrayList<>());
            for(int i = 0; i < cnt; i++){
                int num = Integer.parseInt(st.nextToken());
                input[i] = num;
                parties.get(p).add(num);
            }
            combi(graph, input, cnt, 0, 0, new int[2]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(isKnow[i]){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 1; i <= N; i++){
                if(!isKnow[i] && graph[now][i] == 1){
                    isKnow[i] = true;
                    queue.add(i);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < M; i++){
            int size = parties.get(i).size();
            boolean isEnd = false;
            for(int j = 0; j < size; j++){
                if(isKnow[parties.get(i).get(j)]){
                    isEnd = true;
                    break;
                }
            }
            if(isEnd){
                continue;
            }
            result++;
        }

        System.out.println(result);
    }

    private static void combi(int[][] graph, int[] input, int N, int start, int cnt, int[] selected) {
        if(cnt == 2){
            graph[input[selected[0]]][input[selected[1]]] = 1;
            graph[input[selected[1]]][input[selected[0]]] = 1;
            return;
        }

        for(int i = start; i < N; i++){
            selected[cnt] = i;
            combi(graph, input, N, i + 1, cnt + 1, selected);
        }
    }
}
