package 백준_1966_프린터큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            int[] imports = new int[N];
            int[] importCnt = new int[10];
            int maxImport = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(st.nextToken());
                imports[i] = num;
                importCnt[num]++;
                maxImport = Math.max(maxImport, num);
            }

            int cnt = 0;
            int current = 0;

            while (true){
                if(current >= N){
                    current %= N;
                }
                if(importCnt[imports[current]] <= 0){
                    current++;
                    continue;
                }
                if(importCnt[maxImport] <= 0){
                    maxImport--;
                    continue;
                }
                if(imports[current] == maxImport){
                    importCnt[maxImport]--;
                    imports[current] = 0;
                    cnt++;
                    if(current == goal){
                        break;
                    }
                }
                current++;
            }
            sb.append(cnt).append("\n");

        }

        System.out.println(sb);

    }
}
