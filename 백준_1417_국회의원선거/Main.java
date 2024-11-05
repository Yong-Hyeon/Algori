package 백준_1417_국회의원선거;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int me = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (!pq.isEmpty()){
            int now = pq.poll();
            if(me > now){
                break;
            }
            now--;
            result++;
            me++;
            pq.add(now);
        }
        sb.append(result);

        System.out.println(sb);
    }
}
