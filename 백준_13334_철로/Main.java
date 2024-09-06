package 백준_13334_철로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line>{
        int start;
        int end;

        public Line(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o){
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a > b){
                lines.add(new Line(b,a));
            }else{
                lines.add(new Line(a,b));
            }
        }

        int d = Integer.parseInt(br.readLine());

        List<Line> station = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(lines.get(i).end - lines.get(i).start <= d){
                station.add(lines.get(i));
            }
        }

        Collections.sort(station);
        int size = station.size();
        int max = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < size; i++){
            while (!pq.isEmpty() && station.get(i).end - pq.peek() > d){
                pq.poll();
                cnt--;
            }

            pq.add(station.get(i).start);
            cnt++;
            max = Math.max(max, cnt);
        }

        sb.append(max).append("\n");
        System.out.println(sb);
    }
}
