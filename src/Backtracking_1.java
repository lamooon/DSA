import java.io.*;
import java.util.*;

public class Backtracking_1 {

    static boolean[] visited;
    static int[] numbers;
    static int n;
    static int k;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        //learning Backtracking concept from https://velog.io/@kimmjieun/백준-15649번-N과-M1-Java-자바

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        numbers = new int[k];

        DFS(0);
        System.out.println(sb.toString().trim());
    }

    private static void DFS(int depth) {

        if (depth == k) {
            for (int val : numbers) {
                sb.append(val + " ");
            }
            sb.append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < n; i++) {

            if (visited[i] == false) {
                visited[i] = true;
                numbers[depth] = i + 1;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
