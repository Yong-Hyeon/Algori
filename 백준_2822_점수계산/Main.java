package 백준_2822_점수계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Score implements Comparable<Score>{
        int no;
        int score;

        Score(int no, int score){
            this.no = no;
            this.score = score;
        }

        @Override
        public int compareTo(Score o){
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Score> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 8; i++){
            pq.add(new Score(i, Integer.parseInt(br.readLine())));
        }

        int sum = 0;
        for(int i = 0; i < 5; i++){
            Score now = pq.poll();
            sum += now.score;
            list.add(now.no);
        }

        Collections.sort(list);

        sb.append(sum).append("\n");

        for(int i = 0; i < 5; i++){
            sb.append(list.get(i)).append(" ");
        }

        System.out.print(sb);
    }
}
