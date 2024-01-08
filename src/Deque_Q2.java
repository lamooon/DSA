import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/24511
public class Deque_Q2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] queueStack = new int[n];
        int[] e = new int[n];
        for (int i = 0; i < n; i++) queueStack[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) e[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (queueStack[i] == 0) {
                dq.add(e[i]);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            dq.addFirst(x);
            sb.append(dq.pollLast() + " ");
        }

        System.out.println(sb.toString().trim());

    }
}