package 백준_17143_낚시왕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
식
1. 상어를 방향대로 벽까지 보낸다. 만약 벽까지의 거리보다 속도가 작으거나 같으면 뱡향 그대로에 이동만.
2. 벽으로 보냈는데 속도가 남아있다 그럼 방향 바꾸고 남은 속도로 계산.
3. 방향에 따라 R, C의 길이 - 1 을 뺀 값으로 나눈다.
3.1 나눈 몫이 짝수이고 나머지가 0이 아닐때 방향 그대로
3.2 나눈 몫이 홀수이고 나머지가 0이 아닐때 방향 반대로.
*/
public class Main {
    static class Shark implements Comparable<Shark> {
        int cnt, r, c, s, d, z;

        public Shark(int cnt, int r, int c, int s, int d, int z) {
            this.cnt = cnt;
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return o.z - this.z;
        }
    }

    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Shark[][] map = new Shark[R + 1][C + 1];
        List<Shark> sharks = new ArrayList<>();
        result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sharks.add(new Shark(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            map[sharks.get(i).r][sharks.get(i).c] = sharks.get(i);
        }

        for (int i = 1; i <= C; i++) {
//            if(i%10==1){
//                System.out.println(sharks.size());
//            }
            for (int j = 1; j <= R; j++) {

                if (map[j][i] != null) {
                    Shark shark = map[j][i];
                    result += shark.z;
                    int cnt = shark.cnt;
//                    sharks.remove(cnt);
                    sharks.remove(shark);
                    break;
                }
            }

            if(i == C){
                break;
            }
            sharkSetting(sharks);

            map = sharkMove(R, C, sharks);

            sharkSetting(sharks);
        }


        System.out.println(result);
    }

    static void sharkSetting(List<Shark> sharks) {
        int size = sharks.size();
        for (int i = 0; i < size; i++) {
            sharks.get(i).cnt = i;
        }
    }

    static Shark[][] sharkMove(int R, int C, List<Shark> sharks) {
        int size = sharks.size();
//        PriorityQueue<Integer> deleteSharks = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Shark> deleteSharks = new LinkedList<>();
        Shark[][] map = new Shark[R+1][C+1];
        for (int i = 0; i < size; i++) {
            Shark shark = sharks.get(i);

            int speed = shark.s;
            if(shark.d == 1 || shark.d == 2){
                speed = speed % ((R - 1) * 2);
            }else{
                speed = speed % ((C - 1) * 2);
            }

            for(int j = 0; j < speed; j++){
                int nr = shark.r + delta[shark.d-1][0];
                int nc = shark.c + delta[shark.d-1][1];

                if(nr < 1 || nr > R || nc < 1 || nc > C){
                    if(shark.d % 2 == 0){
                        shark.d--;
                    }else{
                        shark.d++;
                    }
                    j--;
                    continue;
                }

                shark.r = nr;
                shark.c = nc;

            }

            // 예전에 푼 이동 로직
//            if (shark.d == 1) {
//                if (shark.r - 1 >= shark.s) {
//                    shark.r = shark.r - shark.s;
//                } else {
//                    shark.d = 2;
//                    int speed = shark.s;
//                    speed = speed - (shark.r - 1);
//                    int share = speed / (R - 1);
//                    int remain = speed % (R - 1);
//                    if (share % 2 == 0) {
//                        if (remain == 0) {
//                            shark.r = 1;
//                            shark.d = 1;
//                        } else {
//                            shark.r = 1 + remain;
//                        }
//                    } else {
//                        if (remain == 0) {
//                            shark.r = R;
//                        } else {
//                            shark.r = R - remain;
//                        }
//                    }
//                }
//            } else if (shark.d == 2) {
//                if (shark.r + shark.s <= R) {
//                    shark.r = shark.r + shark.s;
//                } else {
//                    shark.d = 1;
//                    int speed = shark.s;
//                    speed = speed - (R - shark.r);
//                    int share = speed / (R - 1);
//                    int remain = speed % (R - 1);
//                    if (share % 2 == 0) {
//                        if (remain == 0) {
//                            shark.r = R;
//                            shark.d = 2;
//                        } else {
//                            shark.r = R - remain;
//                        }
//                    } else {
//                        if (remain == 0) {
//                            shark.r = 1;
//                        } else {
//                            shark.r = 1 + remain;
//                            shark.d = 2;
//                        }
//                    }
//                }
//            } else if (shark.d == 3) {
//                if (shark.c + shark.s <= C) {
//                    shark.c = shark.c + shark.s;
//                } else {
//                    shark.d = 4;
//                    int speed = shark.s;
//                    speed = speed - (C - shark.c);
//                    int share = speed / (C - 1);
//                    int remain = speed % (C - 1);
//                    if (share % 2 == 0) {
//                        if (remain == 0) {
//                            shark.c = C;
//                            shark.d = 3;
//                        } else {
//                            shark.c = C - remain;
//                        }
//                    } else {
//                        if (remain == 0) {
//                            shark.c = 1;
//                        } else {
//                            shark.c = 1 + remain;
//                            shark.d = 3;
//                        }
//                    }
//                }
//            } else if (shark.d == 4) {
//                if (shark.c - 1 >= shark.s) {
//                    shark.c = shark.c - shark.s;
//                } else {
//                    shark.d = 3;
//                    int speed = shark.s;
//                    speed = speed - (shark.c - 1);
//                    int share = speed / (C - 1);
//                    int remain = speed % (C - 1);
//                    if (share % 2 == 0) {
//                        if (remain == 0) {
//                            shark.c = 1;
//                            shark.d = 4;
//                        } else {
//                            shark.c = 1 + remain;
//                        }
//                    } else {
//                        if (remain == 0) {
//                            shark.c = C;
//                        } else {
//                            shark.c = C - remain;
//                        }
//                    }
//                }
//            }// 이동 끝
            // 로직 끝
            if(map[shark.r][shark.c] == null){
                map[shark.r][shark.c] = shark;
            }else{
                if(map[shark.r][shark.c].z < shark.z){
//                    deleteSharks.add(map[shark.r][shark.c].cnt);
                    deleteSharks.add(map[shark.r][shark.c]);
                    map[shark.r][shark.c] = shark;
                }else{
//                    deleteSharks.add(shark.cnt);
                    deleteSharks.add(shark);
                }
            }

        }

        while (!deleteSharks.isEmpty()) {
//            int delete = deleteSharks.poll();
            Shark delete = deleteSharks.poll();
            sharks.remove(delete);
        }
        return map;
    }
}
