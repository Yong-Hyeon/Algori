package 백준_11403_경로찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int[][] result = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] isVisited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();


        for(int i = 0; i < N; i++){
            isVisited = new boolean[N];
            queue.add(i);

            while (!queue.isEmpty()){
                int now = queue.poll();

                for(int j = 0; j < N; j++){
                    if(graph[now][j] == 1 && !isVisited[j]){
                        queue.add(j);
                        isVisited[j] = true;
                        result[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
