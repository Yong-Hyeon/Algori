package 백준_11286_절대값힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Abs implements Comparable<Abs>{
        int abs;
        int num;

        Abs(int abs, int num){
            this.abs = abs;
            this.num = num;
        }

        @Override
        public int compareTo(Abs o) {
            return this.abs == o.abs ? (this.num < o.num ? -1 : 1) : this.abs - o.abs;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Abs> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll().num).append("\n");
                }
            }else{
                pq.add(new Abs(Math.abs(num), num));
            }
        }

        System.out.println(sb);
    }
}
