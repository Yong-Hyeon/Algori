package 백준_10775_공항;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] parent = new int[G+1];
        for(int i = 1; i <= G; i++){
            parent[i] = i;
        }
        boolean isEnd = false;
        for(int i = 0; i < P; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == parent[num]){
                parent[num]--;
                find(num, parent);
            }else{
                int root = find(num, parent);
                if(root == 0){
                    sb.append(i).append("\n");
                    isEnd = true;
                    break;
                }else{
                    parent[root]--;
                    find(root, parent);
                }
            }
        }
        if(!isEnd){
            sb.append(G).append("\n");
        }

        System.out.println(sb);
    }

    private static int find(int num, int[] parent) {
        if(num == parent[num]){
            return num;
        }

        return parent[num] = find(parent[num], parent);
    }

}
