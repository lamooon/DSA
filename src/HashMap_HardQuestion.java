import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/20920
public class HashMap_HardQuestion {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;
            //if key doesn't exist, it will set count to 1 otherwise it will increase counter by 1
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        /*
         made new Comparator >> same as Collections.sort(words, new Comparator<String>)

         and then implement function
        */
        words.sort((word1, word2) -> {
            if (map.get(word1).equals(map.get(word2))) {

                if (word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                }
                return word2.length() - word1.length();
            }
            return map.get(word2) - map.get(word1);
        });

        for (String word : words) {
            bw.write(word + '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }


}