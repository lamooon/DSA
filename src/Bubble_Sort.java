import java.io.*;
import java.util.*;
public class Bubble_Sort {

    //bubble sort: put largest element at the back, then second largest at second last position
    public static void main (String[] args) throws IOException {

        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int num;
        int index = 0;
        while (st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            arr[index] = num;
            index++;
        }

        //process
        int numOfSwaps = 0;
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    numOfSwaps++;
                    swap(arr, j, j + 1);
                }
            }
        }

        System.out.println(numOfSwaps);
        //System.out.println(n * (n - 1) / 2);
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
