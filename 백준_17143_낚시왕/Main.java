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

        PriorityQueue<Shark>[][] pqMap = new PriorityQueue[R + 1][C + 1];
        List<Shark> sharks = new ArrayList<>();
        result = 0;
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                pqMap[j][i] = new PriorityQueue<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sharks.add(new Shark(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            pqMap[sharks.get(i).r][sharks.get(i).c].add(sharks.get(i));
        }

        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {

                if (!pqMap[j][i].isEmpty()) {
                    Shark shark = pqMap[j][i].poll();
                    result += shark.z;
                    int cnt = shark.cnt;
                    sharks.remove(cnt);
                    break;
                }
            }

            if(i == C){
                break;
            }
            sharkSetting(sharks);
            pqInit(R,C,pqMap);

            sharkMove(R, C, sharks, pqMap);

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

    static void pqInit(int R, int C, PriorityQueue<Shark>[][] pqMap){
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                pqMap[j][i] = new PriorityQueue<>();
//                pqMap[j][i].clear();
            }
        }
    }
    static void sharkMove(int R, int C, List<Shark> sharks, PriorityQueue<Shark>[][] pqMap) {
        int size = sharks.size();
        for (int i = 0; i < size; i++) {
            Shark shark = sharks.get(i);

            if (shark.d == 1) {
                if (shark.r - 1 >= shark.s) {
                    shark.r = shark.r - shark.s;
                } else {
                    shark.d = 2;
                    int speed = shark.s;
                    speed = speed - (shark.r - 1);
                    int share = speed / (R - 1);
                    int remain = speed % (R - 1);
                    if (share % 2 == 0) {
                        if (remain == 0) {
                            shark.r = 1;
                            shark.d = 1;
                        } else {
                            shark.r = 1 + remain;
                        }
                    } else {
                        if (remain == 0) {
                            shark.r = R;
                        } else {
                            shark.r = R - remain;
                        }
                    }
                }
            } else if (shark.d == 2) {
                if (shark.r + shark.s <= R) {
                    shark.r = shark.r + shark.s;
                } else {
                    shark.d = 1;
                    int speed = shark.s;
                    speed = speed - (R - shark.r);
                    int share = speed / (R - 1);
                    int remain = speed % (R - 1);
                    if (share % 2 == 0) {
                        if (remain == 0) {
                            shark.r = R;
                            shark.d = 2;
                        } else {
                            shark.r = R - remain;
                        }
                    } else {
                        if (remain == 0) {
                            shark.r = 1;
                        } else {
                            shark.r = 1 + remain;
                            shark.d = 2;
                        }
                    }
                }
            } else if (shark.d == 3) {
                if (shark.c + shark.s <= C) {
                    shark.c = shark.c + shark.s;
                } else {
                    shark.d = 4;
                    int speed = shark.s;
                    speed = speed - (C - shark.c);
                    int share = speed / (C - 1);
                    int remain = speed % (C - 1);
                    if (share % 2 == 0) {
                        if (remain == 0) {
                            shark.c = C;
                            shark.d = 3;
                        } else {
                            shark.c = C - remain;
                        }
                    } else {
                        if (remain == 0) {
                            shark.c = 1;
                        } else {
                            shark.c = 1 + remain;
                            shark.d = 3;
                        }
                    }
                }
            } else if (shark.d == 4) {
                if (shark.c - 1 >= shark.s) {
                    shark.c = shark.c - shark.s;
                } else {
                    shark.d = 3;
                    int speed = shark.s;
                    speed = speed - (shark.c - 1);
                    int share = speed / (C - 1);
                    int remain = speed % (C - 1);
                    if (share % 2 == 0) {
                        if (remain == 0) {
                            shark.c = 1;
                            shark.d = 4;
                        } else {
                            shark.c = 1 + remain;
                        }
                    } else {
                        if (remain == 0) {
                            shark.c = C;
                        } else {
                            shark.c = C - remain;
                        }
                    }
                }
            }
            pqMap[shark.r][shark.c].add(shark);
        }
        PriorityQueue<Integer> deleteSharks = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (!pqMap[i][j].isEmpty()) {
                    Shark temp = pqMap[i][j].poll();

                    while (!pqMap[i][j].isEmpty()) {
                        deleteSharks.add(pqMap[i][j].poll().cnt);
                    }

                    pqMap[i][j].add(temp);
                }
            }
        }

        while (!deleteSharks.isEmpty()) {
            int delete = deleteSharks.poll();
            sharks.remove(delete);
        }
    }
}
