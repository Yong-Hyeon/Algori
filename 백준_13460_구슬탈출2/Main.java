package 백준_13460_구슬탈출2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int redR = 0;
        int redC = 0;
        int blueR = 0;
        int blueC = 0;

        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char ch = str.charAt(j);
                if(ch == 'R'){
                    redR = i;
                    redC = j;
                }else if(ch == 'B'){
                    blueR = i;
                    blueC = j;
                }else{
                    map[i][j] = ch;
                }
            }
        }

        int[][] delta = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        boolean[][] isVisited = new boolean[N][M];
        min = 20;
        for(int d = 0; d < 4; d++){
            search(redR, redC, blueR, blueC, delta, isVisited, map, d, 1);
        }

        sb.append(min == 20 ? -1 : min).append("\n");
        System.out.println(sb);
    }

    private static void search(int redR, int redC, int blueR, int blueC, int[][] delta, boolean[][] isVisited, char[][] map, int d, int cnt) {
        if(cnt > 10){
            return;
        }

        boolean isEnd = false;

        if(map[redR + delta[d][0]][redC + delta[d][1]] == '#' && map[blueR + delta[d][0]][blueC + delta[d][1]] == '#'){
            return;
        }

        if(d == 0){
            if(redR < blueR){
                while (true){
                    redR = redR + delta[d][0];
                    if(map[redR][redC] == '#'){
                        redR = redR - delta[d][0];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        redR = 0;
                        redC = 0;
                        isEnd = true;
                        break;
                    }
                }
                while (true){
                    blueR = blueR + delta[d][0];
                    if(map[blueR][blueC] == '#'|| (blueR == redR && blueC == redC)){
                        blueR = blueR - delta[d][0];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
            }else{
                while (true){
                    blueR = blueR + delta[d][0];
                    if(map[blueR][blueC] == '#'){
                        blueR = blueR - delta[d][0];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
                while (true){
                    redR = redR + delta[d][0];
                    if(map[redR][redC] == '#' || (blueR == redR && blueC == redC)){
                        redR = redR - delta[d][0];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        isEnd = true;
                    }
                }
            }
        }else if(d == 1){
            if(redC > blueC){
                while (true){
                    redC = redC + delta[d][1];
                    if(map[redR][redC] == '#'){
                        redC = redC - delta[d][1];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        redR = 0;
                        redC = 0;
                        isEnd = true;
                        break;
                    }
                }
                while (true){
                    blueC = blueC + delta[d][1];
                    if(map[blueR][blueC] == '#'|| (blueR == redR && blueC == redC)){
                        blueC = blueC - delta[d][1];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
            }else{
                while (true){
                    blueC = blueC + delta[d][1];
                    if(map[blueR][blueC] == '#'){
                        blueC = blueC - delta[d][1];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
                while (true){
                    redC = redC + delta[d][1];
                    if(map[redR][redC] == '#' || (blueR == redR && blueC == redC)){
                        redC = redC - delta[d][1];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        isEnd = true;
                    }
                }
            }

        }else if(d == 2){
            if(redR > blueR){
                while (true){
                    redR = redR + delta[d][0];
                    if(map[redR][redC] == '#'){
                        redR = redR - delta[d][0];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        redR = 0;
                        redC = 0;
                        isEnd = true;
                        break;
                    }
                }
                while (true){
                    blueR = blueR + delta[d][0];
                    if(map[blueR][blueC] == '#'|| (blueR == redR && blueC == redC)){
                        blueR = blueR - delta[d][0];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
            }else{
                while (true){
                    blueR = blueR + delta[d][0];
                    if(map[blueR][blueC] == '#'){
                        blueR = blueR - delta[d][0];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
                while (true){
                    redR = redR + delta[d][0];
                    if(map[redR][redC] == '#' || (blueR == redR && blueC == redC)){
                        redR = redR - delta[d][0];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        isEnd = true;
                    }
                }
            }

        }else{
            if(redC < blueC){
                while (true){
                    redC = redC + delta[d][1];
                    if(map[redR][redC] == '#'){
                        redC = redC - delta[d][1];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        redR = 0;
                        redC = 0;
                        isEnd = true;
                        break;
                    }
                }
                while (true){
                    blueC = blueC + delta[d][1];
                    if(map[blueR][blueC] == '#'|| (blueR == redR && blueC == redC)){
                        blueC = blueC - delta[d][1];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
            }else{
                while (true){
                    blueC = blueC + delta[d][1];
                    if(map[blueR][blueC] == '#'){
                        blueC = blueC - delta[d][1];
                        break;
                    }else if(map[blueR][blueC] == 'O'){
                        return;
                    }
                }
                while (true){
                    redC = redC + delta[d][1];
                    if(map[redR][redC] == '#' || (blueR == redR && blueC == redC)){
                        redC = redC - delta[d][1];
                        break;
                    }else if(map[redR][redC] == 'O'){
                        isEnd = true;
                    }
                }
            }
        }

        if(isEnd){
            min = Math.min(min, cnt);
            return;
        }

        for(int i = 0; i < 4; i++){
            search(redR, redC, blueR, blueC, delta, isVisited, map, i, cnt + 1);
        }
    }
}
