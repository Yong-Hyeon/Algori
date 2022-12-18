package 백준_1700_멀티탭스케줄링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_1700_멀티탭스케줄링_못품 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] uses = new int[K];
        int[] cnt = new int[K+1];
        int useSocketCnt = 0;
        int result = 0;
        int[] useSocket = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            uses[i] = Integer.parseInt(st.nextToken());
            cnt[uses[i]]++;
        }

        boolean[] isUsed = new boolean[K+1];

        for(int i = 0; i < K; i++){
            if(!isUsed[uses[i]]){
                if(useSocketCnt == N){
                    isUsed[useSocket[useSocketCnt]] = false;
                    result++;
                }else{
                    useSocketCnt++;
                }
                useSocket[useSocketCnt] = uses[i];
                isUsed[uses[i]] = true;
            }
        }

        System.out.println(result);
    }
}
