import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ModeUsingHashMap {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        int modeCount = 0;
        int sum = 0;
        int highestModeCount = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i != n - 1 && arr[i] == arr[i + 1]) {
                modeCount++;
            } else {
                if (highestModeCount < modeCount + 1) highestModeCount = modeCount + 1;
                m.putIfAbsent(modeCount + 1, new ArrayList<>());
                ArrayList<Integer> addMore = m.get(modeCount + 1);
                addMore.add(arr[i]);
                modeCount = 0;
            }
        }

        int getMaxKey = 0;

        for (int i : m.keySet()) {
            if (i > getMaxKey) getMaxKey = i;
        }

        ArrayList<Integer> l = m.get(getMaxKey);
        int mode = -1;

        if (l.size() == 1) mode = l.get(0);
        else mode = l.get(1);
        double avg = 1.0 * sum / n;
        long average = Math.round(avg);

        int range = arr[n - 1] - arr[0];
        int median = arr[n / 2];

        System.out.println(average);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}