package 백준_14226_이모티콘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Imoji {
        int cnt;
        int clipBoard;

        Imoji(int cnt, int clipBoard) {
            this.cnt = cnt;
            this.clipBoard = clipBoard;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        Queue<Imoji> queue = new LinkedList<>();
        queue.add(new Imoji(1, 0));
        boolean isEnd = false;
        int cnt = 0;
        boolean[][][] isVisited = new boolean[1001][1001][3];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Imoji imoji = queue.poll();

                if (imoji.cnt == S) {
                    isEnd = true;
                    break;
                }

                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        if (!isVisited[imoji.cnt][imoji.clipBoard][j]) {
                            queue.add(new Imoji(imoji.cnt, imoji.cnt));
                            isVisited[imoji.cnt][imoji.clipBoard][j] = true;
                        }
                    } else if (j == 1) {
                        if (imoji.clipBoard != 0) {
                            if (imoji.cnt + imoji.clipBoard <= 1000 && !isVisited[imoji.cnt + imoji.clipBoard][imoji.clipBoard][j]) {
                                queue.add(new Imoji(imoji.cnt + imoji.clipBoard, imoji.clipBoard));
                                isVisited[imoji.cnt + imoji.clipBoard][imoji.clipBoard][j] = true;
                            }
                        }
                    } else if (j == 2) {
                        if (imoji.cnt > 0 && !isVisited[imoji.cnt - 1][imoji.clipBoard][j]) {
                            queue.add(new Imoji(imoji.cnt - 1, imoji.clipBoard));
                            isVisited[imoji.cnt - 1][imoji.clipBoard][j] = true;
                        }
                    }
                }
            }
            if (isEnd) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
