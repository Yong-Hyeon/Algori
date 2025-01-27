package 백준_1652_누울자리를찾아라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);;
            }
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            int rowCnt = 0;
            int colCnt = 0;
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '.'){
                    rowCnt++;
                }else{
                    if(rowCnt > 1){
                        row++;
                    }
                    rowCnt = 0;
                }
                if(map[j][i] == '.'){
                    colCnt++;
                }else{
                    if(colCnt > 1){
                        col++;
                    }
                    colCnt = 0;
                }
            }
            if(rowCnt > 1){
                row++;
            }
            if(colCnt > 1){
                col++;
            }
        }

        sb.append(row).append(" ").append(col);
        System.out.println(sb);
    }

}
