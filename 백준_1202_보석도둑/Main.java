package 백준_1202_보석도둑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Dia implements Comparable<Dia>{
        int weight;
        int cost;

        Dia(int weight, int cost){
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Dia o) {
            return o.cost - this.cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Dia[] dias = new Dia[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            dias[i] = new Dia(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bags = new int[K];
        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dias, new Comparator<Dia>() {
            @Override
            public int compare(Dia o1, Dia o2) {
                return o1.weight - o2.weight;
            }
        });
        Arrays.sort(bags);

        long sum = 0;
        PriorityQueue<Dia> pq = new PriorityQueue<>();
        int j = 0;
        for(int i = 0; i < K; i++){
            int bag = bags[i];
            while (j < N && dias[j].weight <= bag){
                pq.add(dias[j++]);
            }
            if(!pq.isEmpty()){
                sum += pq.poll().cost;
            }
        }

        sb.append(sum).append("\n");
        System.out.println(sb);
    }

}
