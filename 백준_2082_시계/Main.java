package 백준_2082_시계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int r;
        int c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String[] digitalNumber = {"###  ..#  ###  ###  #.#  ###  ###  ###  ###  ###",
                "#.#  ..#  ..#  ..#  #.#  #..  #..  ..#  #.#  #.#",
                "#.#  ..#  ###  ###  ###  ###  ###  ..#  ###  ###",
                "#.#  ..#  #..  ..#  ..#  ..#  #.#  ..#  #.#  ..#",
                "###  ..#  ###  ###  ..#  ###  ###  ..#  ###  ###"};

        char[][][] checks = new char[4][5][3];
        List<List<Point>> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++){
                String str = st.nextToken();
                for(int k = 0; k < 3; k++){
                    checks[j][i][k] = str.charAt(k);
                    if(checks[j][i][k] == '.'){
                        list.get(j).add(new Point(i,k));
                    }
                }
            }
        }

        int[] min = {10,10,10,10};

        for(int i = 0; i < 4; i++){
            subset(digitalNumber, checks, list, i, 0, list.get(i).size(), min);
        }

        sb.append(min[0]).append(min[1]).append(":").append(min[2]).append(min[3]);

        System.out.println(sb);
    }

    private static void subset(String[] digitalNumber, char[][][] checks, List<List<Point>> list, int num, int cnt, int M, int[] min) {
        if(cnt == M){
            for(int i = 0; i < 10; i++){
                numCheck(digitalNumber, checks, num, min, i);
            }
            return;
        }

        checks[num][list.get(num).get(cnt).r][list.get(num).get(cnt).c] = '#';
        subset(digitalNumber, checks, list, num, cnt + 1, M, min);
        checks[num][list.get(num).get(cnt).r][list.get(num).get(cnt).c] = '.';
        subset(digitalNumber, checks, list, num, cnt + 1, M, min);

    }

    private static void numCheck(String[] digitalNumber, char[][][] checks, int num, int[] min, int now) {
        for(int j = 0; j < 5; j++){
            for(int k = 0; k < 3; k++){
                if(checks[num][j][k] != digitalNumber[j].charAt(now * 5 + k)){
                    return;
                }
            }
        }

        min[num] = Math.min(min[num], now);
    }

}
