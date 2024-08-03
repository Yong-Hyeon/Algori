package 백준_17387_선분교차2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        int c1 = ccw(x1,y1, x2,y2, x3, y3);
        int c2 = ccw(x1,y1, x2,y2, x4, y4);
        int c3 = ccw(x3,y3, x4,y4, x1, y1);
        int c4 = ccw(x3,y3, x4,y4, x2, y2);

        if(c1 != c2 && c3 != c4){
            sb.append(1).append("\n");
        }else if(c1 == 0 && c2 == 0 && c3 == 0 && c4 == 0){
            Point p1 = new Point((int)x1, (int)y1);
            Point p2 = new Point((int)x2, (int)y2);
            Point p3 = new Point((int)x3, (int)y3);
            Point p4 = new Point((int)x4, (int)y4);

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
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }

        }else{
            sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long d = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;

        if(d > 0){
            return 1;
        }else if(d == 0){
            return 0;
        }else{
            return -1;
        }
    }
}
