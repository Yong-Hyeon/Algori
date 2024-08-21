package 백준_2162_선분그룹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point o) {
            return o.x == this.x ? o.y - this.y : o.x - this.x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][4];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                lines[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] isVisited = new boolean[N];
        int max = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(isVisited[i]){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisited[i] = true;
            cnt++;
            int size = 1;
            while (!queue.isEmpty()){
                int now = queue.poll();

                for(int j = 0; j < N; j++){
                    if(isVisited[j]){
                        continue;
                    }
                    int c1 = ccw(lines[now][0], lines[now][1], lines[now][2], lines[now][3], lines[j][0], lines[j][1]);
                    int c2 = ccw(lines[now][0], lines[now][1], lines[now][2], lines[now][3], lines[j][2], lines[j][3]);
                    int c3 = ccw(lines[j][0], lines[j][1], lines[j][2], lines[j][3], lines[now][0], lines[now][1]);
                    int c4 = ccw(lines[j][0], lines[j][1], lines[j][2], lines[j][3], lines[now][2], lines[now][3]);

                    if(c1 != c2 && c3 != c4){
                        size++;
                        queue.add(j);
                        isVisited[j] = true;
                    }else if(c1 == 0 && c2 == 0 && c3 == 0 && c4 == 0){
                        Point p1 = new Point(lines[now][0], lines[now][1]);
                        Point p2 = new Point(lines[now][2], lines[now][3]);
                        Point p3 = new Point(lines[j][0], lines[j][1]);
                        Point p4 = new Point(lines[j][2], lines[j][3]);

                        Point max1, min1, max2, min2;

                        if(p1.compareTo(p2) > 0){
                            max1 = p1;
                            min1 = p2;
                        }else{
                            max1 = p2;
                            min1 = p1;
                        }
                        if(p3.compareTo(p4) > 0){
                            max2 = p3;
                            min2 = p4;
                        }else{
                            max2 = p4;
                            min2 = p3;
                        }

                        if(max1.compareTo(min2) >= 0 && max2.compareTo(min1) >= 0){
                            size++;
                            queue.add(j);
                            isVisited[j] = true;
                        }
                    }


                }
            }
            max = Math.max(max, size);
        }

        sb.append(cnt).append("\n");
        sb.append(max).append("\n");

        System.out.println(sb);
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int d = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;

        if(d > 0){
            return 1;
        }else if(d == 0){
            return 0;
        }else{
            return -1;
        }
    }
}
