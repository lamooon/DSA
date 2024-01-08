
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge_sort_v1 {

    static int targ = 0;
    static int[] tmp;
    static int target;
    static int result = -1;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tmp = new int[n];
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(result);

    }

    private static void merge_sort(int[] arr,  int l, int r) {

        if (l < r) {
            int m = (r + l) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {

        int i = l;
        int j = m + 1;
        int t = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {

                tmp[t++] = arr[i++];
            }

            else {
                tmp[t++] = arr[j++];
            }
        }

        while (i <= m) {
            tmp[t++] = arr[i++];
        }


        while (j <= r) {
            tmp[t++] = arr[j++];
        }

        i = l;
        t = 0;
        while (i <= r) {

            arr[i++] = tmp[t++];
            targ++;
            if (targ == target) {
                result = tmp[t - 1];
                break;
            }

        }
    }
}