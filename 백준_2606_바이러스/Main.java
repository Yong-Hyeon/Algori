package 백준_2606_바이러스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] computers = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            computers[A][B] = 1;
            computers[B][A] = 1;
        }

        boolean[] isVisited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 1; i <= N; i++){
                if(computers[now][i] == 1 && !isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
