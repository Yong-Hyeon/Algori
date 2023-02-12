package 백준_3025_돌던지기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] wallPoint = new int[R][C];
        List<List<Integer>> wallList = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            wallList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if (map[i][j] == 'X') {
                    wallList.get(j).add(i);
                }
            }
        }
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < wallList.size(); i++) {
            for (int j = 0; j < wallList.get(i).size(); j++) {
                int point = wallList.get(i).get(j);
                if (j == 0) {
                    for (int k = 0; k < point; k++) {
                        wallPoint[k][i] = point;
                    }
                }
                if (j > 0) {
                    for (int k = wallList.get(i).get(j - 1) + 1; k < point; k++) {
                        wallPoint[k][i] = point;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(wallPoint[i]));
        }

        for (int i = 0; i < N; i++) {
            int nowC = Integer.parseInt(br.readLine()) - 1;

            while (true) {
                int nowR = 0;
                if (wallPoint[nowR][nowC] == 0) {
                    if (map[R - 1][nowC] == '.') {
                        map[R - 1][nowC] = 'O';
                        wallPoint[R - 1][nowC]++;
                    }else{
                        //벽은 없는데 위에 계속 쌓이기 시작했으면 그만큼 위를 체크하기!
                    }
                }
            }


        }

    }
}