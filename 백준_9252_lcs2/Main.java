package 백준_9252_lcs2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        int[][] delta = {{-1,0},{0,-1},{-1,-1}};
        if(lcs[xN][yN] != 0){
            Stack<Character> stack = new Stack<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{xN,yN});

            while (!queue.isEmpty()){
                int[] now = queue.poll();
                if(now[0] == 0 || now[1] == 0){
                    break;
                }

                for(int i = 0; i < 3; i++){
                    int nr = now[0] + delta[i][0];
                    int nc = now[1] + delta[i][1];
                    if(lcs[nr][nc] == lcs[now[0]][now[1]]){
                        queue.add(new int[]{nr,nc});
                        break;
                    }
                    if(i == 2){
                    stack.push(X.charAt(nr));
                    queue.add(new int[]{nr,nc});
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb);
        }
    }
}
