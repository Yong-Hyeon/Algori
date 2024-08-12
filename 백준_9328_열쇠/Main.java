package 백준_9328_열쇠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int r;
        int c;
        char ch;

        public Point(int r, int c, char ch){
            this.r = r;
            this.c = c;
            this.ch = ch;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];

            for(int i = 0; i < h; i++){
                String str = br.readLine();
                for(int j = 0; j < w; j++){
                    map[i][j] = str.charAt(j);
                }
            }
            String str = br.readLine();
            boolean[] key = new boolean['z' + 1];
            // 90 이하는 대문자 아니면 소문자, 대소문자는 32 차이남
            for(int i = 0; i < str.length(); i++){
                key[str.charAt(i)] = true;
            }


            boolean[][] isVisited = new boolean[h][w];
            Queue<Point> queue = new LinkedList<>();
            for(int i = 0; i < h; i++){
                queue.add(new Point(i, 0, map[i][0]));
                queue.add(new Point(i, w-1, map[i][w-1]));
                isVisited[i][0] = true;
                isVisited[i][w-1] = true;
            }
            for(int i = 1; i < w - 1; i++){
                queue.add(new Point(0, i, map[0][i]));
                queue.add(new Point(h-1, i, map[h-1][i]));
                isVisited[0][i] = true;
                isVisited[h-1][i] = true;
            }

            int[][] delta = {{-1, 0},{0, 1},{1, 0},{0, -1}};
            boolean isChange = true;
            int result = 0;
            while (isChange){
                isChange = false;
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Point now = queue.poll();
                    if(now.ch == '*'){
                        continue;
                    }
                    if(now.ch >= 97 && now.ch <= 122){
                        key[now.ch] = true;
                        isChange = true;
                    }

                    if(now.ch >= 65 && now.ch <= 90){
                        if(!key[now.ch + 32]){
                            queue.add(new Point(now.r, now.c, now.ch));
                            continue;
                        }
                    }

                    if(now.ch == '$'){
                        result++;
                    }

                    for(int d = 0; d < 4; d++){
                        int nr = now.r + delta[d][0];
                        int nc = now.c + delta[d][1];

                        if(nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == '*' || isVisited[nr][nc]){
                            continue;
                        }
                        queue.add(new Point(nr, nc, map[nr][nc]));
                        isVisited[nr][nc] = true;
                        isChange = true;
                    }

                }
            }
            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }
}
