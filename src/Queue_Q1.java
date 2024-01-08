import java.io.*;
import java.util.*;

public class Queue_Q1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            int j = 1;
            while (j < k) {
                q.add(q.poll());
                j++;
            }
            sb.append(q.peek() + ", ");
            q.remove();
        }
        sb.replace(sb.length() - 2, sb.length() - 1, ">");
        System.out.println(sb.toString());
    }
}
