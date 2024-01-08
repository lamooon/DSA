import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Josephus_Deque_Problem {

//https://www.acmicpc.net/problem/2346
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Deque<int []> q = new ArrayDeque<>();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            q.add(new int[] {i + 1, arr[i]});
        }

//        for (int[] x : q) {
//            System.out.println("Index: " + x[0] +" value: " + x[1]);
//        }



        int[] current = q.poll();
        int value = current[1];
        sb.append(current[0] + " ");
        while (!q.isEmpty()) {
            if (value > 0) {

                for (int i = 0; i < value - 1; i++)
                {
                    q.addLast(q.pollFirst());
                }
                current = q.pollFirst();
            }
            else {
                for (int i = value + 1; i != 0; i++) {
                    q.addFirst(q.pollLast());
                }
                current = q.pollLast();
            }
            value = current[1];
            sb.append(current[0] + " ");
        }
        System.out.println(sb.toString());
    }
}
