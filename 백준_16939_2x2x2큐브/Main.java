package 백준_16939_2x2x2큐브;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] startPoint = {1, 9, 5, 21, 13, 17};
    static int[][][] turnPoint = {{{1, 5, 9, 24}, {3, 7, 11, 22}},
                                    {{2, 6, 10, 23}, {4, 8, 12, 21}},
                                    {{3, 17, 10, 16}, {4, 19, 9, 14}},
                                    {{1, 18, 12, 15}, {2, 20, 11, 13}},
                                    {{13, 5, 17, 21}, {14, 6, 18, 22}},
                                    {{15, 7, 19, 23}, {16, 8, 20, 24}}};

    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cube = new int[25];

        for (int i = 1; i <= 24; i++) {
            cube[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;


        for (int t = 0; t < 6; t++) {
            turn(cube, t);
            if (result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void turn(int[] cube, int cnt) {
        int[] temp = new int[25];
        for (int i = 1; i <= 24; i++) {
            temp[i] = cube[i];
        }

        for(int i = 0; i < 4; i++){
            temp[turnPoint[cnt][0][(i + 1) % 4]] = cube[turnPoint[cnt][0][i]];
            temp[turnPoint[cnt][1][(i + 1) % 4]] = cube[turnPoint[cnt][1][i]];
        }

        if(check(temp)){
            result = 1;
        }
    }

    private static boolean check(int[] temp) {
        boolean isCheck = true;

        for(int i = 0; i < 6; i++){
            if(temp[startPoint[i]] == temp[startPoint[i] + 1] &&
                    temp[startPoint[i] + 2] == temp[startPoint[i] + 3] &&
                    temp[startPoint[i] + 1] == temp[startPoint[i] + 2]){
                isCheck = true;
            }else{
                isCheck = false;
                break;
            }
        }

        return isCheck;
    }

}
