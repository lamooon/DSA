import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Recursion_1 {

    static char[] arr;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num;
        while ((num = br.readLine()) != null) {

            n = Integer.parseInt(num);
            arr = new char[(int) Math.pow(3, n)];

            Arrays.fill(arr, '-');

            cantor(0, (int) Math.pow(3, n) - 1);

            for (char c : arr) {
                if (c == '\u0000') sb.append(" ");
                else {
                    sb.append(c);
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }

    private static void cantor(int start, int end) {

        if (start >= end) {
        } else {

            int size = (end - start) / 3;
            int q1 = start + size;
            int q2 = q1 + size + 1;

            cantor(start, q1);
            for (int i = q1 + 1; i <= q2; i++) arr[i] = '\u0000';
            cantor(q2 + 1, end);

        }

    }
}
