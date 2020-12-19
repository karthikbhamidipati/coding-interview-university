package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OddCelebrations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Map<Integer, Integer> counter = new HashMap<>();
        for (String val : br.readLine().split(" ")) {
            int value = Integer.parseInt(val);
            int count = counter.getOrDefault(value, 0);
            counter.put(value, count + 1);
        }
        System.out.println(counter.values().stream().filter(num -> num % 2 != 0).count());
    }
}
