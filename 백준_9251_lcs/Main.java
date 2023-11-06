package 백준_9251_lcs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String Y = br.readLine();

        int xN = X.length();
        int yN = Y.length();

        int[][] lcs = new int[xN + 1][yN + 1];

        for(int i = 1; i <= xN; i++){
            for(int j = 1; j <= yN; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        System.out.println(lcs[xN][yN]);
    }
}
