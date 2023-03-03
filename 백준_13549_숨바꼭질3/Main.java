package 백준_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int time;
        int point;

        Point(int point, int time) {
            this.time = time;
            this.point = point;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[200001];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));

        if(N > K){
            cnt = N - K;
            queue.poll();
        }

        while (!queue.isEmpty()) {


            Point current = queue.poll();

            if (current.point == K) {
                cnt = current.time;
                break;
            }

            for (int j = 0; j < 3; j++) {
                int next = 0;
                if (j == 2) {
                    next = current.point - 1;
                    if (next >= 0 && !isVisited[next]) {
                        queue.add(new Point(next, current.time + 1));
//                            isVisited[next] = true;
                    }
                } else if (j == 1) {
                    next = current.point + 1;
                    if (next <= 200000 && !isVisited[next]) {
                        queue.add(new Point(next, current.time + 1));
//                            isVisited[next] = true;
                    }
                } else if (j == 0) {
                    for (int k = current.point; k <= 200000; k *= 2) {
                        if (isVisited[k]) {
                            break;
                        }
                        if (!isVisited[k]) {
                            queue.add(new Point(k, current.time));
                            isVisited[k] = true;
                        }
                    }
                }
            }
        }


        System.out.println(cnt);
    }
}
