package 백준_10814_나이순정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person>{
        int no;
        int age;
        String name;

        Person(int no, int age, String name){
            this.no = no;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age == o.age ? this.no - o.no : this.age - o.age;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people[i] = new Person(i,age,name);
        }

        Arrays.sort(people);

        for(int i = 0; i < N; i++){
            sb.append(people[i].age).append(" ").append(people[i].name).append("\n");
        }


        System.out.println(sb);
    }

}
