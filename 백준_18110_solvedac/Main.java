package 백준_18110_solvedac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        PriorityQueue<Integer> upPq = new PriorityQueue<>();
        PriorityQueue<Integer> downPq = new PriorityQueue<>(Collections.reverseOrder());


        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            upPq.add(num);
            downPq.add(num);
        }

        int cnt = Math.round(N * 0.15f);
        for(int i = 0; i < cnt; i++){
            sum -= upPq.poll();
            sum -= downPq.poll();
        }

        System.out.println(Math.round(sum / (float)(N - cnt * 2)));
    }
}
