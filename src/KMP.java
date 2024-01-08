import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //building P
        String substr = "IO";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            sb.append(substr);
        }
        sb.append("I");

        String pattern = sb.toString();
        int m = Integer.parseInt(br.readLine());
        String inputString = br.readLine();

        //count substring
        int count = 0;

        KMP(pattern, inputString);

    }

    public static void KMP(String pattern, String inputString) {

        //preprocessing
        final int M = pattern.length();
        final int N = inputString.length();
        int[] lps = new int[M];

        for (int i = 0; i < M; i++) lps[i] = 0;
        preprocess(pattern, M, lps);

        //searching using KMP algo
        int count = 0;
        int i = 0, j = 0;
        while (i < N) {
            if (inputString.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else
            {
                if (j == 0) {
                    i++;
                }
                else
                {
                    j = lps[j - 1];
                }
            }

            //if found
            if (j == M) {
                count++;
                j = lps[j - 1];
            }
        }
        System.out.println(count);
    }
    public static void preprocess(String pattern, int M, int[] lps) {

        int i = 1, j = 0;
        lps[0] = 0;

        while (i < M) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                lps[i] = j + 1;
                i++;
                j++;
            }
            else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                }
                else j = lps[j - 1];
                }
            }
        }
    }