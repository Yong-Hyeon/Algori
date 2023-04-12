package 백준_7490_0만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] opers = {' ', '+', '-'};

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[] combis = new char[N * 2 - 1];
            combi(N, opers, combis, 0, 1);


            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void combi(int N, char[] opers, char[] combis, int cnt, int start) {
        if (cnt == N * 2 - 1) {
            // 계산하기
        }

        for (int i = start; i < 10; i++) {
            if (cnt % 2 == 0) {
                opers[cnt] = (char)i;
            } else {
                for (int k = 0; k < 3; k++) {

                }

            }
        }

    }
}
