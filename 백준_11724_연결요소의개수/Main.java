package 백준_11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            map[to][from] = 1;
        }

        boolean[] isVisited = new boolean[N+1];
        int result = 0;
        for(int i = 1; i <= N; i++){
            if(isVisited[i]){
                continue;
            }
            result++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisited[i] = true;
            while (!queue.isEmpty()){
                int now = queue.poll();
                for(int j = 1; j <= N; j++){
                    if(map[now][j] == 1 && !isVisited[j]){
                        queue.add(j);
                        isVisited[j] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
