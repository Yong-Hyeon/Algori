package 백준_2775_부녀회장이될테야;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k+1][n+1];

            for(int i = 0; i <= k; i++){
                for(int j = 1; j <= n; j++){
                    if(i == 0){
                        apt[i][j] = j;
                    }else{
                        apt[i][j] = apt[i-1][j] + apt[i][j-1];
                    }
                }
            }

            System.out.println(apt[k][n]);
        }

    }
}
