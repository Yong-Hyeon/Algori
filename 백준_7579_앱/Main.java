package 백준_7579_앱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class App{
        int memory;
        int cost;

        public App(int memory, int cost){
            this.memory = memory;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cost = new int[10001];
        App[] apps = new App[N];

        String[] memoryStr = br.readLine().split(" ");
        String[] costStr = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            apps[i] = new App(Integer.parseInt(memoryStr[i]), Integer.parseInt(costStr[i]));
        }

        for(int i = 0; i < N; i++){
            int nowCost = apps[i].cost;
            int nowMemory = apps[i].memory;
            for(int c = 10000 - nowCost; c >= 0; c--){
                if(cost[c + nowCost] < cost[c] + nowMemory){
                    cost[c + nowCost] = cost[c] + nowMemory;
                }
            }
        }

        for(int i = 0; i < 10001; i++){
            if(cost[i] >= M){
                sb.append(i).append("\n");
                break;
            }
        }

        System.out.println(sb);
    }
}
