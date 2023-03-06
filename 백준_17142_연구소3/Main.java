package 백준_17142_연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,cnt, mid, ans=Integer.MAX_VALUE;
    static int [] di = {-1,0,1,0}, dj ={0,-1,0,1};
    static int [][] arr, brr;
    static boolean bool;
    static boolean [] visited;
    static Queue<Point> choose;
    static ArrayList<Point> virus;
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int [N][N];
        virus = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2) {
                    virus.add(new Point(i,j));
                    arr[i][j]=-2;
                } else if(arr[i][j]==1) arr[i][j]=-1;
                else cnt++;
            }
        }

        visited  = new boolean [virus.size()];
        combi(0,0);

        if(ans==Integer.MAX_VALUE ) System.out.println(-1);
        else if(cnt == 0)System.out.println(0);
        else System.out.println(ans);

    }

    public static void combi(int cnt, int start) {
        if(cnt==M) {
            spreadVirus();
            ans = Math.min(ans, check());
            return;
        }

        for(int i=start; i<virus.size(); i++) {
            if(visited[i]) continue;
            visited[i]=true;
            combi(cnt+1, i+1);
            visited[i]=false;
        }
    }

    public static void spreadVirus() {
        choose = new LinkedList<>();
        copy();

        for(int i=0; i<virus.size(); i++) {
            if(visited[i]) {
                choose.add(virus.get(i));
                brr[virus.get(i).x][virus.get(i).y]=1;
            }
        }
//        mid = Integer.MAX_VALUE;
        int time=1, tmpCnt=0;
        while(!choose.isEmpty()) {
            int size = choose.size();

            for(int i=0; i<size; i++) {
                Point p = choose.poll();

                for(int d=0; d<4; d++) {
                    int ni = p.x + di[d];
                    int nj = p.y + dj[d];


                    if(ni>=0 && ni<N && nj>=0 && nj<N) {
                        if(brr[ni][nj]==0) {
                            brr[ni][nj] = time;
                            tmpCnt++;
                            choose.add(new Point(ni, nj));
                        } else if(brr[ni][nj]==-2) {
                            brr[ni][nj] = 1;
                            choose.add(new Point(ni, nj));
                        }
                    }
                }
            }
            time++;
        }
//        if(cnt-tmpCnt==0) mid=time;
    }

    public static int check() {
        mid=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(brr[i][j]==0) return Integer.MAX_VALUE;
                mid=Math.max(mid,brr[i][j]);
            }
        }
        return mid;
    }

    public static void copy() {
        brr = new int [N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                brr[i][j]=arr[i][j];
            }
        }
    }
}