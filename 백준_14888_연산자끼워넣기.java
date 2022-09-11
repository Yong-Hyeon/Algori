import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14888_연산자끼워넣기 {
    static public int max = Integer.MIN_VALUE;
    static public int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];

        for(int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numArr[0], 1, N, oper, numArr);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int index, int N, int[] oper, int[] numArr) {
        if(index == N){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(oper[i] > 0){
                oper[i]--;

                switch (i){
                    case 0:
                        dfs(num + numArr[index], index+1, N, oper, numArr);
                        break;

                    case 1:
                        dfs(num - numArr[index], index+1, N, oper, numArr);
                        break;

                    case 2:
                        dfs(num * numArr[index], index+1, N, oper, numArr);
                        break;

                    case 3:
                        dfs(num / numArr[index], index+1, N, oper, numArr);
                        break;

                }

                oper[i]++;
            }
        }
    }
}
