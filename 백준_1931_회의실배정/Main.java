package 백준_1931_회의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Meeting o) {
            return this.end == o.end ? this.start - o.start : this.end - o.end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           Meeting meeting = new Meeting(start,end);
           pq.add(meeting);
        }

        int cnt = 1;
        int end = pq.poll().end;
        while (!pq.isEmpty()){
            Meeting now = pq.poll();
            if(now.start >= end){
                cnt++;
                end = now.end;
            }
        }

        System.out.println(cnt);
    }
}
