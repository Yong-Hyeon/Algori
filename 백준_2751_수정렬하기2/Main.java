package 백준_2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] check = new int[2000001];
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            check[num + 1000000]++;
        }
        StringBuilder sb = new StringBuilder();
//        while (!pq.isEmpty()){
//            sb.append(pq.poll()).append("\n");
//        }
        for(int i = 0; i < 2000001; i++){
            if(check[i] != 0){
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.println(sb);

    }
}
